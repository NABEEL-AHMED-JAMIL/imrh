package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerCustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerCustomerService {

    public GenericResponseDto<Object> searchCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public GenericResponseDto<Object> fetchCustomerMsisdn(Integer pageNumber, Integer pageSize);

    public GenericResponseDto<Object> createCustomerMsisdn(Set<PartnerCustomerDto> partnerCustomerSet);

    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public ResponseEntity<?> downloadMtoPartnerCustomer() throws IOException;

    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) throws IOException;

}
