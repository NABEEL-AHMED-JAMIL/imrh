package com.etisalat.imrh.entity;

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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities = new ArrayList<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Bank> banks = new ArrayList<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Wallet> wallets = new ArrayList<>();

    public Country() { }

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
