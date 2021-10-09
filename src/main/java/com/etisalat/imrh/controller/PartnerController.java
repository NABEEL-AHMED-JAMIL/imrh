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
import java.util.List;

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

    /**
     * User will send the partner id and partner name with country code and country name
     * */
    @RequestMapping(path = "/attachMtoCountryWithMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoCountryWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.attachMtoCountryWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoCountryWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    /**
     * User will send the partner id and partner name with city id and city name
     * */
    @RequestMapping(path = "/attachMtoCityWithMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.attachMtoCityWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoCityWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    /**
     * User will send the partner id and partner name with wallet id and wallet name
     * */
    @RequestMapping(path = "/attachMtoWalletWithMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.attachMtoWalletWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoWalletWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    /**
     * User will send the partner id and partner name with bank id and bank name
     * */
    @RequestMapping(path = "/attachMtoBankWithMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            return this.partnerService.attachMtoBankWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoBankWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

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

    @RequestMapping(path = "/findMtoCountryByMtoPartnerId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoCountryByMtoPartnerId(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            return this.partnerService.findMtoCountryByMtoPartnerId(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoCountryByMtoPartnerId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findMtoCityByMtoPartnerIdAndMtoCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoCityByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.partnerService.findMtoCityByMtoPartnerIdAndMtoCountryCode(partnerId,countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoCityByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findMtoWalletByMtoPartnerIdAndMtoCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoWalletByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.partnerService.findMtoWalletByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoWalletByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findMtoBankByMtoPartnerIdAndMtoCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoBankByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.partnerService.findMtoBankByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoBankByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
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

    @RequestMapping(path = "/updatePreferenceOrderForMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList) {
        try {
            return this.partnerService.updatePreferenceOrderForMtoPartner(partnerDtoList);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updatePreferenceOrderForMtoPartner", ExceptionUtil.getRootCause(ex));
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

    @RequestMapping(path = "/deleteMtoCountryLinkMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.partnerService.deleteMtoCountryLinkMtoPartner(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoCountryLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteMtoCityLinkMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "cityId") Long cityId) {
        try {
            return this.partnerService.deleteMtoCityLinkMtoPartner(partnerId, cityId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoCityLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteMtoWalletLinkMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "walletId") Long walletId) {
        try {
            return this.partnerService.deleteMtoWalletLinkMtoPartner(partnerId, walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoWalletLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteMtoBankLinkMtoPartner", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "bankId") Long bankId) {
        try {
            return this.partnerService.deleteMtoBankLinkMtoPartner(partnerId, bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoBankLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}