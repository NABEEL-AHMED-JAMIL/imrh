package com.etisalat.imrh.entity;

import com.google.gson.Gson;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Nabeel Ahmed
 */
public class PartnerCountryProductId implements Serializable {

    @Id
    @Column(name="PARTNER_ID")
    private Long partnerId;

    @Id
    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Id
    @Column(name="PRODUCT_ID")
    private Long productId;

    public PartnerCountryProductId() {}

    public PartnerCountryProductId(Long partnerId, String countryCode, Long productId) {
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}