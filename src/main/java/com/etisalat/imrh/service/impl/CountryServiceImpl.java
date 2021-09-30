package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.*;
import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.CountryRepository;
import com.etisalat.imrh.service.CountryService;
import com.etisalat.imrh.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto) {
        if (CommonUtils.isNull(countryDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(), "Country id missing.");
        }
        Optional<Country> country = this.countryRepository.findById(countryDto.getCountryCode());
        if (country.isPresent()) {
            country.get().setEnabled(countryDto.getEnable().name());
            this.countryRepository.save(country.get());
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                null, String.format("Country update successfully with %s.", countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Country not found with %s.", countryDto.getCountryCode()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllCountry(Enable enable) {
        return CommonUtils.getResponseWithData(this.countryRepository.setAllCountryStatus(enable.name()), HttpStatus.OK.series().name(),
            null, "All Country update successfully.");
    }

    @Override
    public GenericResponseDto<Object> fetchAllCountry() {
        return CommonUtils.getResponseWithData(this.countryRepository.findAllCountry(), HttpStatus.OK.series().name(),
            null, String.format("Product fetch successfully."));
    }

    @Override
    public GenericResponseDto<Object> fetchAllCityByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnable(Enable.valueOf(country.get().getEnabled()));
            countryDto.setCities(country.get().getCities().stream().map(city -> {
                CityDto cityDto = new CityDto();
                cityDto.setCityId(city.getCityId());
                cityDto.setCityName(city.getCityName());
                cityDto.setEnable(Enable.valueOf(city.getEnabled()));
                return cityDto;
            }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    null, String.format("Country fetch successfully with %s.", countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Country not found with %s.", countryCode));
    }

    @Override
    public GenericResponseDto<Object> fetchAllBankByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnable(Enable.valueOf(country.get().getEnabled()));
            countryDto.setBanks(country.get().getBanks().stream().map(bank -> {
                BankDto bankDto = new BankDto();
                bankDto.setBankId(bank.getBankId());
                bankDto.setBankName(bank.getBankName());
                bankDto.setEnable(Enable.valueOf(bank.getEnabled()));
                return bankDto;
            }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    null, String.format("Country fetch successfully with %s.", countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Country not found with %s.", countryCode));
    }

    @Override
    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnable(Enable.valueOf(country.get().getEnabled()));
            countryDto.setWallets(country.get().getWallets().stream().map(wallet -> {
                WalletDto walletDto = new WalletDto();
                walletDto.setWalletId(wallet.getWalletId());
                walletDto.setWalletName(wallet.getWalletName());
                walletDto.setEnable(Enable.valueOf(wallet.getEnabled()));
                return walletDto;
            }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    null, String.format("Country fetch successfully with %s.", countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Country not found with %s.", countryCode));
    }


}
