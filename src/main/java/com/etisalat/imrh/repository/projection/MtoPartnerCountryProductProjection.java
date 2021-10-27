package com.etisalat.imrh.repository.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface MtoPartnerCountryProductProjection {

    public Long getPartnerId();

    public String getPartnerName();

    public String getPartnerImageUrl();

    public String getCountryCode();

    public String getCountryName();

    public String getCountryImageUrl();

    public String getCountryEnabled();

    public Long getProductId();

    public String getProductName();

    public String getProductImageUrl();

    public String getEnabled();

}