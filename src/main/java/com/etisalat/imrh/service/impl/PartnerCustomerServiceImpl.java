package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import com.etisalat.imrh.repository.PartnerCustomerRepository;
import com.etisalat.imrh.repository.projection.PartnerCustomerProjection;
import com.etisalat.imrh.service.PartnerCustomerService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.PoiWorkBookUtil;
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
import java.util.List;

@Service
@Transactional
public class PartnerCustomerServiceImpl extends PoiWorkBookUtil implements PartnerCustomerService {

    private XSSFWorkbook workbook;
    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;

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
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) {
        return null;
    }
}
