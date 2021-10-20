package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import com.etisalat.imrh.repository.PartnerCustomerRepository;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.repository.projection.PartnerCustomerProjection;
import com.etisalat.imrh.repository.query.EntityQuery;
import com.etisalat.imrh.service.PartnerCustomerService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.repository.validate.MtoPartnerCustomerValidation;
import com.etisalat.imrh.util.PoiWorkBookUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Customer msisdn missing.");
        }
        return CommonUtils.getResponseWithData(this.partnerCustomerRepository.fetchAllCustomerDetail(partnerCustomer.getCustomerNumber()),
            HttpStatus.OK.series().name(), null, "Partner customer fetch successfully.");
    }

    @Override
    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "Partner customer id missing.");
        } else if (CommonUtils.isNull(partnerCustomer.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner id missing.");
        }
        return CommonUtils.getResponseWithData(this.partnerCustomerRepository
            .updatePartnerCustomerMsisdn(partnerCustomer.getPartnerId(), partnerCustomer.getCustomerId()),
            HttpStatus.OK.series().name(), null, "Partner customer update successfully.");
    }

    @Override
    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "Partner customer id missing.");
        }
        this.partnerCustomerRepository.deletePartnerCountryByCountryCode(partnerCustomer.getCustomerId());
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format("Partner customer delete successfully with %d.", partnerCustomer.getCustomerId()));
    }

    @Override
    public ResponseEntity<?> downloadMtoPartnerCustomer() throws IOException {
        this.workbook = new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // fill the header
        // create the sheet for work-book
        XSSFSheet mtoPartnerCustomerSheet = this.workbook.createSheet("Mto Partner Customer");
        CellStyle cellStyle = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCustomerSheet);
        Row headerRow = mtoPartnerCustomerSheet.createRow(0);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle, 0, 20*255,
            "MSISDN", null, false);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle, 1, 30*255,
            "Mto Partner Id", null, false);
        this.fillHeading(mtoPartnerCustomerSheet, headerRow, cellStyle, 2, 40*255,
            "Mto Partner name", null, false);
        // fill the body
        List<PartnerCustomerProjection> partnerCustomerProjectionList =  this.partnerCustomerRepository.fetchAllCustomerDetail();
        if (partnerCustomerProjectionList.size() > 0) {
            CellStyle simpleStyle = this.cellBodyColorStyle(mtoPartnerCustomerSheet);
            Integer rows = 1;
            for (PartnerCustomerProjection partnerCustomerProjection: partnerCustomerProjectionList) {
                Row row = mtoPartnerCustomerSheet.createRow(rows);
                this.fillCellValue(0, row, simpleStyle, partnerCustomerProjection.getPartnerCustomer());
                this.fillCellValue(1, row, simpleStyle, partnerCustomerProjection.getPartnerId());
                this.fillCellValue(2, row, simpleStyle, partnerCustomerProjection.getPartnerName());
                rows = rows+1;
            }
        }
        this.workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        this.workbook.close();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Mto Partner Customer.xlsx");
        headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
    }

    @Override
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) throws IOException {
        this.workbook = new XSSFWorkbook(file.getInputStream());
        if (this.workbook == null || this.workbook.getNumberOfSheets() == 0) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "You upload empty source file.");
        }
        XSSFSheet sheet = this.workbook.getSheet("Mto Partner Customer");
        if (sheet != null) {
            if (sheet.getLastRowNum() < 1) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "You can't upload empty source file.");
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
                            "Source at row " + (currentRow.getRowNum() + 1) + " some headings missing (MSISDN,Mto Partner Id).");
                    } else if (!currentRow.getCell(0).getStringCellValue().equals("MSISDN")) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                        "Source at row " + (currentRow.getRowNum() + 1) + " MSISDN headings missing.");
                    } else if (!currentRow.getCell(1).getStringCellValue().equals("Mto Partner Id")) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                        "Source at row " + (currentRow.getRowNum() + 1) + " Mto Partner Id headings missing.");
                    }
                } else if (currentRow.getRowNum() > 0) {
                    MtoPartnerCustomerValidation mtoPartnerCustomerValidation = new MtoPartnerCustomerValidation();
                    // first col get the customer phone number
                    Cell currentCell = currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(Cell.CELL_TYPE_STRING);
                    if (CommonUtils.isNull(currentCell.getStringCellValue())) {
                        errors.add("Source at row " + (currentRow.getRowNum() + 1) + " MSISDN missing.");
                    } else {
                        mtoPartnerCustomerValidation.setCustomerNumber(currentCell.getStringCellValue());
                    }
                    // second col get the partner detail
                    currentCell = currentRow.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(Cell.CELL_TYPE_STRING);
                    // validate process
                    if (CommonUtils.isNull(currentCell.getStringCellValue())) {
                        errors.add("Source at row " + (currentRow.getRowNum() + 1) + " Mto Partner Id missing.");
                    } else if (!currentCell.getStringCellValue().chars().allMatch(Character::isDigit)) {
                        errors.add("Source at row " + (currentRow.getRowNum() + 1) + " Mto Partner Id " +
                            currentCell.getStringCellValue() + " should be valid digit id.");
                    } else if (!this.partnerRepository.existsById(Long.valueOf(currentCell.getStringCellValue()))) {
                        errors.add("Source at row " + (currentRow.getRowNum() + 1) + " Mto Partner Id " +
                            currentCell.getStringCellValue() + " should be valid partner id.");
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
                return CommonUtils.getResponseWithData(errors, HttpStatus.BAD_REQUEST.series().name(),
                    null, "Source validation fail.");
            }
            // return if no error then process detail in thread
            this.processMtoPartnerCustomerFileDetail(mtoPartnerCustomerValidations);
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                "Source file successfully validate and processing in backend.");
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            "Sheet not found with (Mto Partner Customer).");
    }

    /**
     * Method use to truncate the old data and insert the new data
     * */
    public void processMtoPartnerCustomerFileDetail(Set<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations) {
        Thread thread1 = new Thread(() -> {
            try {
                if (mtoPartnerCustomerValidations.size() > 0) {
                    // truncate the partner customer
                    this.partnerCustomerRepository.truncatePartnerCustomer();
                    // add new data into mto partner customer
                    this.queryUtils.executeInsertQuery(this.queryUtils.mtoPartnerCountryQuery(mtoPartnerCustomerValidations));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        thread1.start();
    }
}
