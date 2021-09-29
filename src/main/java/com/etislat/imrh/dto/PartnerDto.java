package com.etislat.imrh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerDto {

    private Long partnerId;
    private String partnerName;
    private Enable enable;
    private Integer preferenceOrder;
    private Integer forexMarginShare;
    private Integer partnerShare;
    private String transferSpeed;
    private String partnerCategory;
    private String partnerTxtIdLabel;


    public PartnerDto() {}

    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Enable getEnable() {
        return enable;
    }
    public void setEnable(Enable enable) {
        this.enable = enable;
    }

    public Integer getPreferenceOrder() {
        return preferenceOrder;
    }
    public void setPreferenceOrder(Integer preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }

    public Integer getForexMarginShare() {
        return forexMarginShare;
    }
    public void setForexMarginShare(Integer forexMarginShare) {
        this.forexMarginShare = forexMarginShare;
    }

    public Integer getPartnerShare() {
        return partnerShare;
    }
    public void setPartnerShare(Integer partnerShare) {
        this.partnerShare = partnerShare;
    }

    public String getTransferSpeed() {
        return transferSpeed;
    }
    public void setTransferSpeed(String transferSpeed) {
        this.transferSpeed = transferSpeed;
    }

    public String getPartnerCategory() {
        return partnerCategory;
    }
    public void setPartnerCategory(String partnerCategory) {
        this.partnerCategory = partnerCategory;
    }

    public String getPartnerTxtIdLabel() {
        return partnerTxtIdLabel;
    }
    public void setPartnerTxtIdLabel(String partnerTxtIdLabel) {
        this.partnerTxtIdLabel = partnerTxtIdLabel;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
