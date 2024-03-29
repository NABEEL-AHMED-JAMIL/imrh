package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "PROFILE")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile extends BaseEntity {

    @GenericGenerator(
        name = "profileSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PROFILE_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "profileSequenceGenerator")
    @Column(name="PROFILE_ID", unique=true, nullable=false)
    private Long profileId;

    @Column(name="PROFILE_NAME", nullable=false)
    private String profileName;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProfilePermission> profilePermissions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    public Profile() { }

    public Profile(String enabled, String profileName,
        List<ProfilePermission> profilePermissions, Company company) {
        super(enabled);
        this.profileName = profileName;
        this.profilePermissions = profilePermissions;
        this.company = company;
    }

    public Long getProfileId() {
        return profileId;
    }
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public List<ProfilePermission> getProfilePermissions() {
        return profilePermissions;
    }
    public void setProfilePermissions(List<ProfilePermission> profilePermissions) {
        this.profilePermissions = profilePermissions;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}