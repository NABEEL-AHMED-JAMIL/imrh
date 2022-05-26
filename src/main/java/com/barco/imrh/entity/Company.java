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
@Table(name = "COMPANY")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends BaseEntity {

    @GenericGenerator(
        name = "companySequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "COMPANY_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "companySequenceGenerator")
    @Column(name="COMPANY_ID", unique=true, nullable=false)
    private Long companyId;

    @Column(name = "COMPANY_NAME",
            nullable = false, unique = true)
    private String companyName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "EMAIL",
        nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public Company() {}

    public Company(String enabled, Long companyId, String companyName, String description,
        String icon, String email, String phone, Address address) {
        super(enabled);
        this.companyId = companyId;
        this.companyName = companyName;
        this.description = description;
        this.icon = icon;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
