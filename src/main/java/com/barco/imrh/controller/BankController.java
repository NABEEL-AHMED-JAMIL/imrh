package com.barco.imrh.controller;

import com.barco.imrh.dto.BankDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.BankService;
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
@RequestMapping("/imrh/bank")
public class BankController {

    public Logger logger = LogManager.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    // working
    @RequestMapping(path = "/createBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> createBank(@RequestBody BankDto bankDto) {
        try {
            logger.info("Request createBank ==> " + bankDto);
            return this.bankService.createBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableBank(@RequestBody BankDto bankDto) {
        try {
            logger.info("Request enableDisableBank ==> " + bankDto);
            return this.bankService.enableDisableBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableAllBankByCountryCode", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllBank(
            @RequestParam(name = "countryCode") String countryCode,
            @RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllBank ==> " + String.format("countryCode %s enable %s", countryCode, enable.name()));
            return this.bankService.enableDisableAllBankByCountryCode(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllBankByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/findByBankId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByBankId(@RequestParam(name = "bankId") Long bankId) {
        try {
            logger.info("Request findByBankId ==> bankId " + bankId);
            return this.bankService.findByBankId(bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByBankId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/updateBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateBank(@RequestBody BankDto bankDto) {
        try {
            logger.info("Request updateBank ==> " + bankDto);
            return this.bankService.updateBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/deleteBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteBank(@RequestParam(name = "bankId") Long bankId) {
        try {
            logger.info("Request deleteBank bankId ==> " + bankId);
            return this.bankService.deleteBank(bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}