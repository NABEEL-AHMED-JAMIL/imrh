package com.barco.imrh.controller;

import com.barco.imrh.dto.WalletDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.WalletService;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils.WalletControllerConst;
import com.barco.imrh.util.ConstantUtils;
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
@CrossOrigin(origins = WalletControllerConst.ORIGINS)
@RequestMapping(WalletControllerConst.IMRH_WALLET)
public class WalletController {

    public Logger logger = LogManager.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    // working
    @RequestMapping(path = WalletControllerConst.CREATE_WALLET, method = RequestMethod.POST)
    public GenericResponseDto<Object> createWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request createWallet " + walletDto);
            return this.walletService.createWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = WalletControllerConst.ENABLE_DISABLE_WALLET, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request enableDisableWallet " + walletDto);
            return this.walletService.enableDisableWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = WalletControllerConst.ENABLE_DISABLE_ALL_WALLET_BY_COUNTRY_CODE, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllWalletByCountryCode(@RequestParam(name = "countryCode") String countryCode,
        @RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllWalletByCountryCode " +
                String.format("countryCode %s enable %s", countryCode, enable.name()));
            return this.walletService.enableDisableAllWalletByCountryCode(countryCode, enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableAllWalletByCountryCode", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = WalletControllerConst.FIND_BY_WALLET_ID, method = RequestMethod.GET)
    public GenericResponseDto<Object> findByWalletId(@RequestParam(name = "walletId") Long walletId) {
        try {
            logger.info("Request findByWalletId walletId ==> " + walletId);
            return this.walletService.findByWalletId(walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByWalletId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = WalletControllerConst.UPDATE_WALLET, method = RequestMethod.POST)
    public GenericResponseDto<Object> updateWallet(@RequestBody WalletDto walletDto) {
        try {
            logger.info("Request updateWallet " + walletDto);
            return this.walletService.updateWallet(walletDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = WalletControllerConst.DELETE_WALLET, method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteWallet(@RequestParam(name = "walletId") Long walletId) {
        try {
            logger.info("Request deleteWallet walletId ==> " + walletId);
            return this.walletService.deleteWallet(walletId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteWallet", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }
}