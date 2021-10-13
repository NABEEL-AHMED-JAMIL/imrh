package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.repository.PartnerCustomerRepository;
import com.etisalat.imrh.service.PartnerCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class PartnerCustomerServiceImpl implements PartnerCustomerService {

    @Autowired
    private PartnerCustomerRepository partnerCustomerRepository;

    @Override
    public ResponseEntity<?> downloadMtoPartnerCustomer() {
        return null;
    }

    @Override
    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) {
        return null;
    }
}
