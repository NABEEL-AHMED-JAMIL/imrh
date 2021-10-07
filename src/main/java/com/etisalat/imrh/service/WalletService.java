package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.WalletDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface WalletService {

    public GenericResponseDto<Object> createWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableWallet(WalletDto walletDto);

    public GenericResponseDto<Object> enableDisableAllWallet(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByWalletId(Long walletId);

    public GenericResponseDto<Object> updateWallet(WalletDto walletDto);

    public GenericResponseDto<Object> deleteWallet(Long walletId);

}