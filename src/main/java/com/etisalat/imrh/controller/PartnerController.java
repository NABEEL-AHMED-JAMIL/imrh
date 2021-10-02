package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.PartnerService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@RequestMapping("/imrh/partner")
@CrossOrigin(origins = "http://localhost:4200")
public class PartnerController {

    public Logger logger = LogManager.getLogger(PartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @RequestMapping(path = "/enableDisableMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.enableDisableMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllMtoPartner(@RequestParam(name = "enable") Enable enable) {
        try {
            return this.partnerService.enableDisableAllMtoPartner(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllMtoPartner", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllMtoPartner() {
        try {
            return this.partnerService.fetchAllMtoPartner();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findByMtoPartnerId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByMtoPartnerId(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            return this.partnerService.findByMtoPartnerId(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByMtoPartnerId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updateMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.updateMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoPartner(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            return this.partnerService.deleteMtoPartner(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

}
