package com.etislat.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "PARTNER")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Partner extends BaseEntity {

    @GenericGenerator(
        name = "partnerSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PARTNER_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "partnerSequenceGenerator")
    @Column(name="PARTNER_ID", unique=true, nullable=false)
    private Long partnerId;

    @Column(name="PARTNER_NAME", nullable=false)
    private String partnerName;

    @Column(name="PREFERENCE_ORDER")
    private Integer preferenceOrder;

    @Column(name="FOREX_MARGIN_SHARE")
    private Double forexMarginShare;

    @Column(name="PARTNER_SHARE")
    private Double partnerShare;

    @Column(name="TRANSFER_SPEED")
    private String transferSpeed;

    @Column(name="PARTNER_CATEGORY")
    private String partnerCategory;

    @Column(name="PARTNER_TXT_ID_LABEL")
    private String partnerTxtIdLabel;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="PARTNER_CITY",
        joinColumns=@JoinColumn(name="PARTNER_ID"),
        inverseJoinColumns=@JoinColumn(name="CITY_ID"))
    private Set<City> cities = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="PARTNER_BANK",
            joinColumns=@JoinColumn(name="PARTNER_ID"),
            inverseJoinColumns=@JoinColumn(name="BANK_ID"))
    private Set<Bank> banks = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="PARTNER_WALLET",
            joinColumns=@JoinColumn(name="PARTNER_ID"),
            inverseJoinColumns=@JoinColumn(name="WALLET_ID"))
    private Set<Wallet> wallets  = new HashSet<>();

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<PartnerCustomer> partnerCustomers = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="PARTNER_COUNTRY",
            joinColumns=@JoinColumn(name="PARTNER_ID"),
            inverseJoinColumns=@JoinColumn(name="COUNTRY_CODE"))
    private Set<Country> countries  = new HashSet<>();

    public Partner() {}

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

    public Set<City> getCities() {
        return cities;
    }
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<Bank> getBanks() {
        return banks;
    }
    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public Set<Wallet> getWallets() {
        return wallets;
    }
    public void setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<PartnerCustomer> getPartnerCustomers() {
        return partnerCustomers;
    }
    public void setPartnerCustomers(List<PartnerCustomer> partnerCustomers) {
        this.partnerCustomers = partnerCustomers;
    }

    public Set<Country> getCountries() {
        return countries;
    }
    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
