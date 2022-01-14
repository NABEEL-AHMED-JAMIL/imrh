package com.etisalat.imrh.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchAllGlobalCountryDetailForReportView {

    private String countryName;
    private String countryCode;
    private String countryStatus;
    private String countryImageUrl;
    private Long totalCity;
    private Long totalWallet;
    private Long totalBank;

    public FetchAllGlobalCountryDetailForReportView() {}

    public FetchAllGlobalCountryDetailForReportView(String countryName, String countryCode, String countryStatus,
        String countryImageUrl, Long totalCity, Long totalWallet, Long totalBank) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryStatus = countryStatus;
        this.countryImageUrl = countryImageUrl;
        this.totalCity = totalCity;
        this.totalWallet = totalWallet;
        this.totalBank = totalBank;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryStatus() {
        return countryStatus;
    }
    public void setCountryStatus(String countryStatus) {
        this.countryStatus = countryStatus;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }
    public void setCountryImageUrl(String countryImageUrl) {
        this.countryImageUrl = countryImageUrl;
    }

    public Long getTotalCity() {
        return totalCity;
    }
    public void setTotalCity(Long totalCity) {
        this.totalCity = totalCity;
    }

    public Long getTotalWallet() {
        return totalWallet;
    }
    public void setTotalWallet(Long totalWallet) {
        this.totalWallet = totalWallet;
    }

    public Long getTotalBank() {
        return totalBank;
    }
    public void setTotalBank(Long totalBank) {
        this.totalBank = totalBank;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}