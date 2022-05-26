package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

/**
 * @author Nabeel Ahmed
 * this class help to handle the auth process on api side
 */
@Entity
@Table(name = "AUTHORITY")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authority extends BaseEntity {

    @GenericGenerator(
        name = "authoritySequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "AUTHORITY_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "authoritySequenceGenerator")
    @Column(name="AUTHORITY_ID", unique=true, nullable=false)
    private Long authorityId;

    @Column(name = "ROLE", nullable = false,
        unique = true, length = 50)
    private String role;

    public Authority() {
    }

    public Authority(String enabled, Long authorityId, String role) {
        super(enabled);
        this.authorityId = authorityId;
        this.role = role;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
