package com.barco.imrh.service.impl;

import com.barco.imrh.dto.*;
import com.barco.imrh.repository.PartnerCountryProductRepository;
import com.barco.imrh.repository.PartnerRepository;
import com.barco.imrh.repository.query.EntityQuery;
import com.barco.imrh.entity.Partner;
import com.barco.imrh.entity.PartnerCountryProduct;
import com.barco.imrh.service.PartnerService;
import com.barco.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

    public Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private PartnerCountryProductRepository partnerCountryProductRepository;
    @Autowired
    private EntityQuery entityQuery;

    @Override
    public GenericResponseDto<Object> attachMtoCountryWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getCountry().getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Country code missing.");
        } else if (this.partnerRepository.isAttachMtoCountryWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getCountry().getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Country already link with mto partner.");
        }
        this.partnerRepository.attachMtoCountryWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getCountry().getCountryCode());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format("Mto Country successfully linked with mto partner %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getCity().getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto City id missing.");
        } else if (this.partnerRepository.isAttachMtoCityWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getCity().getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto City already link with mto partner.");
        }

        this.partnerRepository.attachMtoCityWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getCity().getCityId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format("Mto City successfully linked with mto partner %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getWallet().getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Wallet id missing.");
        } else if (this.partnerRepository.isAttachMtoWalletWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getWallet().getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Wallet already link with mto partner.");
        }
        this.partnerRepository.attachMtoWalletWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getWallet().getWalletId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format("Mto Wallet successfully linked with mto partner %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getBank().getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Bank id missing.");
        } else if (this.partnerRepository.isAttachMtoBankWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getBank().getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Bank id already link with mto partner.");
        }
        this.partnerRepository.attachMtoBankWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getBank().getBankId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format("Mto Bank successfully linked with mto partner %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoPartnerCountryProduct(PartnerCountryProductDto partnerCountryProductDto) {
        if (CommonUtils.isNull(partnerCountryProductDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerCountryProductDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Product id missing.");
        } else if (CommonUtils.isNull(partnerCountryProductDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Country code missing.");
        } else if (this.partnerCountryProductRepository.isAttachMtoPartnerCountryProduct(partnerCountryProductDto.getPartnerId(),
                partnerCountryProductDto.getProductId(), partnerCountryProductDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "Mto Partner product like with country.");
        }
        PartnerCountryProduct partnerCountryProduct = new PartnerCountryProduct();
        partnerCountryProduct.setPartnerId(partnerCountryProductDto.getPartnerId());
        partnerCountryProduct.setCountryCode(partnerCountryProductDto.getCountryCode());
        partnerCountryProduct.setProductId(partnerCountryProductDto.getProductId());
        partnerCountryProduct.setEnabled(Enable.Y.name());
        partnerCountryProduct.setPartnerAvailability(Enable.Y.name());
        this.partnerCountryProductRepository.save(partnerCountryProduct);
        return CommonUtils.getResponseWithData(partnerCountryProduct, HttpStatus.OK.series().name(), 
                String.format("Mto partner successfully linked with mto country product %d.", partnerCountryProduct.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Mto Partner id missing.");
        }
        Optional<Partner> partner = this.partnerRepository.findById(partnerDto.getPartnerId());
        if (partner.isPresent()) {
            partner.get().setEnabled(partnerDto.getEnabled().name());
            this.partnerRepository.save(partner.get());
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(),
                     String.format("Mto Partner update successfully with %d.", partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Mto Partner not found with %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable) {
        return CommonUtils.getResponseWithData(this.partnerRepository
            .setAllPartnerStatus(enable.name()), HttpStatus.OK.series().name(),
         "All Mto Partner update successfully.");
    }

    @Override
    public GenericResponseDto<Object> fetchAllMtoPartner() {
        return CommonUtils.getResponseWithData(this.partnerRepository.findAllByOrderByPreferenceOrderAsc()
            .stream().map(partner -> {
                PartnerDto partnerDto = new PartnerDto();
                partnerDto.setPartnerId(partner.getPartnerId());
                partnerDto.setPartnerName(partner.getPartnerName());
                partnerDto.setPartnerImageUrl(partner.getPartnerImageUrl());
                partnerDto.setPreferenceOrder(partner.getPreferenceOrder());
                partnerDto.setForexMarginShare(partner.getForexMarginShare());
                partnerDto.setPartnerShare(partner.getPartnerShare());
                partnerDto.setTransferSpeed(partner.getTransferSpeed());
                partnerDto.setPartnerCategory(partner.getPartnerCategory());
                partnerDto.setPartnerTxtIdLabel(partner.getPartnerTxtIdLabel());
                partnerDto.setEnabled(Enable.valueOf(partner.getEnabled()));
                return partnerDto;
            }).collect(Collectors.toList()),
            HttpStatus.OK.series().name(),  String.format("Mto Partner fetch successfully."));
    }

    @Override
    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId) {
        Optional<Partner> partner = this.partnerRepository.findById(partnerId);
        if (partner.isPresent()) {
            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setPartnerId(partner.get().getPartnerId());
            partnerDto.setPartnerName(partner.get().getPartnerName());
            partnerDto.setPartnerImageUrl(partner.get().getPartnerImageUrl());
            partnerDto.setPreferenceOrder(partner.get().getPreferenceOrder());
            partnerDto.setForexMarginShare(partner.get().getForexMarginShare());
            partnerDto.setPartnerShare(partner.get().getPartnerShare());
            partnerDto.setTransferSpeed(partner.get().getTransferSpeed());
            partnerDto.setPartnerCategory(partner.get().getPartnerCategory());
            partnerDto.setPartnerTxtIdLabel(partner.get().getPartnerTxtIdLabel());
            partnerDto.setEnabled(Enable.valueOf(partner.get().getEnabled()));
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
                String.format("Mto Partner find successfully with %d.", partnerId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Mto Partner not found with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> findMtoCountryByMtoPartnerId(Long partnerId) {
        Optional<Partner> partner = this.partnerRepository.findById(partnerId);
        if (partner.isPresent()) {
            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setPartnerId(partner.get().getPartnerId());
            partnerDto.setPartnerName(partner.get().getPartnerName());
            partnerDto.setPartnerImageUrl(partner.get().getPartnerImageUrl());
            partnerDto.setPreferenceOrder(partner.get().getPreferenceOrder());
            partnerDto.setForexMarginShare(partner.get().getForexMarginShare());
            partnerDto.setPartnerShare(partner.get().getPartnerShare());
            partnerDto.setTransferSpeed(partner.get().getTransferSpeed());
            partnerDto.setPartnerCategory(partner.get().getPartnerCategory());
            partnerDto.setPartnerTxtIdLabel(partner.get().getPartnerTxtIdLabel());
            partnerDto.setEnabled(Enable.valueOf(partner.get().getEnabled()));
            partnerDto.setCountries(partner.get().getCountries()
            .stream().map(country -> {
                CountryDto countryDto = new CountryDto();
                countryDto.setCountryCode(country.getCountryCode());
                countryDto.setCountryLegacyCode(country.getCountryLegacyCode());
                countryDto.setCountryName(country.getCountryName());
                countryDto.setCountryImageUrl(country.getCountryImageUrl());
                countryDto.setEnabled(Enable.valueOf(country.getEnabled()));
                return countryDto;
            }).collect(Collectors.toSet()));
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
                String.format("Mto Partner find successfully with %d.", partnerId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Mto Partner not found with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> findMtoCityByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoCityByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), 
            String.format("Mto City successfully fetch with mto partner %d and mto country code %s", partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findProductByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerCountryProductRepository.findProductByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), 
            String.format("Mto Product successfully fetch with mto partner %d and mto country code %s", partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findMtoWalletByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoWalletByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), 
            String.format("Mto Wallet successfully fetch with mto partner %d and mto country code %s", partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findMtoBankByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoBankByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), 
            String.format("Mto Bank successfully fetch with mto partner %d and mto country code %s", partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner name missing.");
        } else if (CommonUtils.isNull(partnerDto.getPreferenceOrder())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner preferenceOrder missing.");
        } else if (CommonUtils.isNull(partnerDto.getForexMarginShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner forexMarginShare missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner partnerShare missing.");
        } else if (CommonUtils.isNull(partnerDto.getTransferSpeed())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner transferSpeed missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerCategory())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner partnerCategory missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerTxtIdLabel())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Mto Partner partnerTxtIdLabel missing.");
        }
        Optional<Partner> partner = this.partnerRepository.findById(partnerDto.getPartnerId());
        if (partner.isPresent()) {
            partner.get().setPartnerName(partnerDto.getPartnerName());
            partner.get().setPartnerImageUrl(partnerDto.getPartnerImageUrl());
            partner.get().setPreferenceOrder(partnerDto.getPreferenceOrder());
            partner.get().setForexMarginShare(partnerDto.getForexMarginShare());
            partner.get().setPartnerShare(partnerDto.getPartnerShare());
            partner.get().setTransferSpeed(partnerDto.getTransferSpeed());
            partner.get().setPartnerCategory(partnerDto.getPartnerCategory());
            partner.get().setPartnerTxtIdLabel(partnerDto.getPartnerTxtIdLabel());
            partner.get().setEnabled(partnerDto.getEnabled().name());
            this.partnerRepository.save(partner.get());
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(),
                 String.format("Mto Partner update successfully with %d.", partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format("Mto Partner not found with %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList) {
        this.entityQuery.executeUpdateQuery(this.entityQuery.changePreferenceOrderQuery(partnerDtoList));
        return CommonUtils.getResponseWithData(partnerDtoList, HttpStatus.OK.series().name(),
             "Mto Partner's preference order update successfully.");
    }

    /**
     * All mapping will auto delete due to CascadeType-all
     * table effect after delete teh mto partner
     * will auto delete the (partner_country, partner_city, partner_wallet, partner_bank, partner_country_product)
     * */
    @Override
    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId) {
        this.partnerRepository.deletePartnerCountryByPartnerId(partnerId);
        this.partnerRepository.deletePartnerCityByPartnerId(partnerId);
        this.partnerRepository.deletePartnerBankByPartnerId(partnerId);
        this.partnerRepository.deletePartnerWalletByPartnerId(partnerId);
        this.partnerCountryProductRepository.deleteByProductId(partnerId);
        this.partnerRepository.deleteById(partnerId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format("Mto Partner delete successfully with %d.", partnerId));
    }

    /**
     * If country delete it will delete the wallet,bank,city link with mto-partner-country
     * **/
    @Override
    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(Long partnerId, String countryCode) {
        this.partnerRepository.deletePartnerCountryByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerCountryProductRepository.deleteMtoPartnerCountryProduct(partnerId, countryCode);
        this.partnerRepository.deletePartnerCityByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerRepository.deletePartnerBankByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerRepository.deletePartnerWalletByPartnerIdAndCountryCode(partnerId, countryCode);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format("Mto Country delete from mto partner successfully with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(Long partnerId, Long cityId) {
        this.partnerRepository.deletePartnerCityByPartnerIdAndCityId(partnerId, cityId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format("Mto City delete from mto partner successfully with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(Long partnerId, Long walletId) {
        this.partnerRepository.deletePartnerWalletByPartnerIdAndWalletId(partnerId, walletId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format("Mto Wallet delete from mto partner successfully with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(Long partnerId, Long bankId) {
        this.partnerRepository.deletePartnerBankByPartnerIdAndBankId(partnerId, bankId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format("Mto Bank delete from mto partner successfully with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode) {
        this.partnerCountryProductRepository.deleteMtoPartnerCountryProduct(partnerId, productId, countryCode);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format("Mto partner link delete successfully with %d.", partnerId));
    }
}