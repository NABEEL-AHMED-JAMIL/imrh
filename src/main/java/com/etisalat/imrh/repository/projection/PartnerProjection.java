package com.etisalat.imrh.repository.projection;

/**
 * @author Nabeel Ahmed
 */
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
