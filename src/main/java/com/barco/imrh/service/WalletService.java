package com.barco.imrh.service;

import com.barco.imrh.dto.WalletDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface WalletService {

    public static final String WALLET_ID_MISSING = "Wallet id missing.";
    public static final String WALLET_NAME_MISSING = "Wallet name missing.";
    public static final String WALLET_NAME_ALREADY_EXIST = "Wallet name already exist.";
    public static final String COUNTRY_NOT_EXIST = "Country not exist.";
    public static final String WALLET_CREATE_SUCCESSFULLY = "Wallet create successfully";
    public static final String COUNTRY_CODE_MISSING = "Country code missing.";
    public static final String WALLET_UPDATE_SUCCESSFULLY_WITH_ID = "Wallet update successfully with %d.";
    public static final String WALLET_NOT_FOUND_WITH_ID = "Wallet not found with %d.";
    public static final String ALL_WALLET_UPDATE_SUCCESSFULLY = "All Wallet update successfully.";
    public static final String WALLET_FIND_SUCCESSFULLY_WITH_ID = "Wallet find successfully with %d.";
    public static final String WALLET_DELETE_SUCCESSFULLY_WITH_ID = "Wallet delete successfully with %d.";

    public GenericResponseDto<Object> createWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableAllWalletByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByWalletId(Long walletId);

    public GenericResponseDto<Object> updateWallet(WalletDto walletDto);

    public GenericResponseDto<Object> deleteWallet(Long walletId);

}