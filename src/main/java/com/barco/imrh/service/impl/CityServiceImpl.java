package com.barco.imrh.service.impl;

import com.barco.imrh.repository.CityRepository;
import com.barco.imrh.repository.CountryRepository;
import com.barco.imrh.repository.PartnerRepository;
import com.barco.imrh.service.CityService;
import com.barco.imrh.dto.CityDto;
import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.entity.City;
import com.barco.imrh.entity.Country;
import com.barco.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    public Logger logger = LogManager.getLogger(CityServiceImpl.class);

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public GenericResponseDto<Object> createCity(CityDto cityDto) {
        if (CommonUtils.isNull(cityDto.getCityName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City name missing.");
        } else if (this.cityRepository.findByCityName(cityDto.getCityName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City name already exist.");
        }
        if (!CommonUtils.isNull(cityDto.getCountry()) &&
            !CommonUtils.isNull(cityDto.getCountry().getCountryCode())) {
            Optional<Country> country = this.countryRepository.findById(cityDto.getCountry().getCountryCode());
            if (!country.isPresent()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(
                        HttpStatus.BAD_REQUEST.series().name(), "Country not exist.");
            }
            City city = new City();
            city.setCityName(cityDto.getCityName());
            city.setEnabled(cityDto.getEnabled().name());
            city.setCountry(country.get());
            this.cityRepository.save(city);
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                "City create successfully");
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Country code missing.");
    }

    @Override
    public GenericResponseDto<Object> enableDisableCity(CityDto cityDto) {
        if (CommonUtils.isNull(cityDto.getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City id missing.");
        }
        Optional<City> city = this.cityRepository.findById(cityDto.getCityId());
        if (city.isPresent()) {
            city.get().setEnabled(cityDto.getEnabled().name());
            this.cityRepository.save(city.get());
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    String.format("City update successfully with %d.", cityDto.getCityId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City not found with %d.", cityDto.getCityId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllCityByCountryCode(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.cityRepository
                .setAllCityStatusByCountryCode(enable.name(), countryCode), HttpStatus.OK.series().name(),
        "All City update successfully.");
    }

    @Override
    public GenericResponseDto<Object> findByCityId(Long ctyId) {
        Optional<City> city = this.cityRepository.findById(ctyId);
        if (city.isPresent()) {
            CityDto cityDto = new CityDto();
            cityDto.setCityId(city.get().getCityId());
            cityDto.setCityName(city.get().getCityName());
            cityDto.setEnabled(Enable.valueOf(city.get().getEnabled()));
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(city.get().getCountry().getCountryCode());
            countryDto.setCountryName(city.get().getCountry().getCountryName());
            countryDto.setEnabled(Enable.valueOf(city.get().getCountry().getEnabled()));
            countryDto.setCountryImageUrl(city.get().getCountry().getCountryImageUrl());
            cityDto.setCountry(countryDto);
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    String.format("City find successfully with %d.", ctyId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City not found with %d.", ctyId));
    }

    @Override
    public GenericResponseDto<Object> updateCity(CityDto cityDto) {
        if (CommonUtils.isNull(cityDto.getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City id missing.");
        } else if (CommonUtils.isNull(cityDto.getCityName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City name missing.");
        } else if (this.cityRepository.findByCityName(cityDto.getCityName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "City name already exist.");
        }
        Optional<City> city = this.cityRepository.findById(cityDto.getCityId());
        if (city.isPresent()) {
            city.get().setCityName(cityDto.getCityName());
            city.get().setEnabled(cityDto.getEnabled().name());
            this.cityRepository.save(city.get());
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    String.format("City update successfully with %d.", cityDto.getCityId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City not found with %d.", cityDto.getCityId()));
    }

    @Override
    public GenericResponseDto<Object> deleteCity(Long cityId) {
        this.partnerRepository.deletePartnerCityByCityId(cityId);
        this.cityRepository.deleteById(cityId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format("City delete successfully with %d.", cityId));
    }

}