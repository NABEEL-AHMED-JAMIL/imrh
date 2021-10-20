package com.etisalat.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Nabeel Ahmed
 */
@Embeddable
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseMasterEntity {

    @Column(name = "CREATED_AT",
    columnDefinition = "timestamp default CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdAt;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "MODIFIED_AT")
    private Timestamp modifiedAt;

    public BaseMasterEntity() {}

    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
