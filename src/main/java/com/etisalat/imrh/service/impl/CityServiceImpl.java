package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.CityDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.entity.City;
import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.CityRepository;
import com.etisalat.imrh.repository.CountryRepository;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.service.CityService;
import com.etisalat.imrh.util.CommonUtils;
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
            city.setEnabled(cityDto.getEnable().name());
            city.setCountry(country.get());
            this.cityRepository.save(city);
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    null, "City create successfully");
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
            city.get().setEnabled(cityDto.getEnable().name());
            this.cityRepository.save(city.get());
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    null, String.format("City update successfully with %d.", cityDto.getCityId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City not found with %d.", cityDto.getCityId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllCity(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.cityRepository
                .setAllCityStatusByCountryCode(enable.name(), countryCode), HttpStatus.OK.series().name(),
        null, "All City update successfully.");
    }

    @Override
    public GenericResponseDto<Object> findByCityId(Long ctyId) {
        Optional<City> city = this.cityRepository.findById(ctyId);
        if (city.isPresent()) {
            CityDto cityDto = new CityDto();
            cityDto.setCityId(city.get().getCityId());
            cityDto.setCityName(city.get().getCityName());
            cityDto.setEnable(Enable.valueOf(city.get().getEnabled()));
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(), null,
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
            city.get().setEnabled(cityDto.getEnable().name());
            this.cityRepository.save(city.get());
            return CommonUtils.getResponseWithData(cityDto, HttpStatus.OK.series().name(),
                    null, String.format("City update successfully with %d.", cityDto.getCityId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City not found with %d.", cityDto.getCityId()));
    }

    @Override
    public GenericResponseDto<Object> deleteCity(Long cityId) {
        this.partnerRepository.deletePartnerCityByCityId(cityId);
        this.cityRepository.deleteById(cityId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("City delete successfully with %d.", cityId));
    }

}