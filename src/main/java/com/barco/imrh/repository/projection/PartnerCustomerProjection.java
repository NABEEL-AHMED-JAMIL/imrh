package com.barco.imrh.repository.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface PartnerCustomerProjection {

    public Long getPartnerId();

    public String getPartnerName();

    public String getPartnerImageUrl();

    public Long getCustomerId();

    public String getPartnerCustomer();

}