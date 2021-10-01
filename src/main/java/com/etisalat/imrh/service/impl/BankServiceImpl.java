package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.BankDto;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.entity.Bank;
import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.BankRepository;
import com.etisalat.imrh.repository.CountryRepository;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.service.BankService;
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
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Bank name missing.");
        } else if (this.bankRepository.findByBankName(bankDto.getBankName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Bank name already exist.");
        }
        if (!CommonUtils.isNull(bankDto.getCountry()) &&
                !CommonUtils.isNull(bankDto.getCountry().getCountryCode())) {
            Optional<Country> country = this.countryRepository.findById(bankDto.getCountry().getCountryCode());
            if (!country.isPresent()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(
                        HttpStatus.BAD_REQUEST.series().name(), "Country not exist.");
            }
            Bank bank = new Bank();
            bank.setBankName(bankDto.getBankName());
            bank.setEnabled(bankDto.getEnable().name());
            bank.setCountry(country.get());
            this.bankRepository.save(bank);
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(),
                    null, "Bank create successfully");
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Country code missing.");
    }

    @Override
    public GenericResponseDto<Object> enableDisableBank(BankDto bankDto) {
        if (CommonUtils.isNull(bankDto.getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Bank id missing.");
        }
        Optional<Bank> bank = this.bankRepository.findById(bankDto.getBankId());
        if (bank.isPresent()) {
            bank.get().setEnabled(bankDto.getEnable().name());
            this.bankRepository.save(bank.get());
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(),
                    null, String.format("Bank update successfully with %d.", bankDto.getBankId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Bank not found with %d.", bankDto.getBankId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllBank(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.bankRepository
                .setAllBankStatusByCountryCode(enable.name(), countryCode), HttpStatus.OK.series().name(),
                null, "All Bank update successfully.");
    }

    @Override
    public GenericResponseDto<Object> updateBank(BankDto bankDto) {
        if (CommonUtils.isNull(bankDto.getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Bank id missing.");
        } else if (CommonUtils.isNull(bankDto.getBankName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Bank name missing.");
        } else if (this.bankRepository.findByBankName(bankDto.getBankName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Bank name already exist.");
        }
        Optional<Bank> bank = this.bankRepository.findById(bankDto.getBankId());
        if (bank.isPresent()) {
            bank.get().setBankName(bankDto.getBankName());
            bank.get().setEnabled(bankDto.getEnable().name());
            this.bankRepository.save(bank.get());
            return CommonUtils.getResponseWithData(bankDto, HttpStatus.OK.series().name(),
                    null, String.format("Bank update successfully with %d.", bankDto.getBankId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Bank not found with %d.", bankDto.getBankId()));
    }

    @Override
    public GenericResponseDto<Object> deleteBank(Long bankId) {
        this.partnerRepository.deletePartnerBankByBankId(bankId);
        this.bankRepository.deleteById(bankId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Bank delete successfully with %d.", bankId));
    }
}
