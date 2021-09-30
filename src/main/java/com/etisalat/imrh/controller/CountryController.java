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

@RestController
@RequestMapping("/imrh/country")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    public Logger logger = LogManager.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping(path = "/enableDisableCountry", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableCountry(@RequestBody CountryDto countryDto) {
        try {
            return this.countryService.enableDisableCountry(countryDto);
        } catch (Exception ex) {
            logger.error("An error occurred while enableDisableCountry", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllCountry", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllCountry(@RequestParam(name = "enable") Enable enable) {
        try {
            return this.countryService.enableDisableAllCountry(enable);
        } catch (Exception ex) {
            logger.error("An error occurred while enableDisableAllCountry", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllCountry", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCountry() {
        try {
            return this.countryService.fetchAllCountry();
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllCountry", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllCityByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCityByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.countryService.fetchAllCityByCountryCode(countryCode);
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllCityByCountryCode", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllBankByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllBankByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.countryService.fetchAllBankByCountryCode(countryCode);
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllBankByCountryCode", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllWalletsByCountryCode", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            return this.countryService.fetchAllWalletsByCountryCode(countryCode);
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllWalletsByCountryCode", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

}
