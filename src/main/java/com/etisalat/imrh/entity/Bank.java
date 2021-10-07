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
@Table(name = "BANK")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bank extends BaseEntity {

    @GenericGenerator(
        name = "bankSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "BANK_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "bankSequenceGenerator")
    @Column(name="BANK_ID", unique=true, nullable=false)
    private Long bankId;

    @Column(name="BANK_NAME", unique=true, nullable=false)
    private String bankName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COUNTRY_CODE", nullable=false)
    private Country country;

    public Bank() { }

    public Long getBankId() {
        return bankId;
    }
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}