package com.barco.imrh.service.impl;

import com.barco.imrh.dto.*;
import com.barco.imrh.repository.CountryRepository;
import com.barco.imrh.entity.Country;
import com.barco.imrh.service.CountryService;
import com.barco.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    public Logger logger = LogManager.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public GenericResponseDto<Object> enableDisableCountry(CountryDto countryDto) {
        if (CommonUtils.isNull(countryDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                  HttpStatus.BAD_REQUEST.series().name(), COUNTRY_ID_MISSING);
        }
        Optional<Country> country = this.countryRepository.findById(countryDto.getCountryCode());
        if (country.isPresent()) {
            country.get().setEnabled(countryDto.getEnabled().name());
            this.countryRepository.save(country.get());
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                String.format(COUNTRY_UPDATE_SUCCESSFULLY_WITH_ID, countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(COUNTRY_NOT_FOUND_WITH_CODE, countryDto.getCountryCode()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllCountry(Enable enable) {
        return CommonUtils.getResponseWithData(this.countryRepository.setAllCountryStatus(
            enable.name()), HttpStatus.OK.series().name(), ALL_COUNTRY_UPDATE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> findByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryImageUrl(country.get().getCountryImageUrl());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnabled(Enable.valueOf(country.get().getEnabled()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                String.format(COUNTRY_FETCH_SUCCESSFULLY_WITH_CODE, countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format(COUNTRY_NOT_FOUND_WITH_CODE, countryCode));
    }

    @Override
    public GenericResponseDto<Object> fetchAllCountry() {
        return CommonUtils.getResponseWithData(this.countryRepository.findAllCountry(),
             HttpStatus.OK.series().name(), String.format(PRODUCT_FETCH_SUCCESSFULLY));
    }

    @Override
    public GenericResponseDto<Object> fetchAllCityByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryImageUrl(country.get().getCountryImageUrl());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnabled(Enable.valueOf(country.get().getEnabled()));
            countryDto.setCities(country.get().getCities()
                .stream().map(city -> {
                    CityDto cityDto = new CityDto();
                    cityDto.setCityId(city.getCityId());
                    cityDto.setCityName(city.getCityName());
                    cityDto.setEnabled(Enable.valueOf(city.getEnabled()));
                    return cityDto;
                }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    String.format(COUNTRY_CITY_FETCH_SUCCESSFULLY_WITH_CODE, countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(COUNTRY_NOT_FOUND_WITH_CODE, countryCode));
    }

    @Override
    public GenericResponseDto<Object> fetchAllBankByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryImageUrl(country.get().getCountryImageUrl());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnabled(Enable.valueOf(country.get().getEnabled()));
            countryDto.setBanks(country.get().getBanks()
                .stream().map(bank -> {
                    BankDto bankDto = new BankDto();
                    bankDto.setBankId(bank.getBankId());
                    bankDto.setBankName(bank.getBankName());
                    bankDto.setBankImageUrl(bank.getBankImageUrl());
                    bankDto.setEnabled(Enable.valueOf(bank.getEnabled()));
                    return bankDto;
                }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    String.format(COUNTRY_BANK_FETCH_SUCCESSFULLY_WITH_CODE, countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(COUNTRY_NOT_FOUND_WITH_CODE, countryCode));
    }

    @Override
    public GenericResponseDto<Object> fetchAllWalletsByCountryCode(String countryCode) {
        Optional<Country> country = this.countryRepository.findById(countryCode);
        if (country.isPresent()) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(country.get().getCountryCode());
            countryDto.setCountryName(country.get().getCountryName());
            countryDto.setCountryImageUrl(country.get().getCountryImageUrl());
            countryDto.setCountryLegacyCode(country.get().getCountryLegacyCode());
            countryDto.setEnabled(Enable.valueOf(country.get().getEnabled()));
            countryDto.setWallets(country.get().getWallets()
                .stream().map(wallet -> {
                    WalletDto walletDto = new WalletDto();
                    walletDto.setWalletId(wallet.getWalletId());
                    walletDto.setWalletName(wallet.getWalletName());
                    walletDto.setWalletImageUrl(wallet.getWalletImageUrl());
                    walletDto.setEnabled(Enable.valueOf(wallet.getEnabled()));
                    return walletDto;
               }).collect(Collectors.toList()));
            return CommonUtils.getResponseWithData(countryDto, HttpStatus.OK.series().name(),
                    String.format(COUNTRY_WALLET_FETCH_SUCCESSFULLY_WITH_CODE, countryDto.getCountryCode()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(COUNTRY_NOT_FOUND_WITH_CODE, countryCode));
    }

}