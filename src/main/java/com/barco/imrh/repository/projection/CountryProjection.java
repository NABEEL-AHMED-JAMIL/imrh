package com.barco.imrh.repository.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface CountryProjection {

    public String getCountryCode();

    public String getCountryName();

    public String getCountryImageUrl();

    public String getCountryLegacyCode();

    public String getEnabled();

}