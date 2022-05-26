package com.barco.imrh.service;

import com.barco.imrh.dto.CityDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;

/**
 * @author Nabeel Ahmed
 */
public interface CityService {

    public static final String CITY_NAME_MISSING = "City name missing.";
    public static final String CITY_NAME_ALREADY_EXIST = "City name already exist.";
    public static final String COUNTRY_NOT_EXIST = "Country not exist.";
    public static final String CITY_CREATE_SUCCESSFULLY = "City create successfully";
    public static final String COUNTRY_CODE_MISSING = "Country code missing.";
    public static final String CITY_ID_MISSING = "City id missing.";
    public static final String CITY_UPDATE_SUCCESSFULLY_WITH_ID = "City update successfully with %d.";
    public static final String CITY_NOT_FOUND_WITH_ID = "City not found with %d.";
    public static final String ALL_CITY_UPDATE_SUCCESSFULLY = "All City update successfully.";
    public static final String CITY_FIND_SUCCESSFULLY_WITH_ID = "City find successfully with %d.";
    public static final String CITY_DELETE_SUCCESSFULLY_WITH_ID = "City delete successfully with %d.";

    public GenericResponseDto<Object> createCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableCity(CityDto cityDto);

    public GenericResponseDto<Object> enableDisableAllCityByCountryCode(String countryCode, Enable enable);

    public GenericResponseDto<Object> findByCityId(Long ctyId);

    public GenericResponseDto<Object> updateCity(CityDto cityDto);

    public GenericResponseDto<Object> deleteCity(Long cityId);

}