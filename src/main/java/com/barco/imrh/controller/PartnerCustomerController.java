package com.barco.imrh.controller;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.PartnerCustomerDto;
import com.barco.imrh.service.PartnerCustomerService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ConstantUtils.PartnerCustomerControllerConst;
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
@CrossOrigin(origins = PartnerCustomerControllerConst.ORIGINS)
@RequestMapping(PartnerCustomerControllerConst.IMRH_PARTNER_CUSTOMER)
public class PartnerCustomerController {

    public Logger logger = LogManager.getLogger(PartnerCustomerController.class);

    @Autowired
    private PartnerCustomerService partnerCustomerService;

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.SEARCH_CUSTOMER_MSISDN, method = RequestMethod.POST)
    public GenericResponseDto<Object> searchCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request searchCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.searchCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while searchCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.FETCH_CUSTOMER_MSISDN, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchCustomerMsisdn(@RequestParam(name = "pageNumber") Integer pageNumber,
        @RequestParam(name = "pageSize") Integer pageSize) {
        try {
            logger.info("Request fetchCustomerMsisdn ==> " + String.format("pageNumber %d, pageSize %d", pageNumber, pageSize));
            return this.partnerCustomerService.fetchCustomerMsisdn(pageNumber, pageSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.CREATE_CUSTOMER_MSISDN, method = RequestMethod.POST)
    public GenericResponseDto<Object> createCustomerMsisdn(@RequestBody Set<PartnerCustomerDto> partnerCustomer) {
        try {
            logger.info("Request createCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.createCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.UPDATE_PARTNER_CUSTOMER_MSISDN, method = RequestMethod.POST)
    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request updatePartnerCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.updatePartnerCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updatePartnerCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.DELETE_PARTNER_CUSTOMER_MSISDN, method = RequestMethod.POST)
    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(@RequestBody PartnerCustomerDto partnerCustomer) {
        try {
            logger.info("Request deletePartnerCustomerMsisdn ==> " + partnerCustomer);
            return this.partnerCustomerService.deletePartnerCustomerMsisdn(partnerCustomer);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deletePartnerCustomerMsisdn", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.DOWNLOAD_MTO_PARTNER_CUSTOMER, method = RequestMethod.GET)
    public ResponseEntity<?> downloadMtoPartnerCustomer() {
        try {
            logger.info("Request downloadMtoPartnerCustomer");
            return this.partnerCustomerService.downloadMtoPartnerCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                       .series().name(), ConstantUtils.SOME_INTERNAL_ERROR), HttpStatus.OK);
        }
    }

    // working
    @RequestMapping(value = PartnerCustomerControllerConst.UPLOAD_MTO_PARTNER_CUSTOMER, method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(@RequestParam(name = "file") MultipartFile file) {
        try {
            logger.info("Request uploadMtoPartnerCustomer File " + file.getOriginalFilename());
            if (!file.getContentType().equalsIgnoreCase(ConstantUtils.DOC_TYPE)) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                   ConstantUtils.UPLOAD_ONLY_XLSX_EXTENSION_FILE);
            }
            return this.partnerCustomerService.uploadMtoPartnerCustomer(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadMtoPartnerCustomer", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                   .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

}