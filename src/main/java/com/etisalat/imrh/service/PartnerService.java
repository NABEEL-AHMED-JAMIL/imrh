package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerService {

    public GenericResponseDto<Object> attachMtoCountryWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoCityWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoWalletWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> attachMtoBankWithMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable);

    public GenericResponseDto<Object> fetchAllMtoPartner();

    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId);

    public GenericResponseDto<Object> findMtoCountryByMtoPartnerId(Long partnerId);

    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList);

    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId);

    public GenericResponseDto<Object> deleteMtoCountryLinkMtoPartner(Long partnerId, String countryCode);

    public GenericResponseDto<Object> deleteMtoCityLinkMtoPartner(Long partnerId, Long cityId);

    public GenericResponseDto<Object> deleteMtoWalletLinkMtoPartner(Long partnerId, Long walletId);

    public GenericResponseDto<Object> deleteMtoBankLinkMtoPartner(Long partnerId, Long bankId);

}