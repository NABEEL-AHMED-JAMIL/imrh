package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "APP_USER")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUser extends BaseEntity  {

    @GenericGenerator(
        name = "appUserSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "APP_USER_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "appUserSequenceGenerator")
    @Column(name="APP_USER_ID", unique=true, nullable=false)
    private Long appUserId;

    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;

    @Column(name="LAST_NAME", nullable=false)
    private String lastName;

    @Column(name="EMAIL", unique=true, nullable=false)
    private String email;

    @Column(name="PASSWORD", nullable=false)
    private String password;

    @Column(name="LAST_LOGIN_AT")
    private Timestamp lastLoginAt;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Embedded
    private BaseMasterEntity baseMasterEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PROFILE_ID", nullable=false)
    private Profile profile;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "APP_SUB_USER",
        joinColumns = @JoinColumn(name = "PARENT_USER_ID", referencedColumnName = "APP_USER_ID"),
        inverseJoinColumns = @JoinColumn(name = "SUB_USER_ID", referencedColumnName = "APP_USER_ID"))
    private Set<AppUser> subUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITIES",
        joinColumns = @JoinColumn(name = "APP_USER_ID", referencedColumnName = "APP_USER_ID"),
        inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "AUTHORITY_ID"))
    private List<Authority> authorities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID", nullable=false)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public AppUser() {}

    public AppUser(String enabled, String firstName, String lastName, String email,
        String password, Timestamp lastLoginAt, String imageUrl, BaseMasterEntity baseMasterEntity,
        Profile profile, Set<AppUser> subUser, List<Authority> authorities,
        Company company, Address address) {
        super(enabled);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.lastLoginAt = lastLoginAt;
        this.imageUrl = imageUrl;
        this.baseMasterEntity = baseMasterEntity;
        this.profile = profile;
        this.subUser = subUser;
        this.authorities = authorities;
        this.company = company;
        this.address = address;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Timestamp lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BaseMasterEntity getBaseMasterEntity() {
        return baseMasterEntity;
    }

    public void setBaseMasterEntity(BaseMasterEntity baseMasterEntity) {
        this.baseMasterEntity = baseMasterEntity;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<AppUser> getSubUser() {
        return subUser;
    }

    public void setSubUser(Set<AppUser> subUser) {
        this.subUser = subUser;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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