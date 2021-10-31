package com.etisalat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDto {

    private Long walletId;
    private String walletName;
    private String walletImageUrl;
    private Enable enabled;
    private CountryDto country;

    public WalletDto() { }

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

    public Enable getEnabled() {
        return enabled;
    }
    public void setEnabled(Enable enabled) {
        this.enabled = enabled;
    }

    public CountryDto getCountry() {
        return country;
    }
    public void setCountry(CountryDto country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}