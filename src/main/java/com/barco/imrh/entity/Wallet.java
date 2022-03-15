package com.barco.imrh.entity;

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
@Table(name = "WALLET")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wallet extends BaseEntity {

    @GenericGenerator(
        name = "walletSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "WALLET_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "walletSequenceGenerator")
    @Column(name="WALLET_ID", unique=true, nullable=false)
    private Long walletId;

    @Column(name="WALLET_NAME", nullable=false)
    private String walletName;

    @Column(name="WALLET_IMAGE_URl")
    private String walletImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COUNTRY_CODE", nullable=false)
    private Country country;

    public Wallet() { }

    public Wallet(String enabled, String walletName,
        String walletImageUrl, Country country) {
        super(enabled);
        this.walletName = walletName;
        this.walletImageUrl = walletImageUrl;
        this.country = country;
    }

    public Long getWalletId() {
        return walletId;
    }
    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }
    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletImageUrl() {
        return walletImageUrl;
    }
    public void setWalletImageUrl(String walletImageUrl) {
        this.walletImageUrl = walletImageUrl;
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