package com.barco.imrh.controller;

import com.barco.imrh.dto.PartnerCountryProductDto;
import com.barco.imrh.dto.PartnerDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.PartnerService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.barco.imrh.util.ConstantUtils.PartnerControllerConst;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = PartnerControllerConst.ORIGINS)
@RequestMapping(PartnerControllerConst.IMRH_PARTNER)
public class PartnerController {

    public Logger logger = LogManager.getLogger(PartnerController.class);

    @Autowired
    private PartnerService partnerService;

    /**
     * User will send the partner id and partner name with country code and country name
     * */
    // working
    @RequestMapping(path = PartnerControllerConst.ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoCountryWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request attachMtoCountryWithMtoPartner ==> " + partnerDto);
            return this.partnerService.attachMtoCountryWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoCountryWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    /**
     * User will send the partner id and partner name with city id and city name
     * */
    // working
    @RequestMapping(path = PartnerControllerConst.ATTACH_MTO_CITY_WITH_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request attachMtoCityWithMtoPartner ==> " + partnerDto);
            return this.partnerService.attachMtoCityWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoCityWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    /**
     * User will send the partner id and partner name with wallet id and wallet name
     * */
    // working
    @RequestMapping(path = PartnerControllerConst.ATTACH_MTO_WALLET_WITH_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request attachMtoWalletWithMtoPartner ==> " + partnerDto);
            return this.partnerService.attachMtoWalletWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoWalletWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    /**
     * User will send the partner id and partner name with bank id and bank name
     * */
    // working
    @RequestMapping(path = PartnerControllerConst.ATTACH_MTO_BANK_WITH_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request attachMtoBankWithMtoPartner ==> " + partnerDto);
            return this.partnerService.attachMtoBankWithMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoBankWithMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    @RequestMapping(path = PartnerControllerConst.ATTACH_MTO_PARTNER_COUNTRY_PRODUCT, method = RequestMethod.POST)
    public GenericResponseDto<Object> attachMtoPartnerCountryProduct(@RequestBody PartnerCountryProductDto partnerCountryProductDto) {
        try {
            logger.info("Request attachMtoPartnerCountryProduct ==> " + partnerCountryProductDto);
            return this.partnerService.attachMtoPartnerCountryProduct(partnerCountryProductDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while attachMtoPartnerCountryProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.ENABLE_DISABLE_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request enableDisableMtoPartner ==> " + partnerDto);
            return this.partnerService.enableDisableMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.ENABLE_DISABLE_ALL_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllMtoPartner(@RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllMtoPartner enable ==> " + enable.name());
            return this.partnerService.enableDisableAllMtoPartner(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FETCH_ALL_MTO_PARTNER, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllMtoPartner() {
        try {
            logger.info("Request fetchAllMtoPartner");
            return this.partnerService.fetchAllMtoPartner();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FIND_BY_MTO_PARTNER_ID, method = RequestMethod.GET)
    public GenericResponseDto<Object> findByMtoPartnerId(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            logger.info("Request findByMtoPartnerId partnerId ==> " + partnerId);
            return this.partnerService.findByMtoPartnerId(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByMtoPartnerId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FIND_MTO_COUNTRY_BY_MTO_PARTNER_ID, method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoCountryByMtoPartnerId(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            logger.info("Request findMtoCountryByMtoPartnerId partnerId ==> " + partnerId);
            return this.partnerService.findMtoCountryByMtoPartnerId(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoCountryByMtoPartnerId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FIND_MTO_CITY_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoCityByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findMtoCityByMtoPartnerIdAndMtoCountryCode partnerId ==> " + partnerId);
            return this.partnerService.findMtoCityByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoCityByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    @RequestMapping(path = PartnerControllerConst.FIND_PRODUCT_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> findProductByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findProductByMtoPartnerIdAndMtoCountryCode partnerId ==> " + partnerId);
            return this.partnerService.findProductByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoCityByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FIND_MTO_WALLET_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoWalletByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findMtoWalletByMtoPartnerIdAndMtoCountryCode partnerId ==> " + partnerId);
            return this.partnerService.findMtoWalletByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoWalletByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.FIND_MTO_BANK_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> findMtoBankByMtoPartnerIdAndMtoCountryCode(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findMtoBankByMtoPartnerIdAndMtoCountryCode partnerId ==> " + partnerId);
            return this.partnerService.findMtoBankByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findMtoBankByMtoPartnerIdAndMtoCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.UPDATE_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> updateMtoPartner(@RequestBody PartnerDto partnerDto) {
        try {
            logger.info("Request updateMtoPartner ==> " + partnerDto);
            return this.partnerService.updateMtoPartner(partnerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.UPDATE_PREFERENCE_ORDER_FOR_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(@RequestBody List<PartnerDto> partnerDtoList) {
        try {
            logger.info("Request updatePreferenceOrderForMtoPartner ==> " + partnerDtoList);
            return this.partnerService.updatePreferenceOrderForMtoPartner(partnerDtoList);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updatePreferenceOrderForMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoPartner(@RequestParam(name = "partnerId") Long partnerId) {
        try {
            logger.info("Request deleteMtoPartner partnerId ==> " + partnerId);
            return this.partnerService.deleteMtoPartner(partnerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_COUNTRY_LINK_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request deleteMtoCountryLinkMtoPartner partnerId ==> " + partnerId);
            return this.partnerService.deleteMtoCountryLinkMtoPartner(partnerId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoCountryLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_CITY_LINK_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "cityId") Long cityId) {
        try {
            logger.info("Request deleteMtoCityLinkMtoPartner partnerId ==> " + partnerId);
            return this.partnerService.deleteMtoCityLinkMtoPartner(partnerId, cityId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoCityLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_WALLET_LINK_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "walletId") Long walletId) {
        try {
            logger.info("Request deleteMtoWalletLinkMtoPartner partnerId ==> " + partnerId);
            return this.partnerService.deleteMtoWalletLinkMtoPartner(partnerId, walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoWalletLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_BANK_LINK_MTO_PARTNER, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "bankId") Long bankId) {
        try {
            logger.info("Request deleteMtoBankLinkMtoPartner partnerId ==> " + partnerId);
            return this.partnerService.deleteMtoBankLinkMtoPartner(partnerId, bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoBankLinkMtoPartner", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    @RequestMapping(path = PartnerControllerConst.DELETE_MTO_PARTNER_COUNTRY_PRODUCT, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteMtoPartnerCountryProduct(@RequestParam(name = "partnerId") Long partnerId,
        @RequestParam(name = "productId") Long productId, @RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request deleteMtoPartnerCountryProduct ==> " +
                String.format("partnerId %d, productId %d, countryCode %s", partnerId, productId, countryCode));
            return this.partnerService.deleteMtoPartnerCountryProduct(partnerId, productId, countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteMtoPartnerCountryProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

}