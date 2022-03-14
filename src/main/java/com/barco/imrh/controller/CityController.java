package com.barco.imrh.controller;

import com.barco.imrh.dto.CityDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.CityService;
import com.barco.imrh.util.CommonUtils;
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
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/city")
public class CityController {

    public Logger logger = LogManager.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    // working
    @RequestMapping(path = "/createCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> createCity(@RequestBody CityDto cityDto) {
        try {
            logger.info("Request createCity cityDto ==> " + cityDto);
            return this.cityService.createCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableCity(@RequestBody CityDto cityDto) {
        try {
            logger.info("Request enableDisableCity cityDto ==> " + cityDto);
            return this.cityService.enableDisableCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableAllCityByCountryCode", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllCityByCountryCode(
        @RequestParam(name = "countryCode") String countryCode,
        @RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllCityByCountryCode ==> " + String.format("countryCode %s enable %s", countryCode, enable.name()));
            return this.cityService.enableDisableAllCityByCountryCode(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllCityByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/findByCityId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByCityId(@RequestParam(name = "ctyId") Long ctyId) {
        try {
            logger.info("Request findByCityId ctyId ==> " + ctyId);
            return this.cityService.findByCityId(ctyId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByCityId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/updateCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateCity(@RequestBody CityDto cityDto) {
        try {
            logger.info("Request updateCity ==> " + cityDto);
            return this.cityService.updateCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/deleteCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteCity(@RequestParam(name = "cityId") Long cityId) {
        try {
            logger.info("Request deleteCity cityId ==> " + cityId);
            return this.cityService.deleteCity(cityId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}