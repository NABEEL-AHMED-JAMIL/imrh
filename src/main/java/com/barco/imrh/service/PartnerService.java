package com.barco.imrh.service;

import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.PartnerCountryProductDto;
import com.barco.imrh.dto.PartnerDto;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerService {

    public static final String MTO_PARTNER_ID_MISSING = "Mto Partner id missing.";
    public static final String MTO_PARTNER_NAME_MISSING = "Mto Partner name missing.";
    public static final String MTO_PARTNER_PREFERENCE_ORDER_MISSING = "Mto Partner preferenceOrder missing.";
    public static final String MTO_PARTNER_FOREX_MARGIN_SHARE_MISSING = "Mto Partner forexMarginShare missing.";
    public static final String MTO_PARTNER_PARTNER_SHARE_MISSING = "Mto Partner partnerShare missing.";
    public static final String MTO_PARTNER_TRANSFER_SPEED_MISSING = "Mto Partner transferSpeed missing.";
    public static final String MTO_PARTNER_PARTNER_CATEGORY_MISSING = "Mto Partner partnerCategory missing.";
    public static final String MTO_PARTNER_PARTNER_TXT_ID_LABEL_MISSING = "Mto Partner partnerTxtIdLabel missing.";
    public static final String MTO_PARTNER_UPDATE_SUCCESSFULLY_WITH_ID = "Mto Partner update successfully with %d.";
    public static final String MTO_PARTNER_NOT_FOUND_WITH_ID = "Mto Partner not found with %d.";
    public static final String MTO_COUNTRY_CODE_MISSING = "Mto Country code missing.";
    public static final String MTO_COUNTRY_ALREADY_LINK_WITH_MTO_PARTNER = "Mto Country already link with mto partner.";
    public static final String MTO_COUNTRY_SUCCESSFULLY_LINK_WITH_MTO_PARTNER = "Mto Country successfully linked with mto partner %d.";
    public static final String MTO_CITY_ID_MISSING = "Mto City id missing.";
    public static final String MTO_CITY_ALREADY_LINK_WITH_MTO_PARTNER = "Mto City already link with mto partner.";
    public static final String MTO_CITY_SUCCESSFULLY_LINK_WITH_MTO_PARTNER_ID = "Mto City successfully linked with mto partner %d.";
    public static final String MTO_WALLET_ID_MISSING = "Mto Wallet id missing.";
    public static final String MTO_WALLET_ALREADY_LINK_WITH_MTO_PARTNER = "Mto Wallet already link with mto partner.";
    public static final String MTO_WALLET_SUCCESSFULLY_LINKED_WITH_NTI_PARTNER_ID = "Mto Wallet successfully linked with mto partner %d.";
    public static final String MTO_BANK_ID_MISSING = "Mto Bank id missing.";
    public static final String MTO_BANK_ID_ALREADY_LINK_WITH_MTO_PARTNER = "Mto Bank id already link with mto partner.";
    public static final String MTO_BANK_SUCCESSFULLY_LINKED_WITH_MTO_PARTNER_ID = "Mto Bank successfully linked with mto partner %d.";
    public static final String MTO_PRODUCT_ID_MISSING = "Mto Product id missing.";
    public static final String MTO_PARTNER_PRODUCT_LINK_WITH_COUNTRY = "Mto Partner product like with country.";
    public static final String MTO_PARTNER_SUCCESSFULLY_LINKED_WITH_MTO_COUNTRY_PRODUCT_ID = "Mto partner successfully linked with mto country product %d.";
    public static final String ALL_MTO_PARTNER_UPDATE_SUCCESSFULLY = "All Mto Partner update successfully.";
    public static final String MTO_PARTNER_FETCH_SUCCESSFULLY = "Mto Partner fetch successfully.";
    public static final String MTO_PARTNER_FIND_SUCCESSFULLY_WITH_ID = "Mto Partner find successfully with %d.";
    public static final String MTO_CITY_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "Mto City successfully fetch with mto partner %d and mto country code %s";
    public static final String MTO_PRODUCT_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "Mto Product successfully fetch with mto partner %d and mto country code %s";
    public static final String MTO_WALLET_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "Mto Wallet successfully fetch with mto partner %d and mto country code %s";
    public static final String MTO_BANK_SUCCESSFULLY_FETCH_WITH_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "Mto Bank successfully fetch with mto partner %d and mto country code %s";
    public static final String MTO_PARTNERS_PREFERENCE_ORDER_UPDATE_SUCCESSFULLY = "Mto Partner's preference order update successfully.";
    public static final String MTO_PARTNER_DELETE_SUCCESSFULLY_WITH_ID = "Mto Partner delete successfully with %d.";
    public static final String MTO_COUNTRY_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID = "Mto Country delete from mto partner successfully with %d.";
    public static final String MTO_CITY_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID = "Mto City delete from mto partner successfully with %d.";
    public static final String MTO_WALLET_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID = "Mto Wallet delete from mto partner successfully with %d.";
    public static final String MTO_BANK_DELETE_FROM_MTO_PARTNER_SUCCESSFULLY_WITH_ID = "Mto Bank delete from mto partner successfully with %d.";
    public static final String MTO_PARTNER_LINK_DELETE_SUCCESSFULLY_WITH_ID = "Mto partner link delete successfully with %d.";


    public GenericResponseDto<Object> attachMtoCountryWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoPartnerCountryProduct(PartnerCountryProductDto partnerCountryProductDto);

    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable);

    public GenericResponseDto<Object> fetchAllMtoPartner();

    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId);

    public GenericResponseDto<Object> findMtoCountryByMtoPartnerId(Long partnerId);

    public GenericResponseDto<Object> findMtoCityByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    public GenericResponseDto<Object> findProductByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    public GenericResponseDto<Object> findMtoWalletByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    public GenericResponseDto<Object> findMtoBankByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList);

    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId);

    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(Long partnerId, String countryCode);

    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(Long partnerId, Long cityId);

    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(Long partnerId, Long walletId);

    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(Long partnerId, Long bankId);

    public GenericResponseDto<Object> deleteMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode);

}