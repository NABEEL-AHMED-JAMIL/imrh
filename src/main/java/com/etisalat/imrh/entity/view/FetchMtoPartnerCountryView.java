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
public class FetchMtoPartnerCountryView {

    @Id
    @Column(name="partner_id")
    private Long partnerId;

    @Column(name="partner_name")
    private String partnerName;

    @Column(name="country_name")
    private String countryName;

    public FetchMtoPartnerCountryView() {}

    public Long getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}