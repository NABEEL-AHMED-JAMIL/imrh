package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Nabeel Ahmed
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {

    @Column(name = "ENABLED",
        columnDefinition = "CHAR(1)", nullable = false)
    private String enabled;

    public BaseEntity() {}

    public BaseEntity(String enabled) {
        this.enabled = enabled;
    }

    public String getEnabled() {
        return enabled;
    }
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}