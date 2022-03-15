package com.barco.imrh.controller;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.PartnerCustomerDto;
import com.barco.imrh.service.PartnerCustomerService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/partnerCustomer")
public class PartnerCustomerController {

    public Logger logger = LogManager.getLogger(PartnerCustomerController.class);

    @Autowired
    private PartnerCustomerService partnerCustomerService;
    private final String DOC_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    // working
    @RequestMapping(value = "/searchCustomerMsisdn", method = RequestMethod.POST)
    public GenericResponseDto<Object> searchCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request searchCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.searchCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while searchCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/fetchCustomerMsisdn", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchCustomerMsisdn(@RequestParam(name = "pageNumber") Integer pageNumber,
        @RequestParam(name = "pageSize") Integer pageSize) {
        try {
            logger.info("Request fetchCustomerMsisdn ==> " + String.format("pageNumber %d, pageSize %d", pageNumber, pageSize));
            return this.partnerCustomerService.fetchCustomerMsisdn(pageNumber, pageSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/createCustomerMsisdn", method = RequestMethod.POST)
    public GenericResponseDto<Object> createCustomerMsisdn(@RequestBody Set<PartnerCustomerDto> partnerCustomer) {
        try {
            logger.info("Request createCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.createCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/updatePartnerCustomerMsisdn", method = RequestMethod.POST)
    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request updatePartnerCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.updatePartnerCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updatePartnerCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/deletePartnerCustomerMsisdn", method = RequestMethod.POST)
    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request deletePartnerCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.deletePartnerCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deletePartnerCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(value = "/downloadMtoPartnerCustomer", method = RequestMethod.GET)
    public ResponseEntity<?> downloadMtoPartnerCustomer() {
        try {
            logger.info("Request downloadMtoPartnerCustomer");
            return this.partnerCustomerService.downloadMtoPartnerCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
            "Some Internal error accrue contact with support team."), HttpStatus.OK);
        }
    }

    // working
    @RequestMapping(value = "/uploadMtoPartnerCustomer", method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(@RequestParam(name = "file") MultipartFile file) {
        try {
            logger.info("Request uploadMtoPartnerCustomer File " + file.getOriginalFilename());
            if (!file.getContentType().equalsIgnoreCase(DOC_TYPE)) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "You can upload only .xlsx extension file.");
            }
            return this.partnerCustomerService.uploadMtoPartnerCustomer(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}