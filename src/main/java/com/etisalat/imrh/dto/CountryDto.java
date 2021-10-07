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
public class CountryDto {

    private String countryCode;
    private String countryName;
    private String countryLegacyCode;
    private Enable enable;
    private List<CityDto> cities;
    private List<BankDto> banks;
    private List<WalletDto> wallets;

    public CountryDto() { }

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

    public String getCountryLegacyCode() {
        return countryLegacyCode;
    }
    public void setCountryLegacyCode(String countryLegacyCode) {
        this.countryLegacyCode = countryLegacyCode;
    }

    public Enable getEnable() {
        return enable;
    }
    public void setEnable(Enable enable) {
        this.enable = enable;
    }

    public List<CityDto> getCities() {
        return cities;
    }
    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    public List<BankDto> getBanks() {
        return banks;
    }
    public void setBanks(List<BankDto> banks) {
        this.banks = banks;
    }

    public List<WalletDto> getWallets() {
        return wallets;
    }
    public void setWallets(List<WalletDto> wallets) {
        this.wallets = wallets;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}