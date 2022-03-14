package com.barco.imrh.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchMtoPartnerCountryCityView {

    private Long partnerId;
    private String partnerName;
    private String partnerImageUrl;
    private String countryCode;
    private String countryName;
    private String countryImageUrl;
    private Long cityId;
    private String cityName;
    private String cityEnabled;

    public FetchMtoPartnerCountryCityView() { }

    public FetchMtoPartnerCountryCityView(Long partnerId, String partnerName, String partnerImageUrl,
        String countryCode, String countryName, String countryImageUrl, Long cityId,
        String cityName, String cityEnabled) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerImageUrl = partnerImageUrl;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryImageUrl = countryImageUrl;
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityEnabled = cityEnabled;
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

    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityEnabled() {
        return cityEnabled;
    }
    public void setCityEnabled(String cityEnabled) {
        this.cityEnabled = cityEnabled;
    }

    @Override
    public String toString() {
                return new Gson().toJson(this);
        }
}