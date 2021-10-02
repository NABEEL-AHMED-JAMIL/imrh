package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.service.PartnerService;
import com.etisalat.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService {

    public Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> fetchAllMtoPartner() {
        return CommonUtils.getResponseWithData(this.partnerRepository.findAllPartner(),
            HttpStatus.OK.series().name(), null, String.format("Partner fetch successfully."));
    }

    @Override
    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId) {
        return null;
    }
}
