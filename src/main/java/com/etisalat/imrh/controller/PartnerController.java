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

    @RequestMapping(path = "/enableDisablePartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisablePartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.enableDisablePartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisablePartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllPartner(@RequestParam(name = "enable") Enable enable) {
        try {
            return this.partnerService.enableDisableAllPartner(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllPartner", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllPartner() {
        try {
            return this.partnerService.fetchAllPartner();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updatePartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> updatePartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.updatePartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updatePartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deletePartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deletePartner(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            return this.partnerService.deletePartner(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deletePartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

}
