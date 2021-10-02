package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.BankDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface BankService {

    public GenericResponseDto<Object> createBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableAllBank(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByBankId(Long bankId);

    public GenericResponseDto<Object> updateBank(BankDto bankDto);

    public GenericResponseDto<Object> deleteBank(Long bankId);

}
