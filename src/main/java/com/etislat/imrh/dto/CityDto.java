package com.etislat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDto {

    private Long cityId;
    private String cityName;
    private Enable enable;
    private CountryDto countryDto;

    public CityDto() { }

    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Enable getEnable() {
        return enable;
    }
    public void setEnable(Enable enable) {
        this.enable = enable;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }
    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
