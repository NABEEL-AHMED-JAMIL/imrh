package com.barco.imrh.controller;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.enums.Report;
import com.barco.imrh.service.ReportService;
import com.barco.imrh.service.ResourceService;
import com.barco.imrh.util.CommonUtils;
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
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/resource")
public class ResourceController {

    public Logger logger = LogManager.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ReportService reportService;

    // working
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadFile(@RequestParam(name = "file") MultipartFile file,
        @RequestParam(name = "folderName") String folderName) {
        try {
            logger.info("Request uploadFile fileName " + file.getOriginalFilename());
            return this.resourceService.uploadFile(file, folderName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/download/image/file-name", method = RequestMethod.GET)
    public ResponseEntity<?> downloadImageFile(@RequestParam(name = "fileName") String fileName) {
        try {
            logger.info("Request downloadImageFile fileName " + fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + fileName);
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(this.resourceService.downloadImageFile(fileName).toByteArray()));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadImageFile", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team."), HttpStatus.OK);
        }
    }

    // working
    @RequestMapping(value = "/delete/image/file-name", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteImageFile(@RequestParam(name = "fileName") String fileName) {
        try {
            logger.info("Request deleteImageFile fileName " + fileName);
            return this.resourceService.deleteImageFile(fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteImageFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/downloadFileXlsx/file-name", method = RequestMethod.GET)
    public ResponseEntity<?> downloadFileXlsx(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadFileXlsx fileName " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename=%s", report+".xlsx"));
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
                           HttpStatus.BAD_REQUEST.series().name(), "Report not found."));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadFileXlsx", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team."));
        }
    }

    // working
    @RequestMapping(value = "/downloadFilePdf/file-name", method = RequestMethod.GET)
    public ResponseEntity<?> downloadFilePdf(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadFilePdf report " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename=%s", report+".pdf"));
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
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
                            HttpStatus.BAD_REQUEST.series().name(), "Report not found."));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadFilePdf", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                            "Some Internal error accrue contact with support team."));
        }
    }

    @RequestMapping(value = "/downloadJasperFile/file-name", method = RequestMethod.GET)
    public ResponseEntity<?> downloadJasperFile(@RequestParam(name = "report") Report report) {
        try {
            logger.info("Request downloadJasperFile report " + report);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename=%s", report+".pdf"));
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(this.reportService.downloadJasperFile(report));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadJasperFile", ExceptionUtil.getRootCause(ex));
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                        "Some Internal error accrue contact with support team."));
        }
    }

}