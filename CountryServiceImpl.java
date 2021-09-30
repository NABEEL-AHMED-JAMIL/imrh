package com.etisalat.cim.mobileWalletAdapter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import ae.etisalat.ewallet.response.dto.GenericResponseDto;

import com.etisalat.cim.mobileWalletAdapter.service.CountryService;
import com.etisalat.ewallet.commonutils.CommonUtils;
import com.etisalat.imrh.dto.CountryDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.entity.Product;
import com.etisalat.imrh.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto) {
        if (CommonUtils.isNull(countryDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(), "Country id missing.");
        }
        Country country = this.countryRepository.getOne(countryDto.getCountryCode());
        if (country != null) {
        	country.setEnabled(countryDto.getEnable().name());
            return CommonUtils.getResponseWithData(this.countryRepository.save(country), HttpStatus.OK.series().name(),
                    null, String.format("Country update successfully with %d.", countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Country not found with %d.", countryDto.getCountryCode()));
	}

	@Override
	public GenericResponseDto<Object> enableDisableAllCountry(Enable enable) {
		return null;
	}

	@Override
	public GenericResponseDto<Object> fetchAllCountry() {
		return null;
	}

	@Override
	public GenericResponseDto<Object> fetchAllCityByCountryCode(
			String countryCode) {
		return null;
	}

	@Override
	public GenericResponseDto<Object> fetchAllBankByCountryCode(
			String countryCode) {
		return null;
	}

	@Override
	public GenericResponseDto<Object> fetchAllWalletsByCountryCode(
			String countryCode) {
		return null;
	}
	
	
}
