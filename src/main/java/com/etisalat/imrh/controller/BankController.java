package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.BankDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.BankService;
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
@RequestMapping("/imrh/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {

    public Logger logger = LogManager.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    @RequestMapping(path = "/createBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> createBank(@RequestBody BankDto bankDto) {
        try {
            return this.bankService.createBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableBank(@RequestBody BankDto bankDto) {
        try {
            return this.bankService.enableDisableBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllBank(
            @RequestParam(name = "countryCode") String countryCode,
            @RequestParam(name = "enable") Enable enable) {
        try {
            return this.bankService.enableDisableAllBank(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/findByBankId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByBankId(@RequestParam(name = "bankId") Long bankId) {
        try {
            return this.bankService.findByBankId(bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByBankId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updateBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateBank(@RequestBody BankDto bankDto) {
        try {
            return this.bankService.updateBank(bankDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteBank", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteBank(@RequestParam(name = "bankId") Long bankId) {
        try {
            return this.bankService.deleteBank(bankId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteBank", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}