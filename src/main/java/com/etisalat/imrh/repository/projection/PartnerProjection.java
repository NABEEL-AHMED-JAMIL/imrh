package com.etisalat.imrh.repository.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface PartnerProjection {

    public Long getPartnerId();

    public String getPartnerName();

    public String getEnabled();

    public Integer getPreferenceOrder();

    public Double getForexMarginShare();

    public Double getPartnerShare();

    public String getTransferSpeed();

    public String getPartnerCategory();

    public String getPartnerTxtIdLabel();

}
