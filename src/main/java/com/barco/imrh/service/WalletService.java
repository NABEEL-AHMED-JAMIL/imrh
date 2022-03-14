package com.barco.imrh.service;

import com.barco.imrh.dto.WalletDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface WalletService {

    public GenericResponseDto<Object> createWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableAllWalletByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByWalletId(Long walletId);

    public GenericResponseDto<Object> updateWallet(WalletDto walletDto);

    public GenericResponseDto<Object> deleteWallet(Long walletId);

}