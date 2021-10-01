package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.WalletDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.WalletService;
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
@RequestMapping("/imrh/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {

    public Logger logger = LogManager.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    @RequestMapping(path = "/createWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> createWallet(@RequestBody WalletDto walletDto) {
        try {
            return this.walletService.createWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableWallet(@RequestBody WalletDto walletDto) {
        try {
            return this.walletService.enableDisableWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllWallet(
        @RequestParam(name = "countryCode") String countryCode,
        @RequestParam(name = "enable") Enable enable) {
        try {
            return this.walletService.enableDisableAllWallet(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updateWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateWallet(@RequestBody WalletDto walletDto) {
        try {
            return this.walletService.updateWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/deleteWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteWallet(@RequestParam(name = "walletId") Long walletId) {
        try {
            return this.walletService.deleteWallet(walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }
}
