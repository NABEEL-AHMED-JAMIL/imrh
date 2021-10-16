package com.etisalat.imrh.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtoPartnerCustomerValidation that = (MtoPartnerCustomerValidation) o;
        return Objects.equals(partnerId, that.partnerId) && Objects.equals(customerNumber, that.customerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerId, customerNumber);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

 }
