package com.barco.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDto {

    private Long bankId;
    private String bankName;
    private String bankImageUrl;
    private Enable enabled;
    private CountryDto country;

    public BankDto() { }

    public BankDto(String bankName, String bankImageUrl,
        Enable enabled, CountryDto country) {
        this.bankName = bankName;
        this.bankImageUrl = bankImageUrl;
        this.enabled = enabled;
        this.country = country;
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