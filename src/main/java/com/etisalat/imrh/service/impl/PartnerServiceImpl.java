package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.repository.PartnerRepository;
import com.etisalat.imrh.service.PartnerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService {

    public Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public GenericResponseDto<Object> enableDisablePartner(PartnerDto partnerDto) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllPartner(Enable enable) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> fetchAllPartner() {
        return null;
    }

    @Override
    public GenericResponseDto<Object> updatePartner(PartnerDto partnerDto) {
        return null;
    }

    @Override
    public GenericResponseDto<Object> deletePartner(Long partnerId) {
        return null;
    }
}
