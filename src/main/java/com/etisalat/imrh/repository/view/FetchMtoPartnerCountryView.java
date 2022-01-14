package com.etisalat.imrh.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchMtoPartnerCountryView {

    private Long partnerId;
    private String partnerName;
    private String countryName;

    public FetchMtoPartnerCountryView() {}

    public FetchMtoPartnerCountryView(Long partnerId, String partnerName, String countryName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.countryName = countryName;
    }

    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}