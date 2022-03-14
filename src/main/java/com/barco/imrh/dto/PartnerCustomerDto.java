package com.barco.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;

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

    public PartnerCustomerDto(String customerNumber, Long partnerId, List<PartnerDto> partner) {
        this.customerNumber = customerNumber;
        this.partnerId = partnerId;
        this.partner = partner;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartnerCustomerDto that = (PartnerCustomerDto) o;
        return Objects.equals(customerNumber, that.customerNumber) && Objects.equals(partnerId, that.partnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, partnerId);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
