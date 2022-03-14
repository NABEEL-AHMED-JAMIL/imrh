package com.barco.imrh.service;

import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CountryService {

    public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto);

    public GenericResponseDto<Object> enableDisableAllCountry(Enable enable);

    public GenericResponseDto<Object> findByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllCountry();

    public GenericResponseDto<Object> fetchAllCityByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllBankByCountryCode(String countryCode);

    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(String countryCode);

}