package com.etisalat.imrh.entity;

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
@Table(name = "PARTNER_CUSTOMER")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerCustomer {

    @GenericGenerator(
        name = "partnerCustomerSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PARTNER_CUSTOMER_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "partnerCustomerSequenceGenerator")
    @Column(name="CUSTOMER_ID", nullable=false)
    private Long customerId;

    @Column(name="CUSTOMER_NUMBER", nullable=false, unique = true)
    private String customerNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARTNER_ID", nullable=false)
    private Partner partner;

    public PartnerCustomer() {}

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Partner getPartner() {
        return partner;
    }
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}