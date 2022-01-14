package com.etisalat.imrh.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchMtoPartnerCountryWalletView {

    private Long partnerId;
    private String partnerName;
    private String partnerImageUrl;
    private String countryCode;
    private String countryName;
    private String countryImageUrl;
    private Long walletId;
    private String walletName;
    private String walletImageUrl;
    private String walletEnabled;

    public FetchMtoPartnerCountryWalletView() { }

    public FetchMtoPartnerCountryWalletView(Long partnerId, String partnerName, String partnerImageUrl,
        String countryCode, String countryName, String countryImageUrl,
        Long walletId, String walletName, String walletImageUrl, String walletEnabled) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerImageUrl = partnerImageUrl;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryImageUrl = countryImageUrl;
        this.walletId = walletId;
        this.walletName = walletName;
        this.walletImageUrl = walletImageUrl;
        this.walletEnabled = walletEnabled;
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

    public Long getWalletId() {
        return walletId;
    }
    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }
    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletImageUrl() {
        return walletImageUrl;
    }
    public void setWalletImageUrl(String walletImageUrl) {
        this.walletImageUrl = walletImageUrl;
    }

    public String getWalletEnabled() {
        return walletEnabled;
    }
    public void setWalletEnabled(String walletEnabled) {
        this.walletEnabled = walletEnabled;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}