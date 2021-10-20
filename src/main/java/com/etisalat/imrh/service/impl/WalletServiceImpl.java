package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.WalletDto;
import com.etisalat.imrh.entity.Wallet;
import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.CountryRepository;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.repository.WalletRepository;
import com.etisalat.imrh.service.WalletService;
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
                    HttpStatus.BAD_REQUEST.series().name(), "Wallet name missing.");
        } else if (this.walletRepository.findByWalletName(walletDto.getWalletName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Wallet name already exist.");
        }
        if (!CommonUtils.isNull(walletDto.getCountry()) &&
                !CommonUtils.isNull(walletDto.getCountry().getCountryCode())) {
            Optional<Country> country = this.countryRepository.findById(walletDto.getCountry().getCountryCode());
            if (!country.isPresent()) {
                return CommonUtils.getResponseWithStatusAndMessageOnly(
                        HttpStatus.BAD_REQUEST.series().name(), "Country not exist.");
            }
            Wallet wallet = new Wallet();
            wallet.setWalletName(walletDto.getWalletName());
            wallet.setEnabled(walletDto.getEnable().name());
            wallet.setCountry(country.get());
            this.walletRepository.save(wallet);
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(),
                    null, "Wallet create successfully");
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Country code missing.");
    }

    @Override
    public GenericResponseDto<Object> enableDisableWallet(WalletDto walletDto) {
        if (CommonUtils.isNull(walletDto.getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Wallet id missing.");
        }
        Optional<Wallet> wallet = this.walletRepository.findById(walletDto.getWalletId());
        if (wallet.isPresent()) {
            wallet.get().setEnabled(walletDto.getEnable().name());
            this.walletRepository.save(wallet.get());
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(),
                    null, String.format("Wallet update successfully with %d.", walletDto.getWalletId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Wallet not found with %d.", walletDto.getWalletId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllWallet(String countryCode, Enable enable) {
        return CommonUtils.getResponseWithData(this.walletRepository
            .setAllWalletStatusByCountryCode(enable.name(), countryCode), HttpStatus.OK.series().name(),
            null, "All Wallet update successfully.");
    }

    @Override
    public GenericResponseDto<Object> findByWalletId(Long walletId) {
        Optional<Wallet> wallet = this.walletRepository.findById(walletId);
        if (wallet.isPresent()) {
            WalletDto walletDto = new WalletDto();
            walletDto.setWalletId(wallet.get().getWalletId());
            walletDto.setWalletName(wallet.get().getWalletName());
            walletDto.setEnable(Enable.valueOf(wallet.get().getEnabled()));
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(), null,
                    String.format("Wallet find successfully with %d.", walletId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Wallet not found with %d.", walletId));
    }

    @Override
    public GenericResponseDto<Object> updateWallet(WalletDto walletDto) {
        if (CommonUtils.isNull(walletDto.getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Wallet id missing.");
        } else if (CommonUtils.isNull(walletDto.getWalletName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Wallet name missing.");
        } else if (this.walletRepository.findByWalletName(walletDto.getWalletName()).isPresent()) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Wallet name already exist.");
        }
        Optional<Wallet> wallet = this.walletRepository.findById(walletDto.getWalletId());
        if (wallet.isPresent()) {
            wallet.get().setWalletName(walletDto.getWalletName());
            wallet.get().setEnabled(walletDto.getEnable().name());
            this.walletRepository.save(wallet.get());
            return CommonUtils.getResponseWithData(walletDto, HttpStatus.OK.series().name(),
                    null, String.format("Wallet update successfully with %d.", walletDto.getWalletId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Wallet not found with %d.", walletDto.getWalletId()));
    }

    @Override
    public GenericResponseDto<Object> deleteWallet(Long walletId) {
        this.partnerRepository.deletePartnerWalletByWalletId(walletId);
        this.walletRepository.deleteById(walletId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Wallet delete successfully with %d.", walletId));
    }

}