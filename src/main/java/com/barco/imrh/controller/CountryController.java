package com.barco.imrh.controller;

import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.CountryService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ConstantUtils.CountryControllerConst;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = CountryControllerConst.ORIGINS)
@RequestMapping(CountryControllerConst.IMRH_COUNTRY)
public class CountryController {

    public Logger logger = LogManager.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // working
    @RequestMapping(path = CountryControllerConst.ENABLE_DISABLE_COUNTRY, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableCountry(@RequestBody CountryDto countryDto) {
        try {
            logger.info("Request enableDisableCountry ==> " + countryDto);
            return this.countryService.enableDisableCountry(countryDto);
        } catch (Exception ex) {
            ex.printStackTrace();

            logger.error("An error occurred while enableDisableCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                   .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.ENABLE_DISABLE_ALL_COUNTRY, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllCountry(@RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllCountry enable ==> " + enable.name());
            return this.countryService.enableDisableAllCountry(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.FIND_BY_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> findByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request findByCountryCode countryCode ==> " + countryCode);
            return this.countryService.findByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.FETCH_ALL_COUNTRY, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCountry() {
        try {
            logger.info("Request fetchAllCountry");
            return this.countryService.fetchAllCountry();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllCountry", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.FETCH_ALL_CITY_BY_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllCityByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllCityByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllCityByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllCityByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.FETCH_ALL_BANK_BY_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllBankByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllBankByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllBankByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllBankByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = CountryControllerConst.FETCH_ALL_WALLET_BY_COUNTRY_CODE, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(@RequestParam(name = "countryCode") String countryCode) {
        try {
            logger.info("Request fetchAllWalletsByCountryCode countryCode ==> " + countryCode);
            return this.countryService.fetchAllWalletsByCountryCode(countryCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllWalletsByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

}