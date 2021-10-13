package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.GenericResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerCustomerService {

    public ResponseEntity<?> downloadMtoPartnerCustomer();

    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file);

}
