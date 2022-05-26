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
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getCountry().getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_COUNTRY_CODE_MISSING);
        } else if (this.partnerRepository.isAttachMtoCountryWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getCountry().getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_COUNTRY_ALREADY_LINK_WITH_MTO_PARTNER);
        }
        this.partnerRepository.attachMtoCountryWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getCountry().getCountryCode());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format(MTO_COUNTRY_SUCCESSFULLY_LINK_WITH_MTO_PARTNER, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getCity().getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_CITY_ID_MISSING);
        } else if (this.partnerRepository.isAttachMtoCityWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getCity().getCityId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), MTO_CITY_ALREADY_LINK_WITH_MTO_PARTNER);
        }
        this.partnerRepository.attachMtoCityWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getCity().getCityId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format(MTO_CITY_SUCCESSFULLY_LINK_WITH_MTO_PARTNER_ID, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getWallet().getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_WALLET_ID_MISSING);
        } else if (this.partnerRepository.isAttachMtoWalletWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getWallet().getWalletId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_WALLET_ALREADY_LINK_WITH_MTO_PARTNER);
        }
        this.partnerRepository.attachMtoWalletWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getWallet().getWalletId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format(MTO_WALLET_SUCCESSFULLY_LINKED_WITH_NTI_PARTNER_ID, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getBank().getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_BANK_ID_MISSING);
        } else if (this.partnerRepository.isAttachMtoBankWithMtoPartner(partnerDto.getPartnerId(),
                partnerDto.getBank().getBankId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_BANK_ID_ALREADY_LINK_WITH_MTO_PARTNER);
        }
        this.partnerRepository.attachMtoBankWithMtoPartner(partnerDto.getPartnerId(), partnerDto.getBank().getBankId());
        return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), 
            String.format(MTO_BANK_SUCCESSFULLY_LINKED_WITH_MTO_PARTNER_ID, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> attachMtoPartnerCountryProduct(PartnerCountryProductDto partnerCountryProductDto) {
        if (CommonUtils.isNull(partnerCountryProductDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerCountryProductDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), MTO_PRODUCT_ID_MISSING);
        } else if (CommonUtils.isNull(partnerCountryProductDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), MTO_COUNTRY_CODE_MISSING);
        } else if (this.partnerCountryProductRepository.isAttachMtoPartnerCountryProduct(partnerCountryProductDto.getPartnerId(),
                partnerCountryProductDto.getProductId(), partnerCountryProductDto.getCountryCode())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), MTO_PARTNER_PRODUCT_LINK_WITH_COUNTRY);
        }
        PartnerCountryProduct partnerCountryProduct = new PartnerCountryProduct();
        partnerCountryProduct.setPartnerId(partnerCountryProductDto.getPartnerId());
        partnerCountryProduct.setCountryCode(partnerCountryProductDto.getCountryCode());
        partnerCountryProduct.setProductId(partnerCountryProductDto.getProductId());
        partnerCountryProduct.setEnabled(Enable.Y.name());
        partnerCountryProduct.setPartnerAvailability(Enable.Y.name());
        this.partnerCountryProductRepository.save(partnerCountryProduct);
        return CommonUtils.getResponseWithData(partnerCountryProduct, HttpStatus.OK.series().name(), 
                String.format(MTO_PARTNER_SUCCESSFULLY_LINKED_WITH_MTO_COUNTRY_PRODUCT_ID, partnerCountryProduct.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), MTO_PARTNER_ID_MISSING);
        }
        Optional<Partner> partner = this.partnerRepository.findById(partnerDto.getPartnerId());
        if (partner.isPresent()) {
            partner.get().setEnabled(partnerDto.getEnabled().name());
            this.partnerRepository.save(partner.get());
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(),
                     String.format(MTO_PARTNER_UPDATE_SUCCESSFULLY_WITH_ID, partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(MTO_PARTNER_NOT_FOUND_WITH_ID, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable) {
        return CommonUtils.getResponseWithData(this.partnerRepository.setAllPartnerStatus(enable.name()),
            HttpStatus.OK.series().name(), ALL_MTO_PARTNER_UPDATE_SUCCESSFULLY);
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
            HttpStatus.OK.series().name(),  String.format(MTO_PARTNER_FETCH_SUCCESSFULLY));
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
                String.format(MTO_PARTNER_FIND_SUCCESSFULLY_WITH_ID, partnerId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(MTO_PARTNER_NOT_FOUND_WITH_ID, partnerId));
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
                String.format(MTO_PARTNER_FIND_SUCCESSFULLY_WITH_ID, partnerId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(MTO_PARTNER_NOT_FOUND_WITH_ID, partnerId));
    }

    @Override
    public GenericResponseDto<Object> findMtoCityByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoCityByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), String.format(MTO_CITY_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE,
                 partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findProductByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerCountryProductRepository.findProductByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), String.format(MTO_PRODUCT_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE,
                 partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findMtoWalletByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoWalletByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), String.format(MTO_WALLET_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE,
                 partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> findMtoBankByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode) {
        return CommonUtils.getResponseWithData(this.partnerRepository.findMtoBankByMtoPartnerIdAndMtoCountryCode(partnerId, countryCode),
            HttpStatus.OK.series().name(), String.format(MTO_BANK_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE,
                 partnerId, countryCode));
    }

    @Override
    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), MTO_PARTNER_ID_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getPartnerName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), MTO_PARTNER_NAME_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getPreferenceOrder())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), MTO_PARTNER_PREFERENCE_ORDER_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getForexMarginShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                .series().name(), MTO_PARTNER_FOREX_MARGIN_SHARE_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getPartnerShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                 .series().name(), MTO_PARTNER_PARTNER_SHARE_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getTransferSpeed())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                  .series().name(), MTO_PARTNER_TRANSFER_SPEED_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getPartnerCategory())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                  .series().name(), MTO_PARTNER_PARTNER_CATEGORY_MISSING);
        } else if (CommonUtils.isNull(partnerDto.getPartnerTxtIdLabel())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                  .series().name(), MTO_PARTNER_PARTNER_TXT_ID_LABEL_MISSING);
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
                 String.format(MTO_PARTNER_UPDATE_SUCCESSFULLY_WITH_ID, partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format(MTO_PARTNER_NOT_FOUND_WITH_ID, partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList) {
        this.entityQuery.executeUpdateQuery(this.entityQuery.changePreferenceOrderQuery(partnerDtoList));
        return CommonUtils.getResponseWithData(partnerDtoList, HttpStatus.OK.series().name(),
                MTO_PARTNERS_PREFERENCE_ORDER_UPDATE_SUCCESSFULLY);
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
            String.format(MTO_PARTNER_DELETE_SUCCESSFULLY_WITH_ID, partnerId));
    }

    /**
     * If country delete it will delete the wallet,bank,city link with mto-partner-country
     * **/
    @Override
    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(Long partnerId, String countryCode) {
        this.partnerRepository.deletePartnerCountryByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerCountryProductRepository.deleteMtoPartnerCountryProductByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerRepository.deletePartnerCityByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerRepository.deletePartnerBankByPartnerIdAndCountryCode(partnerId, countryCode);
        this.partnerRepository.deletePartnerWalletByPartnerIdAndCountryCode(partnerId, countryCode);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format(MTO_COUNTRY_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID, partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(Long partnerId, Long cityId) {
        this.partnerRepository.deletePartnerCityByPartnerIdAndCityId(partnerId, cityId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format(MTO_CITY_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID, partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(Long partnerId, Long walletId) {
        this.partnerRepository.deletePartnerWalletByPartnerIdAndWalletId(partnerId, walletId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format(MTO_WALLET_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID, partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(Long partnerId, Long bankId) {
        this.partnerRepository.deletePartnerBankByPartnerIdAndBankId(partnerId, bankId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
            String.format(MTO_BANK_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID, partnerId));
    }

    @Override
    public GenericResponseDto<Object> deleteMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode) {
        this.partnerCountryProductRepository.deleteMtoPartnerCountryProductByPartnerIdAndProductIdAndCountryCode(
            partnerId, productId, countryCode);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.OK.series().name(),
                String.format(MTO_PARTNER_LINK_DELETE_SUCCESSFULLY_WITH_ID, partnerId));
    }
}