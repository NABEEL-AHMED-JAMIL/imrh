package com.barco.imrh.service;

import com.barco.imrh.dto.CityDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CityService {

    public GenericResponseDto<Object> createCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableAllCityByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByCityId(Long ctyId);

    public GenericResponseDto<Object> updateCity(CityDto cityDto);

    public GenericResponseDto<Object> deleteCity(Long cityId);

}