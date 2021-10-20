package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.CityDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CityService {

    public GenericResponseDto<Object> createCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableAllCity(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByCityId(Long ctyId);

    public GenericResponseDto<Object> updateCity(CityDto cityDto);

    public GenericResponseDto<Object> deleteCity(Long cityId);

}