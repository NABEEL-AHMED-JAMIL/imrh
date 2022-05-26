package com.barco.imrh.controller;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.enums.Report;
import com.barco.imrh.service.ReportService;
import com.barco.imrh.service.ResourceService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ConstantUtils.ResourceControllerConst;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = ResourceControllerConst.ORIGINS)
@RequestMapping(ResourceControllerConst.IMRH_RESOURCE)
public class ResourceController {

    public Logger logger = LogManager.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ReportService reportService;

    // working
    @RequestMapping(value = ResourceControllerConst.UPLOAD_FILE, method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadFile(@RequestParam(name = "file") MultipartFile file,
        @RequestParam(name = "folderName") String folderName) {
        try {
            logger.info("Request uploadFile fileName " + file.getOriginalFilename());
            return this.resourceService.uploadFile(file, folderName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = ResourceControllerConst.DOWNLOAD_IMAGE_FILE_NAME, method = RequestMethod.GET)
    public ResponseEntity<?> downloadImageFile(@RequestParam(name = "fileName") String fileName) {
        try {
            logger.info("Request downloadImageFile fileName " + fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.add(ConstantUtils.HEADER_NAME, String.format(ConstantUtils.HEADER_VALUE, fileName));
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(this.resourceService.downloadImageFile(fileName).toByteArray()));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadImageFile", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                   .series().name(), ConstantUtils.SOME_INTERNAL_ERROR), HttpStatus.OK);
        }
    }

    // working
    @RequestMapping(value = ResourceControllerConst.DELETE_IMAGE_FILE_NAME, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteImageFile(@RequestParam(name = "fileName") String fileName) {
        try {
            logger.info("Request deleteImageFile fileName " + fileName);
            return this.resourceService.deleteImageFile(fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteImageFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = ResourceControllerConst.DOWNLOAD_FILE_XLSX_FILE_NAME, method = RequestMethod.GET)
    public ResponseEntity<?> downloadFileXlsx(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadFileXlsx fileName " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add(ConstantUtils.HEADER_NAME, String.format(ConstantUtils.HEADER_VALUE, report+ConstantUtils.DOT_XLSX));
            switch (report) {
                case MtoPartnerCountryReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(new InputStreamResource(this.reportService.fetchMtoPartnerCountryViewXlsx()));
                case MtoPartnerCountryCityReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(new InputStreamResource(this.reportService.fetchMtoPartnerCountryCityViewXlsx()));
                case MtoPartnerCountryWalletReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(new InputStreamResource(this.reportService.fetchMtoPartnerCountryWalletViewXlsx()));
                case MtoPartnerCountryBankReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(new InputStreamResource(this.reportService.fetchMtoPartnerCountryBankViewXlsx()));
                case GlobalCountryDetailReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(new InputStreamResource(this.reportService.fetchAllGlobalCountryDetailForReportViewXlsx()));
                default:
                    return ResponseEntity.ok().body(CommonUtils.getResponseWithStatusAndMessageOnly(
                           HttpStatus.BAD_REQUEST.series().name(), ConstantUtils.REPORT_NOT_FOUND));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadFileXlsx", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(CommonUtils.getResponseWithStatusAndMessageOnly(
                   HttpStatus.INTERNAL_SERVER_ERROR.series().name(), ConstantUtils.SOME_INTERNAL_ERROR));
        }
    }

    // working
    @RequestMapping(value = ResourceControllerConst.DOWNLOAD_FILE_PDF_FILE_NAME, method = RequestMethod.GET)
    public ResponseEntity<?> downloadFilePdf(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadFilePdf report " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add(ConstantUtils.HEADER_NAME, String.format(ConstantUtils.HEADER_VALUE, report+ConstantUtils.DOT_PDF));
            headers.setContentType(MediaType.parseMediaType(ConstantUtils.PDF_MEDIA_TYPE));
            switch (report) {
                case MtoPartnerCountryReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(this.reportService.fetchMtoPartnerCountryViewPdf().toByteArray());
                case MtoPartnerCountryCityReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(this.reportService.fetchMtoPartnerCountryCityViewPdf().toByteArray());
                case MtoPartnerCountryWalletReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(this.reportService.fetchMtoPartnerCountryWalletViewPdf().toByteArray());
                case MtoPartnerCountryBankReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(this.reportService.fetchMtoPartnerCountryBankViewPdf().toByteArray());
                case GlobalCountryDetailReport:
                    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(this.reportService.fetchAllGlobalCountryDetailForReportViewPdf().toByteArray());
                default:
                    return ResponseEntity.ok().body(CommonUtils.getResponseWithStatusAndMessageOnly(
                            HttpStatus.BAD_REQUEST.series().name(), ConstantUtils.REPORT_NOT_FOUND));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadFilePdf", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.INTERNAL_SERVER_ERROR.series().name(), ConstantUtils.SOME_INTERNAL_ERROR));
        }
    }

    @RequestMapping(value = ResourceControllerConst.DOWNLOAD_JASPER_FILE_FILE_NAME, method = RequestMethod.GET)
    public ResponseEntity<?> downloadJasperFile(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadJasperFile report " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add(ConstantUtils.HEADER_NAME, String.format(ConstantUtils.HEADER_VALUE, report+ConstantUtils.DOT_PDF));
            headers.setContentType(MediaType.parseMediaType(ConstantUtils.PDF_MEDIA_TYPE));
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(this.reportService.downloadJasperFile(report));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadJasperFile", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.INTERNAL_SERVER_ERROR.series().name(), ConstantUtils.SOME_INTERNAL_ERROR));
        }
    }

}