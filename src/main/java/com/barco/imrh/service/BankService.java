package com.barco.imrh.service;

import com.barco.imrh.dto.BankDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface BankService {

    public static final String BANK_NAME_MISSING = "Bank name missing.";
    public static final String BANK_NAME_ALREADY_EXIST = "Bank name already exist.";
    public static final String COUNTRY_NOT_EXIST = "Country not exist.";
    public static final String BANK_CREATE_SUCCESSFULLY = "Bank create successfully";
    public static final String COUNTRY_CODE_MISSING = "Country code missing.";
    public static final String BANK_ID_MISSING = "Bank id missing.";
    public static final String BANK_UPDATE_SUCCESSFULLY_WITH_ID = "Bank update successfully with %d.";
    public static final String BANK_NOT_FOUND_WITH_ID = "Bank not found with %d.";
    public static final String ALL_BANK_UPDATE_SUCCESSFULLY = "All Bank update successfully.";
    public static final String BANK_FIND_SUCCESSFULLY_WITH_ID = "Bank find successfully with %d.";
    public static final String BANK_DELETE_SUCCESSFULLY_WITH_ID = "Bank delete successfully with %d.";

    public GenericResponseDto<Object> createBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableBank(BankDto bankDto);

    public GenericResponseDto<Object> enableDisableAllBankByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByBankId(Long bankId);

    public GenericResponseDto<Object> updateBank(BankDto bankDto);

    public GenericResponseDto<Object> deleteBank(Long bankId);

}