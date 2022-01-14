package com.etisalat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerDto {

    private Long partnerId;
    private String partnerName;
    private String partnerImageUrl;
    private Enable enabled;
    private Integer preferenceOrder;
    private Double forexMarginShare;
    private Double partnerShare;
    private String transferSpeed;
    private String partnerCategory;
    private String partnerTxtIdLabel;
    private CountryDto country;
    private Set<CountryDto> countries;
    private CityDto city;
    private Set<CityDto> cities;
    private BankDto bank;
    private Set<BankDto> banks;
    private WalletDto wallet;
    private Set<WalletDto> wallets;

    public PartnerDto() {}

    public PartnerDto(Long partnerId, Integer preferenceOrder) {
        this.partnerId = partnerId;
        this.preferenceOrder = preferenceOrder;
    }

    public PartnerDto(String partnerName, String partnerImageUrl, Enable enabled, Integer preferenceOrder,
        Double forexMarginShare, Double partnerShare, String transferSpeed, String partnerCategory,
        String partnerTxtIdLabel, CountryDto country, Set<CountryDto> countries, CityDto city,
        Set<CityDto> cities, BankDto bank, Set<BankDto> banks, WalletDto wallet, Set<WalletDto> wallets) {
        this.partnerName = partnerName;
        this.partnerImageUrl = partnerImageUrl;
        this.enabled = enabled;
        this.preferenceOrder = preferenceOrder;
        this.forexMarginShare = forexMarginShare;
        this.partnerShare = partnerShare;
        this.transferSpeed = transferSpeed;
        this.partnerCategory = partnerCategory;
        this.partnerTxtIdLabel = partnerTxtIdLabel;
        this.country = country;
        this.countries = countries;
        this.city = city;
        this.cities = cities;
        this.bank = bank;
        this.banks = banks;
        this.wallet = wallet;
        this.wallets = wallets;
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

    public Enable getEnabled() {
        return enabled;
    }
    public void setEnabled(Enable enabled) {
        this.enabled = enabled;
    }

    public Integer getPreferenceOrder() {
        return preferenceOrder;
    }
    public void setPreferenceOrder(Integer preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }

    public Double getForexMarginShare() {
        return forexMarginShare;
    }
    public void setForexMarginShare(Double forexMarginShare) {
        this.forexMarginShare = forexMarginShare;
    }

    public Double getPartnerShare() {
        return partnerShare;
    }
    public void setPartnerShare(Double partnerShare) {
        this.partnerShare = partnerShare;
    }

    public String getTransferSpeed() {
        return transferSpeed;
    }
    public void setTransferSpeed(String transferSpeed) {
        this.transferSpeed = transferSpeed;
    }

    public String getPartnerCategory() {
        return partnerCategory;
    }
    public void setPartnerCategory(String partnerCategory) {
        this.partnerCategory = partnerCategory;
    }

    public String getPartnerTxtIdLabel() {
        return partnerTxtIdLabel;
    }
    public void setPartnerTxtIdLabel(String partnerTxtIdLabel) {
        this.partnerTxtIdLabel = partnerTxtIdLabel;
    }

    public CountryDto getCountry() {
        return country;
    }
    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public Set<CountryDto> getCountries() {
        return countries;
    }
    public void setCountries(Set<CountryDto> countries) {
        this.countries = countries;
    }

    public CityDto getCity() {
        return city;
    }
    public void setCity(CityDto city) {
        this.city = city;
    }

    public Set<CityDto> getCities() {
        return cities;
    }
    public void setCities(Set<CityDto> cities) {
        this.cities = cities;
    }

    public BankDto getBank() {
        return bank;
    }
    public void setBank(BankDto bank) {
        this.bank = bank;
    }

    public Set<BankDto> getBanks() {
        return banks;
    }
    public void setBanks(Set<BankDto> banks) {
        this.banks = banks;
    }

    public WalletDto getWallet() {
        return wallet;
    }
    public void setWallet(WalletDto wallet) {
        this.wallet = wallet;
    }

    public Set<WalletDto> getWallets() {
        return wallets;
    }
    public void setWallets(Set<WalletDto> wallets) {
        this.wallets = wallets;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}