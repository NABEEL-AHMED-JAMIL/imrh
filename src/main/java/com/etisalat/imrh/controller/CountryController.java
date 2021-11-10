package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.CountryDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.CountryService;
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
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/country")
public class CountryController {

    public Logger logger = LogManager.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // working
    @RequestMapping(path = "/enableDisableCountry", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableCountry(@RequestBody CountryDto countryDto) {
        try {
            logger.info("Request enableDisableCountry ==> " + countryDto);
            return this.countryService.enableDisableCountry(countryDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableAllCountry", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllCountry(@RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllCountry enable ==> " + enable.name());
            return this.countryService.enableDisableAllCountry(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/findByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findByCountryCode countryCode ==> " + countryCode);
            return this.countryService.findByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/fetchAllCountry", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCountry() {
        try {
            logger.info("Request fetchAllCountry");
            return this.countryService.fetchAllCountry();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/fetchAllCityByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCityByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllCityByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllCityByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllCityByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/fetchAllBankByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllBankByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllBankByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllBankByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllBankByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/fetchAllWalletsByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllWalletsByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllWalletsByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllWalletsByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}