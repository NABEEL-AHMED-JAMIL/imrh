package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "COUNTRY")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country extends BaseEntity {

    @Id
    @Column(name="COUNTRY_CODE", unique=true, nullable=false)
    private String countryCode;

    @Column(name="COUNTRY_NAME", unique=true, nullable=false)
    private String countryName;

    @Column(name="COUNTRY_LEGACY_CODE", unique=true, nullable=false)
    private String countryLegacyCode;

    @Column(name="COUNTRY_IMAGE_URl")
    private String countryImageUrl;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<City> cities = new ArrayList<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bank> banks = new ArrayList<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wallet> wallets = new ArrayList<>();

    public Country() { }

    public Country(String enabled, String countryName, String countryLegacyCode,
        String countryImageUrl, List<City> cities, List<Bank> banks, List<Wallet> wallets) {
        super(enabled);
        this.countryName = countryName;
        this.countryLegacyCode = countryLegacyCode;
        this.countryImageUrl = countryImageUrl;
        this.cities = cities;
        this.banks = banks;
        this.wallets = wallets;
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

    public String getCountryLegacyCode() {
        return countryLegacyCode;
    }
    public void setCountryLegacyCode(String countryLegacyCode) {
        this.countryLegacyCode = countryLegacyCode;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }
    public void setCountryImageUrl(String countryImageUrl) {
        this.countryImageUrl = countryImageUrl;
    }

    public List<City> getCities() {
        return cities;
    }
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Bank> getBanks() {
        return banks;
    }
    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}