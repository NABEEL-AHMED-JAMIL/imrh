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
@Table(name = "PROFILE_PERMISSION")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfilePermission extends BaseEntity  {

    @GenericGenerator(
        name = "profilePermissionSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PROFILE_PERMISSION_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "profilePermissionSequenceGenerator")
    @Column(name="PROFILE_PERMISSION_ID", unique=true, nullable=false)
    private Long profilePermissionId;

    @ManyToOne
    @JoinColumn(name="PROFILE_ID", nullable=false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PERMISSION_ID", nullable=false)
    private Permission permission;

    public ProfilePermission() { }

    public ProfilePermission(String enabled, Profile profile, Permission permission) {
        super(enabled);
        this.profile = profile;
        this.permission = permission;
    }

    public Long getProfilePermissionId() {
        return profilePermissionId;
    }
    public void setProfilePermissionId(Long profilePermissionId) {
        this.profilePermissionId = profilePermissionId;
    }

    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Permission getPermission() {
        return permission;
    }
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
