package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import com.etisalat.imrh.repository.PartnerCustomerRepository;
import com.etisalat.imrh.repository.projection.PartnerCustomerProjection;
import com.etisalat.imrh.repository.query.EntityQuery;
import com.etisalat.imrh.service.PartnerCustomerService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.MtoPartnerCustomerValidation;
import com.etisalat.imrh.util.PoiWorkBookUtil;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class PartnerCustomerServiceImpl extends PoiWorkBookUtil implements PartnerCustomerService {

    private XSSFWorkbook workbook;
    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;
    @Autowired
    private EntityQuery queryUtils;

    @Override
    public GenericResponseDto<Object> searchCustomerMsisdn(PartnerCustomerDto partnerCustomer) {
        if (CommonUtils.isNull(partnerCustomer.getCustomerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Customer id missing.");
        }
        return null;
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
                "You uploaded empty file.");
        }
        XSSFSheet sheet = this.workbook.getSheet("Mto Partner Customer");
        if (sheet != null) {
            if (sheet.getLastRowNum() < 1) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                        "You can't upload empty file.");
            }
            List<String> errors = new ArrayList<>();
            List<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations = new ArrayList<>();
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (currentRow.getRowNum() == 0) {
                    if (currentRow.getPhysicalNumberOfCells() != 2 && currentRow.getPhysicalNumberOfCells() != 2) {
                        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            "Customer source at row " + (currentRow.getRowNum()) + " some headings missing.");
                    } else if (currentRow.getPhysicalNumberOfCells() == 2) {
                        if (!currentRow.getCell(0).getStringCellValue().equals("MSISDN")) {
                            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            "Customer source at row " + (currentRow.getRowNum()) + " MSISDN headings missing.");
                        }
                        if (!currentRow.getCell(1).getStringCellValue().equals("Mto Partner Id")) {
                            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                            "Customer source at row " + (currentRow.getRowNum()) + " Mto Partner Id headings missing.");
                        }
                    }
                } else if (currentRow.getRowNum() > 1) {
                    MtoPartnerCustomerValidation mtoPartnerCustomerValidation = new MtoPartnerCustomerValidation();
                    Cell currentCell = currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(Cell.CELL_TYPE_STRING);
                    mtoPartnerCustomerValidation.setCustomerNumber(currentCell.getStringCellValue());

                    currentCell = currentRow.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    currentCell.setCellType(Cell.CELL_TYPE_STRING);
                    mtoPartnerCustomerValidation.setPartnerId(Long.valueOf(currentCell.getStringCellValue()));
                    // validate the mtoPartner Detail and add to the partner customer
                    mtoPartnerCustomerValidations.add(mtoPartnerCustomerValidation);
                }
            }
            if (errors.size() > 0) {
                // return work if error have
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "Sheet not found with (Mto Partner Customer).");
            }
            // return if no error then process detail in thread
            this.processMtoPartnerCustomerFileDetail(mtoPartnerCustomerValidations);
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner Customer file successfully validate and processing in backend.");
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            "Sheet not found with (Mto Partner Customer).");
    }

    /**
     * Method use to truncate the old data and insert the new data
     * */
    public void processMtoPartnerCustomerFileDetail(List<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations) {
        Thread thread1 = new Thread(() -> {
            try {
                // truncate the partner customer
                this.partnerCustomerRepository.truncatePartnerCustomer();
                // add new data into mto partner customer
                this.queryUtils.executeInsertQuery(this.queryUtils.mtoPartnerCountryQuery(mtoPartnerCustomerValidations));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        thread1.start();
    }
}
