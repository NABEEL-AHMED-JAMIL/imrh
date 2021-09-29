package com.etislat.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "PARTNER_COUNTRY_PRODUCT")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerCountryProduct extends BaseEntity {

    @GenericGenerator(
        name = "partnerCountryProductSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PARTNER_COUNTRY_PRODUCT_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "partnerCountryProductSequenceGenerator")
    @Column(name="PARTNER_COUNTRY_PRODUCT_ID",
        unique=true, nullable=false)
    private Long partnerCountryProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_CODE")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "PARTNER_AVAILABILITY",
        columnDefinition = "CHAR(1)", nullable = false)
    private String partnerAvailability;

    public Long getPartnerCountryProductId() {
        return partnerCountryProductId;
    }
    public void setPartnerCountryProductId(Long partnerCountryProductId) {
        this.partnerCountryProductId = partnerCountryProductId;
    }

    public Partner getPartner() {
        return partner;
    }
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
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
