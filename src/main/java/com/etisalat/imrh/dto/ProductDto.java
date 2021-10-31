package com.etisalat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long productId;
    private String productName;
    private String productImageUrl;
    private Enable enabled;

    public ProductDto() {}

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Enable getEnabled() {
        return enabled;
    }
    public void setEnabled(Enable enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}