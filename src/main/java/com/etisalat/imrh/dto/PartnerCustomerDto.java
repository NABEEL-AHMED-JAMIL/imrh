package com.etisalat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerCustomerDto {

    private Long customerId;
    private String customerNumber;
    private Long partnerId;
    private List<PartnerDto> partner;

    public PartnerCustomerDto() {}

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public List<PartnerDto> getPartner() {
        return partner;
    }
    public void setPartner(List<PartnerDto> partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
