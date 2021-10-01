package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;


public interface PartnerService {

    public GenericResponseDto<Object> enableDisablePartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> enableDisableAllPartner(Enable enable);

    public GenericResponseDto<Object> fetchAllPartner();

    public GenericResponseDto<Object> updatePartner(PartnerDto partnerDto);

    public GenericResponseDto<Object> deletePartner(Long partnerId);

}