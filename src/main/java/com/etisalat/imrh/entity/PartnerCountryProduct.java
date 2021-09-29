package com.etisalat.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import javax.persistence.*;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "PARTNER_COUNTRY_PRODUCT")
@IdClass(PartnerCountryProductId.class)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerCountryProduct extends BaseEntity {

    @Id
    @Column(name="PARTNER_ID")
    private Long partnerId;

    @Id
    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Id
    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name = "PARTNER_AVAILABILITY",
        columnDefinition = "CHAR(1)", nullable = false)
    private String partnerAvailability;

    public PartnerCountryProduct() {}

    public PartnerCountryProduct(Long partnerId, String countryCode, Long productId) {
        this.partnerId = partnerId;
        this.countryCode = countryCode;
        this.productId = productId;
    }

    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPartnerAvailability() {
        return partnerAvailability;
    }
    public void setPartnerAvailability(String partnerAvailability) {
        this.partnerAvailability = partnerAvailability;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
