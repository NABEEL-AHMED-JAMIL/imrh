package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.CountryDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CountryService {

    public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto);

    public GenericResponseDto<Object> enableDisableAllCountry(Enable enable);

    public GenericResponseDto<Object> fetchAllCountry();

    public GenericResponseDto<Object> fetchAllCityByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllBankByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(String countryCode);

}