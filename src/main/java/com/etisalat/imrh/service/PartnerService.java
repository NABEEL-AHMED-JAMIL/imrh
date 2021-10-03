package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;

import java.util.List;


public interface PartnerService {

    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable);

    public GenericResponseDto<Object> fetchAllMtoPartner();

    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId);

    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId);

    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList);

}