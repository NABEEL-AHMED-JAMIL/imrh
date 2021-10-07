package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.CityDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.CityService;
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
@RequestMapping("/imrh/city")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    public Logger logger = LogManager.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(path = "/createCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> createCity(@RequestBody CityDto cityDto) {
        try {
            return this.cityService.createCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableCity(@RequestBody CityDto cityDto) {
        try {
            return this.cityService.enableDisableCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllCity(@RequestParam(name = "countryCode") String countryCode,
        @RequestParam(name = "enable") Enable enable) {
        try {
            return this.cityService.enableDisableAllCity(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findByCityId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByCityId(@RequestParam(name = "ctyId") Long ctyId) {
        try {
            return this.cityService.findByCityId(ctyId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByCityId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updateCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateCity(@RequestBody CityDto cityDto) {
        try {
            return this.cityService.updateCity(cityDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteCity", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteCity(@RequestParam(name = "cityId") Long cityId) {
        try {
            return this.cityService.deleteCity(cityId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteCity", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}