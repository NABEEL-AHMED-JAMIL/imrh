package com.barco.imrh.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchMtoPartnerCountryBankView {

    private Long partnerId;
    private String partnerName;
    private String partnerImageUrl;
    private String countryCode;
    private String countryName;
    private String countryImageUrl;
    private Long bankId;
    private String bankName;
    private String bankImageUrl;
    private String bankEnabled;

    public FetchMtoPartnerCountryBankView() { }

    public FetchMtoPartnerCountryBankView(Long partnerId, String partnerName, String partnerImageUrl,
        String countryCode, String countryName, String countryImageUrl,
        Long bankId, String bankName, String bankImageUrl, String bankEnabled) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerImageUrl = partnerImageUrl;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryImageUrl = countryImageUrl;
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankImageUrl = bankImageUrl;
        this.bankEnabled = bankEnabled;
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

    public String getPartnerImageUrl() {
        return partnerImageUrl;
    }
    public void setPartnerImageUrl(String partnerImageUrl) {
        this.partnerImageUrl = partnerImageUrl;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }
    public void setCountryImageUrl(String countryImageUrl) {
        this.countryImageUrl = countryImageUrl;
    }

    public Long getBankId() {
        return bankId;
    }
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankImageUrl() {
        return bankImageUrl;
    }
    public void setBankImageUrl(String bankImageUrl) {
        this.bankImageUrl = bankImageUrl;
    }

    public String getBankEnabled() {
        return bankEnabled;
    }
    public void setBankEnabled(String bankEnabled) {
        this.bankEnabled = bankEnabled;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}