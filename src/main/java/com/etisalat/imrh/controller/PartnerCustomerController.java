package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import com.etisalat.imrh.service.PartnerCustomerService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Nabeel Ahmed
 */
@RestController
@RequestMapping("/imrh/partnerCustomer")
@CrossOrigin(origins = "http://localhost:4200")
public class PartnerCustomerController {

    public Logger logger = LogManager.getLogger(PartnerCustomerController.class);

    @Autowired
    private PartnerCustomerService partnerCustomerService;

    @RequestMapping(value = "/searchCustomerMsisdn", method = RequestMethod.POST)
    public GenericResponseDto<Object> searchCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            return this.partnerCustomerService.searchCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while searchCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(value = "/downloadMtoPartnerCustomer", method = RequestMethod.GET)
    public ResponseEntity<?> downloadMtoPartnerCustomer() {
        try {
            return this.partnerCustomerService.downloadMtoPartnerCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
            "Some Internal error accrue contact with support team."), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/uploadMtoPartnerCustomer", method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(@RequestParam(name = "file") MultipartFile file) {
        try {
            return this.partnerCustomerService.uploadMtoPartnerCustomer(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}