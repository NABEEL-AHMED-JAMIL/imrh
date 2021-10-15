package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerCustomerService {

    public GenericResponseDto<Object> searchCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public ResponseEntity<?> downloadMtoPartnerCustomer() throws IOException;

    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file);

}
