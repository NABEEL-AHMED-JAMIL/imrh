package com.barco.imrh.service.impl;

import com.barco.imrh.repository.CountryRepository;
import com.barco.imrh.repository.PartnerRepository;
import com.barco.imrh.repository.WalletRepository;
import com.barco.imrh.dto.CountryDto;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.WalletDto;
import com.barco.imrh.entity.Wallet;
import com.barco.imrh.entity.Country;
import com.barco.imrh.service.WalletService;
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
public class WalletServiceImpl implements WalletService {

    public Logger logger = LogManager.getLogger(WalletServiceImpl.class);

    @Autowired
    public WalletRepository walletRepository;
    @Autowired
    public CountryRepository countryRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public GenericResponseDto<Object> createWallet(WalletDto walletDto) {
        if (CommonUtils.isNull(walletDto.getWalletName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), WALLET_NAME_MISSING);
        } else if (this.walletRepository.findByWalletName(walletDto.getWalletName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), WALLET_NAME_ALREADY_EXIST);
        }
        if (!CommonUtils.isNull(walletDto.getCountry()) && !CommonUtils.isNull(walletDto.getCountry().getCountryCode())) {
            Optional<Country> country = this.countryRepository.findById(walletDto.getCountry().getCountryCode());
            if (!country.isPresent()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(
                     HttpStatus.BAD_REQUEST.series().name(), COUNTRY_NOT_EXIST);
            }
            Wallet wallet = new Wallet();
            wallet.setWalletName(walletDto.getWalletName());
            wallet.setWalletImageUrl(walletDto.getWalletImageUrl());
            wallet.setEnabled(walletDto.getEnabled().name());
            wallet.setCountry(country.get());
            this.walletRepository.save(wallet);
            return CommonUtils.getResponseWithData(walletDto,
                    HttpStatus.OK.series().name(), WALLET_CREATE_SUCCESSFULLY);
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), COUNTRY_CODE_MISSING);
    }

    @Override
    public GenericResponseDto<Object> enableDisableWallet(WalletDto walletDto) {
        if (CommonUtils.isNull(walletDto.getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), WALLET_ID_MISSING);
        }
        Optional<Wallet> wallet = this.walletRepository.findById(walletDto.getWalletId());
        if (wallet.isPresent()) {
            wallet.get().setEnabled(walletDto.getEnabled().name());
            this.walletRepository.save(wallet.get());
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(),
                 String.format(WALLET_UPDATE_SUCCESSFULLY_WITH_ID, walletDto.getWalletId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(WALLET_NOT_FOUND_WITH_ID, walletDto.getWalletId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllWalletByCountryCode(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.walletRepository.setAllWalletStatusByCountryCode(enable.name(),
               countryCode), HttpStatus.OK.series().name(), ALL_WALLET_UPDATE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> findByWalletId(Long walletId) {
        Optional<Wallet> wallet = this.walletRepository.findById(walletId);
        if (wallet.isPresent()) {
            WalletDto walletDto = new WalletDto();
            walletDto.setWalletId(wallet.get().getWalletId());
            walletDto.setWalletName(wallet.get().getWalletName());
            walletDto.setWalletImageUrl(wallet.get().getWalletImageUrl());
            walletDto.setEnabled(Enable.valueOf(wallet.get().getEnabled()));
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryCode(wallet.get().getCountry().getCountryCode());
            countryDto.setCountryName(wallet.get().getCountry().getCountryName());
            countryDto.setEnabled(Enable.valueOf(wallet.get().getCountry().getEnabled()));
            countryDto.setCountryImageUrl(wallet.get().getCountry().getCountryImageUrl());
            walletDto.setCountry(countryDto);
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(), 
                    String.format(WALLET_FIND_SUCCESSFULLY_WITH_ID, walletId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(WALLET_NOT_FOUND_WITH_ID, walletId));
    }

    @Override
    public GenericResponseDto<Object> updateWallet(WalletDto walletDto) {
        if (CommonUtils.isNull(walletDto.getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), WALLET_ID_MISSING);
        } else if (CommonUtils.isNull(walletDto.getWalletName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), WALLET_NAME_MISSING);
        } else if (this.walletRepository.findByWalletName(walletDto.getWalletName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), WALLET_NAME_ALREADY_EXIST);
        }
        Optional<Wallet> wallet = this.walletRepository.findById(walletDto.getWalletId());
        if (wallet.isPresent()) {
            wallet.get().setWalletName(walletDto.getWalletName());
            wallet.get().setEnabled(walletDto.getEnabled().name());
            wallet.get().setWalletImageUrl(walletDto.getWalletImageUrl());
            this.walletRepository.save(wallet.get());
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(),
                String.format(WALLET_UPDATE_SUCCESSFULLY_WITH_ID, walletDto.getWalletId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(WALLET_NOT_FOUND_WITH_ID, walletDto.getWalletId()));
    }

    @Override
    public GenericResponseDto<Object> deleteWallet(Long walletId) {
        this.partnerRepository.deletePartnerWalletByWalletId(walletId);
        this.walletRepository.deleteById(walletId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format(WALLET_DELETE_SUCCESSFULLY_WITH_ID, walletId));
    }

}