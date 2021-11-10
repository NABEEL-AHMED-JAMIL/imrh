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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/wallet")
public class WalletController {

    public Logger logger = LogManager.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    // working
    @RequestMapping(path = "/createWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> createWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request createWallet " + walletDto);
            return this.walletService.createWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request enableDisableWallet " + walletDto);
            return this.walletService.enableDisableWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/enableDisableAllWalletByCountryCode", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllWalletByCountryCode(@RequestParam(name = "countryCode") String countryCode,
        @RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllWalletByCountryCode " +
                String.format("countryCode %s enable %s", countryCode, enable.name()));
            return this.walletService.enableDisableAllWalletByCountryCode(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllWalletByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/findByWalletId", method = RequestMethod.GET)
    public GenericResponseDto<Object> findByWalletId(@RequestParam(name = "walletId") Long walletId) {
        try {
            logger.info("Request findByWalletId walletId ==> " + walletId);
            return this.walletService.findByWalletId(walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByWalletId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/updateWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request updateWallet " + walletDto);
            return this.walletService.updateWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    // working
    @RequestMapping(path = "/deleteWallet", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteWallet(@RequestParam(name = "walletId") Long walletId) {
        try {
            logger.info("Request deleteWallet walletId ==> " + walletId);
            return this.walletService.deleteWallet(walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }
}