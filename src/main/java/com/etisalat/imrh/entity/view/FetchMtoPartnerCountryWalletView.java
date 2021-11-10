package com.etisalat.imrh.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchMtoPartnerCountryWalletView {

    @Id
    @Column(name="partner_id")
    private Long partnerId;

    @Column(name="partner_name")
    private String partnerName;

    @Column(name="partner_image_url")
    private String partnerImageUrl;

    @Column(name="country_code")
    private String countryCode;

    @Column(name="country_name")
    private String countryName;

    @Column(name="country_image_url")
    private String countryImageUrl;

    @Column(name="wallet_id")
    private String walletId;

    @Column(name="wallet_name")
    private String walletName;

    @Column(name="wallet_image_url")
    private String walletImageUrl;

    @Column(name="status")
    private String status;

    public FetchMtoPartnerCountryWalletView() { }

    public Long getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getPartnerImageUrl() {
        return partnerImageUrl;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public String getWalletImageUrl() {
        return walletImageUrl;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}