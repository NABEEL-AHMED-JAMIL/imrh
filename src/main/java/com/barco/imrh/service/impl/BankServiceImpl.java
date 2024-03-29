package com.barco.imrh.service.impl;

import com.barco.imrh.repository.BankRepository;
import com.barco.imrh.repository.CountryRepository;
import com.barco.imrh.repository.PartnerRepository;
import com.barco.imrh.dto.BankDto;
import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.entity.Bank;
import com.barco.imrh.entity.Country;
import com.barco.imrh.service.BankService;
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
public class BankServiceImpl implements BankService {

    public Logger logger = LogManager.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public GenericResponseDto<Object> createBank(BankDto bankDto) {
        if (CommonUtils.isNull(bankDto.getBankName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), BANK_NAME_MISSING);
        } else if (this.bankRepository.findByBankName(bankDto.getBankName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), BANK_NAME_ALREADY_EXIST);
        }
        if (!CommonUtils.isNull(bankDto.getCountry()) && !CommonUtils.isNull(bankDto.getCountry().getCountryCode())) {
            Optional<Country> country = this.countryRepository.findById(bankDto.getCountry().getCountryCode());
            if (!country.isPresent()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), COUNTRY_NOT_EXIST);
            }
            Bank bank = new Bank();
            bank.setBankName(bankDto.getBankName());
            bank.setBankImageUrl(bankDto.getBankImageUrl());
            bank.setEnabled(bankDto.getEnabled().name());
            bank.setCountry(country.get());
            this.bankRepository.save(bank);
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK
                    .series().name(), BANK_CREATE_SUCCESSFULLY);
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), COUNTRY_CODE_MISSING);
    }

    @Override
    public GenericResponseDto<Object> enableDisableBank(BankDto bankDto) {
        if (CommonUtils.isNull(bankDto.getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), BANK_ID_MISSING);
        }
        Optional<Bank> bank = this.bankRepository.findById(bankDto.getBankId());
        if (bank.isPresent()) {
            bank.get().setEnabled(bankDto.getEnabled().name());
            this.bankRepository.save(bank.get());
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(),
                 String.format(BANK_UPDATE_SUCCESSFULLY_WITH_ID, bankDto.getBankId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(BANK_NOT_FOUND_WITH_ID, bankDto.getBankId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllBankByCountryCode(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.bankRepository.setAllBankStatusByCountryCode(
            enable.name(), countryCode), HttpStatus.OK.series().name(), ALL_BANK_UPDATE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> findByBankId(Long bankId) {
        Optional<Bank> bank = this.bankRepository.findById(bankId);
        if (bank.isPresent()) {
            BankDto bankDto = new BankDto();
            bankDto.setBankId(bank.get().getBankId());
            bankDto.setBankName(bank.get().getBankName());
            bankDto.setBankImageUrl(bank.get().getBankImageUrl());
            bankDto.setEnabled(Enable.valueOf(bank.get().getEnabled()));
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(bank.get().getCountry().getCountryCode());
            countryDto.setCountryName(bank.get().getCountry().getCountryName());
            countryDto.setEnabled(Enable.valueOf(bank.get().getCountry().getEnabled()));
            countryDto.setCountryImageUrl(bank.get().getCountry().getCountryImageUrl());
            bankDto.setCountry(countryDto);
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(), 
                    String.format(BANK_FIND_SUCCESSFULLY_WITH_ID, bankId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(BANK_NOT_FOUND_WITH_ID, bankId));
    }

    @Override
    public GenericResponseDto<Object> updateBank(BankDto bankDto) {
        if (CommonUtils.isNull(bankDto.getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), BANK_ID_MISSING);
        } else if (CommonUtils.isNull(bankDto.getBankName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), BANK_NAME_MISSING);
        } else if (this.bankRepository.findByBankName(bankDto.getBankName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), BANK_NAME_ALREADY_EXIST);
        }
        Optional<Bank> bank = this.bankRepository.findById(bankDto.getBankId());
        if (bank.isPresent()) {
            bank.get().setBankName(bankDto.getBankName());
            bank.get().setBankImageUrl(bankDto.getBankImageUrl());
            bank.get().setEnabled(bankDto.getEnabled().name());
            this.bankRepository.save(bank.get());
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(),
                 String.format(BANK_UPDATE_SUCCESSFULLY_WITH_ID, bankDto.getBankId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(BANK_NOT_FOUND_WITH_ID, bankDto.getBankId()));
    }

    @Override
    public GenericResponseDto<Object> deleteBank(Long bankId) {
        this.partnerRepository.deletePartnerBankByBankId(bankId);
        this.bankRepository.deleteById(bankId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format(BANK_DELETE_SUCCESSFULLY_WITH_ID, bankId));
    }

}