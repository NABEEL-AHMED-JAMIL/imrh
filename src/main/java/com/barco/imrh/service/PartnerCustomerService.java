package com.barco.imrh.service;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.PartnerCustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
public interface PartnerCustomerService {

    public static final String CUSTOMER_MSISDN_MISSING = "Customer msisdn missing.";
    public static final String CUSTOMER_MSISDN_NOT_VALID = "Customer msisdn not valid.";
    public static final String PARTNER_CUSTOMER_FETCH_SUCCESSFULLY = "Partner customer fetch successfully.";
    public static final String CONTENT = "content";
    public static final String PAGE_NUMBER = "pageNumber";
    public static final String PAGE_SIZE = "pageSize";
    public static final String TOTAL_ELEMENTS ="totalElements";
    public static final String TOTAL_PAGES = "totalPages";
    public static final String PARTNER_ID_MISSING = "Partner id missing.";
    public static final String PARTNER_NOT_EXIST = "Partner not exist.";
    public static final String CUSTOMER_MSISDN_LINKED_WITH_OTHER_PARTNER = "Customer %s msisdn linked with other partner.";
    public static final String CUSTOMER_MSISDN_SAVE_SUCCESSFULLY = "Customer msisdn save successfully.";
    public static final String PARTNER_CUSTOMER_ID_MISSING = "Partner customer id missing.";
    public static final String PARTNER_CUSTOMER_UPDATE_SUCCESSFULLY = "Partner customer update successfully.";
    public static final String PARTNER_CUSTOMER_DELETE_SUCCESSFULLY_WITH_ID = "Partner customer delete successfully with %d.";
    public static final String MTO_PARTNER_CUSTOMER = "Mto Partner Customer";
    public static final String MSISDN = "MSISDN";
    public static final String MTO_PARTNER_ID = "Mto Partner Id";
    public static final String MTO_PARTNER_NAME = "Mto Partner name";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String ATTACHMENT_FILENAME_MTO_PARTNER_CUSTOMER_XLSX= "attachment; filename=Mto Partner Customer.xlsx";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_VND_OPEN_XML_FORMATS_OFFICE_DOCUMENT_SPREAD_SHEET = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String YOU_UPLOAD_EMPTY_SOURCE_FILE = "You upload empty source file.";
    public static final String YOU_CONT_UPLOAD_EMPTY_SOURCE_FILE = "You can't upload empty source file.";
    public static final String SOURCE_AT_ROW_SOME_HEADINGS_MISSING = "Source at row %d some headings missing (MSISDN,Mto Partner Id).";
    public static final String SOURCE_AT_ROW_MSISDN_HEADINGS_MISSING = "Source at row %d MSISDN headings missing.";
    public static final String SOURCE_AT_ROW_MTO_PARTNER_ID_HEADINGS_MISSING = "Source at row %d Mto Partner Id headings missing.";
    public static final String SOURCE_AT_ROW_MSISDN_MISSING = "Source at row %d MSISDN missing.";
    public static final String SOURCE_AT_ROW_MSISDN_SHOULD_BE_VALID = "Source at row %d MSISDN %s should be valid.";
    public static final String SOURCE_AT_ROW_MTO_PARTNER_ID_MISSING = "Source at row %d Mto Partner Id missing.";
    public static final String SOURCE_AT_ROW_MTO_PARTNER_ID_SHOULD_BE_VALID_DIGIT_ID = "Source at row %d Mto Partner Id %s should be valid digit id.";
    public static final String SOURCE_AT_ROW_MTO_PARTNER_ID_SHOULD_BE_VALID_PARTNER_ID = "Source at row %d Mto Partner Id %s should be valid partner id.";
    public static final String SOURCE_VALIDATION_FAIL = "Source validation fail.";
    public static final String SOURCE_FILE_SUCCESSFULLY_VALIDATE_AND_PROCESSING_IN_BACKEND = "Source file successfully validate and processing in backend.";
    public static final String SHEET_NOT_FOUND_WITH_MTO_PARTNER_CUSTOMER = "Sheet not found with (Mto Partner Customer).";

    public GenericResponseDto<Object> searchCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public GenericResponseDto<Object> fetchCustomerMsisdn(Integer pageNumber, Integer pageSize);

    public GenericResponseDto<Object> createCustomerMsisdn(Set<PartnerCustomerDto> partnerCustomerSet);

    public GenericResponseDto<Object> updatePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public GenericResponseDto<Object> deletePartnerCustomerMsisdn(PartnerCustomerDto partnerCustomer);

    public ResponseEntity<?> downloadMtoPartnerCustomer() throws IOException;

    public GenericResponseDto<Object> uploadMtoPartnerCustomer(MultipartFile file) throws IOException;

}
