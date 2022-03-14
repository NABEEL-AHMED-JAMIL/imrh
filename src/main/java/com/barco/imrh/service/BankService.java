package com.barco.imrh.service;

import com.barco.imrh.dto.BankDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface BankService {

    public GenericResponseDto<Object> createBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableAllBankByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByBankId(Long bankId);

    public GenericResponseDto<Object> updateBank(BankDto bankDto);

    public GenericResponseDto<Object> deleteBank(Long bankId);

}