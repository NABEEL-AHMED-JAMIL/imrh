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
public class FetchAllGlobalCountryDetailForReportView {

    @Id
    @Column(name="country_name")
    private String countryName;

    @Column(name="country_code")
    private String countryCode;

    @Column(name="status")
    private String status;

    @Column(name="country_image_url")
    private String countryImageUrl;

    @Column(name="total_city")
    private Long totalCity;

    @Column(name="total_wallet")
    private Long totalWallet;

    @Column(name="total_bank")
    private Long totalBank;

    public FetchAllGlobalCountryDetailForReportView() {}

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getStatus() {
        return status;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }

    public Long getTotalCity() {
        return totalCity;
    }

    public Long getTotalWallet() {
        return totalWallet;
    }

    public Long getTotalBank() {
        return totalBank;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}