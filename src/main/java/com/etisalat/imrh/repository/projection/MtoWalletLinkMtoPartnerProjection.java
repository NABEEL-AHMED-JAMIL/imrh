package com.etisalat.imrh.repository.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface MtoWalletLinkMtoPartnerProjection {

    public Long getPartnerId();

    public String getPartnerName();

    public String getCountryCode();

    public String getCountryName();

    public String getCountryEnabled();

    public Long getWalletId();

    public String getWalletName();

    public String getWalletEnabled();

}