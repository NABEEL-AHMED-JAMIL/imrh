package com.barco.imrh.repository.projection;

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

    public String getPartnerImageUrl();

    public String getCountryCode();

    public String getCountryName();

    public String getCountryImageUrl();

    public String getCountryEnabled();

    public Long getWalletId();

    public String getWalletName();

    public String getWalletImageUrl();

    public String getWalletEnabled();

}