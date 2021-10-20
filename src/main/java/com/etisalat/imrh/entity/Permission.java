package com.etisalat.imrh.entity;

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
@Table(name = "PERMISSION")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission extends BaseEntity  {

    @GenericGenerator(
        name = "permissionSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PERMISSION_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "permissionSequenceGenerator")
    @Column(name="PERMISSION_ID", unique=true, nullable=false)
    private Long permissionId;

    @Column(name="PERMISSION_NAME", nullable=false)
    private String permissionName;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProfilePermission> profilePermissions = new ArrayList<>();

    public Permission() {}

    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<ProfilePermission> getProfilePermissions() {
        return profilePermissions;
    }
    public void setProfilePermissions(List<ProfilePermission> profilePermissions) {
        this.profilePermissions = profilePermissions;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}