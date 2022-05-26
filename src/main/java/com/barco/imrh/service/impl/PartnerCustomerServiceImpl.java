package com.barco.imrh.service.impl;

import com.barco.imrh.repository.PartnerCustomerRepository;
import com.barco.imrh.repository.PartnerRepository;
import com.barco.imrh.repository.projection.PartnerCustomerProjection;
import com.barco.imrh.repository.query.EntityQuery;
import com.barco.imrh.repository.validate.MtoPartnerCustomerValidation;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.PartnerCustomerDto;
import com.barco.imrh.entity.PartnerCustomer;
import com.barco.imrh.service.PartnerCustomerService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.PoiWorkBookUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class PartnerCustomerServiceImpl extends PoiWorkBookUtil implements PartnerCustomerService {

    public Logger logger = LogManager.getLogger(PartnerCustomerServiceImpl.class);

    private XSSFWorkbook workbook;
    @Autowired
    private EntityQuery queryUtils;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;

    @Override
    public GenericResponseDto<Object> searchCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerNumber())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.
                BAD_REQUEST.series().name(), CUSTOMER_MSISDN_MISSING);
        } else if (!CommonUtils.isValidMsisdn(partnerCustomer.getCustomerNumber())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.
                BAD_REQUEST.series().name(), CUSTOMER_MSISDN_NOT_VALID);
        }
        return CommonUtils.getResponseWithData(this.partnerCustomerRepository.fetchAllCustomerDetail(
            partnerCustomer.getCustomerNumber()), HttpStatus.OK.series().name(), PARTNER_CUSTOMER_FETCH_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> fetchCustomerMsisdn(Integer pageNumber, Integer pageSize) {
        Page<PartnerCustomerProjection> partnerCustomerProjections = this.partnerCustomerRepository
            .fetchAllCustomerDetailWithPage(PageRequest.of(pageNumber, pageSize));
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put(CONTENT, partnerCustomerProjections.getContent());
        responseMap.put(PAGE_NUMBER, partnerCustomerProjections.getPageable().getPageNumber());
        responseMap.put(PAGE_SIZE, partnerCustomerProjections.getPageable().getPageSize());
        responseMap.put(TOTAL_ELEMENTS, partnerCustomerProjections.getTotalElements());
        responseMap.put(TOTAL_PAGES, partnerCustomerProjections.getTotalPages());
        return CommonUtils.getResponseWithData(responseMap, HttpStatus.OK.series().name(), PARTNER_CUSTOMER_FETCH_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> createCustomerMsisdn(Set<PartnerCustomerDto> partnerCustomerSet) {
        for (PartnerCustomerDto partnerCustomer: partnerCustomerSet) {
            if (CommonUtils.isNull(partnerCustomer.getCustomerNumber())) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                    .BAD_REQUEST.series().name(), CUSTOMER_MSISDN_MISSING);
            } else if (!CommonUtils.isValidMsisdn(partnerCustomer.getCustomerNumber())) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                    .BAD_REQUEST.series().name(), CUSTOMER_MSISDN_NOT_VALID);
            } else if (CommonUtils.isNull(partnerCustomer.getPartnerId())) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                    .BAD_REQUEST.series().name(), PARTNER_ID_MISSING);
            } else if (!this.partnerRepository.existsById(partnerCustomer.getPartnerId())) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                    .BAD_REQUEST.series().name(), PARTNER_NOT_EXIST);
            } else if (!this.partnerCustomerRepository.fetchAllCustomerDetail(partnerCustomer.getCustomerNumber()).isEmpty()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                     String.format(CUSTOMER_MSISDN_LINKED_WITH_OTHER_PARTNER, partnerCustomer.getCustomerNumber()));
            }
        }
        this.partnerCustomerRepository.saveAll(partnerCustomerSet.stream()
            .map(partnerCustomerDto -> {
                PartnerCustomer partnerCustomer = new PartnerCustomer();
                partnerCustomer.setCustomerNumber(partnerCustomerDto.getCustomerNumber());
                partnerCustomer.setPartner(this.partnerRepository.getById(partnerCustomerDto.getPartnerId()));
                return partnerCustomer;
            }).collect(Collectors.toList()));
        return CommonUtils.getResponseWithData(partnerCustomerSet, HttpStatus.OK.series().name(), CUSTOMER_MSISDN_SAVE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                 .BAD_REQUEST.series().name(), PARTNER_CUSTOMER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerCustomer.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                 .BAD_REQUEST.series().name(), PARTNER_ID_MISSING);
        }
        return CommonUtils.getResponseWithData(this.partnerCustomerRepository.updatePartnerCustomerMsisdn(
            partnerCustomer.getPartnerId(), partnerCustomer.getCustomerId()), HttpStatus.OK.series().name(),
            PARTNER_CUSTOMER_UPDATE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                .BAD_REQUEST.series().name(), PARTNER_CUSTOMER_ID_MISSING);
        }
        this.partnerCustomerRepository.deletePartnerCountryByCountryCode(partnerCustomer.getCustomerId());
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format(PARTNER_CUSTOMER_DELETE_SUCCESSFULLY_WITH_ID, partnerCustomer.getCustomerId()));
    }

    @Override
    public ResponseEntity<?> downloadMtoPartnerCustomer() throws IOException {
        this.workbook = new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // fill the header
        // create the sheet for work-book
        XSSFSheet mtoPartnerCustomerSheet = this.workbook.createSheet(MTO_PARTNER_CUSTOMER);
        CellStyle cellStyle = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCustomerSheet);
        Row headerRow = mtoPartnerCustomerSheet.createRow(0);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle,
            0, 20*255, MSISDN, null, false);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle,
            1, 30*255, MTO_PARTNER_ID, null, false);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle,
            2, 40*255, MTO_PARTNER_NAME, null, false);
        // fill the body
        List<PartnerCustomerProjection> partnerCustomerProjectionList =  this.partnerCustomerRepository.fetchAllCustomerDetail();
        if (partnerCustomerProjectionList.size() > 0) {
            CellStyle simpleStyle = this.cellBodyColorStyle(mtoPartnerCustomerSheet);
            Integer rows = 1;
            for (PartnerCustomerProjection partnerCustomerProjection: partnerCustomerProjectionList) {
                int fillCellCount = 0;
                Row row = mtoPartnerCustomerSheet.createRow(rows);
                this.fillCellValue(fillCellCount, row, simpleStyle, partnerCustomerProjection.getPartnerCustomer());
                this.fillCellValue(++fillCellCount, row, simpleStyle, partnerCustomerProjection.getPartnerId());
                this.fillCellValue(++fillCellCount, row, simpleStyle, partnerCustomerProjection.getPartnerName());
                rows = rows+1;
            }
        }
        this.workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        this.workbook.close();
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_DISPOSITION, ATTACHMENT_FILENAME_MTO_PARTNER_CUSTOMER_XLSX);
        headers.add(CONTENT_TYPE, APPLICATION_VND_OPEN_XML_FORMATS_OFFICE_DOCUMENT_SPREAD_SHEET);
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
    }

    @Override
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) throws IOException {
        this.workbook = new XSSFWorkbook(file.getInputStream());
        if (this.workbook == null || this.workbook.getNumberOfSheets() == 0) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                  .BAD_REQUEST.series().name(), YOU_UPLOAD_EMPTY_SOURCE_FILE);
        }
        XSSFSheet sheet = this.workbook.getSheet(MTO_PARTNER_CUSTOMER);
        if (sheet != null) {
            if (sheet.getLastRowNum() < 1) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus
                    .BAD_REQUEST.series().name(), YOU_CONT_UPLOAD_EMPTY_SOURCE_FILE);
            }
            List<String> errors = new ArrayList<>();
            // we use set here bz we need to handle the unique row as per the ssd
            // Customer MSISDN should be unique on the file and linked to only one preferential MTO
            Set<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations = new HashSet<>();
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (currentRow.getRowNum() == 0) {
                    if (currentRow.getPhysicalNumberOfCells() != 2 && currentRow.getPhysicalNumberOfCells() != 2) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            String.format(SOURCE_AT_ROW_SOME_HEADINGS_MISSING,(currentRow.getRowNum() + 1)));
                    } else if (!currentRow.getCell(0).getStringCellValue().equals(MSISDN)) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            String.format(SOURCE_AT_ROW_MSISDN_HEADINGS_MISSING, (currentRow.getRowNum() + 1)));
                    } else if (!currentRow.getCell(1).getStringCellValue().equals(MTO_PARTNER_ID)) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            String.format(SOURCE_AT_ROW_MTO_PARTNER_ID_HEADINGS_MISSING, (currentRow.getRowNum() + 1)));
                    }
                } else if (currentRow.getRowNum() > 0) {
                    MtoPartnerCustomerValidation mtoPartnerCustomerValidation = new MtoPartnerCustomerValidation();
                    // first col get the customer phone number
                    Cell currentCell = currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(CellType.STRING);
                    if (CommonUtils.isNull(currentCell.getStringCellValue())) {
                        errors.add(String.format(SOURCE_AT_ROW_MSISDN_MISSING, (currentRow.getRowNum() + 1)));
                    } else if (!CommonUtils.isValidMsisdn(currentCell.getStringCellValue())) {
                        errors.add(String.format(SOURCE_AT_ROW_MSISDN_SHOULD_BE_VALID,
                            (currentRow.getRowNum() + 1), currentCell.getStringCellValue()));
                    } else {
                        mtoPartnerCustomerValidation.setCustomerNumber(currentCell.getStringCellValue());
                    }
                    // second col get the partner detail
                    currentCell = currentRow.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(CellType.STRING);
                    // validate process
                    if (CommonUtils.isNull(currentCell.getStringCellValue())) {
                        errors.add(String.format(SOURCE_AT_ROW_MTO_PARTNER_ID_MISSING, (currentRow.getRowNum() + 1)));
                    } else if (!currentCell.getStringCellValue().chars().allMatch(Character::isDigit)) {
                        errors.add(String.format(SOURCE_AT_ROW_MTO_PARTNER_ID_SHOULD_BE_VALID_DIGIT_ID,
                             (currentRow.getRowNum() + 1), currentCell.getStringCellValue()));
                    } else if (!this.partnerRepository.existsById(Long.valueOf(currentCell.getStringCellValue()))) {
                        errors.add(String.format(SOURCE_AT_ROW_MTO_PARTNER_ID_SHOULD_BE_VALID_PARTNER_ID,
                              (currentRow.getRowNum() + 1), currentCell.getStringCellValue()));
                    } else {
                        mtoPartnerCustomerValidation.setPartnerId(Long.valueOf(currentCell.getStringCellValue()));
                    }
                    // this will put the detail until the error size is zero if any error
                    if (errors.size() <= 0) {
                        mtoPartnerCustomerValidations.add(mtoPartnerCustomerValidation);
                        continue;
                    }
                    mtoPartnerCustomerValidations.clear();
                }
            }
            if (errors.size() > 0) {
                // return work if error have
                return CommonUtils.getResponseWithData(errors,
                    HttpStatus.BAD_REQUEST.series().name(), SOURCE_VALIDATION_FAIL);
            }
            // return if no error then process detail in thread
            this.processMtoPartnerCustomerFileDetail(mtoPartnerCustomerValidations);
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                    SOURCE_FILE_SUCCESSFULLY_VALIDATE_AND_PROCESSING_IN_BACKEND);
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                SHEET_NOT_FOUND_WITH_MTO_PARTNER_CUSTOMER);
    }

    /**
     * Method use to truncate the old data and insert the new data
     * */
    private void processMtoPartnerCustomerFileDetail(Set<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations) {
        Thread thread1 = new Thread(() -> {
            Iterable<PartnerCustomer> partnerCustomerList = null;
            try {
                if (mtoPartnerCustomerValidations.size() > 0) {
                    partnerCustomerList = this.partnerCustomerRepository.findAll();
                    // truncate the partner customer
                    this.partnerCustomerRepository.truncatePartnerCustomer();
                    // add new data into mto partner customer
                    this.queryUtils.executeInsertQuery(
                        this.queryUtils.mtoPartnerCountryQuery(mtoPartnerCustomerValidations));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                if (CommonUtils.isNull(partnerCustomerList)) {
                    logger.info("Old data role back....... start");
                    this.partnerCustomerRepository.saveAll(partnerCustomerList);
                    logger.info("Old data role back....... end");
                }
            }
        });
        thread1.start();
    }
}
