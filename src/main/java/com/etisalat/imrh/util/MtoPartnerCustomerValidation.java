package com.etisalat.imrh.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MtoPartnerCustomerValidation {

    private Long partnerId;
    private String customerNumber;

    public MtoPartnerCustomerValidation() { }

    public MtoPartnerCustomerValidation(Long partnerId, String customerNumber) {
        this.partnerId = partnerId;
        this.customerNumber = customerNumber;
    }

    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
