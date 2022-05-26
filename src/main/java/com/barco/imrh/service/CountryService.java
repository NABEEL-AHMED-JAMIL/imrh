package com.barco.imrh.service;

import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CountryService {

    public static final String COUNTRY_ID_MISSING = "Country id missing.";
    public static final String COUNTRY_UPDATE_SUCCESSFULLY_WITH_ID = "Country update successfully with %s.";
    public static final String COUNTRY_NOT_FOUND_WITH_CODE = "Country not found with %s.";
    public static final String ALL_COUNTRY_UPDATE_SUCCESSFULLY = "All Country update successfully.";
    public static final String COUNTRY_FETCH_SUCCESSFULLY_WITH_CODE = "Country fetch successfully with %s.";
    public static final String PRODUCT_FETCH_SUCCESSFULLY = "Product fetch successfully.";
    public static final String COUNTRY_CITY_FETCH_SUCCESSFULLY_WITH_CODE = "Country city fetch successfully with %s.";
    public static final String COUNTRY_BANK_FETCH_SUCCESSFULLY_WITH_CODE = "Country bank fetch successfully with %s.";
    public static final String COUNTRY_WALLET_FETCH_SUCCESSFULLY_WITH_CODE = "Country wallet fetch successfully with %s.";

    public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto);

    public GenericResponseDto<Object> enableDisableAllCountry(Enable enable);

    public GenericResponseDto<Object> findByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllCountry();

    public GenericResponseDto<Object> fetchAllCityByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllBankByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(String countryCode);

}