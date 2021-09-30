package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.projection.CountryProjection;
import com.etisalat.imrh.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Query(value = "SELECT COUNTRY_CODE as countryCode, COUNTRY_NAME as countryName, " +
        "COUNTRY_LEGACY_CODE as countryLegacyCode, ENABLED as enabled from COUNTRY", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<CountryProjection> findAllCountry();

    @Modifying
    @Query("update Country country set country.enabled = ?1")
    public int setAllCountryStatus(String enabled);
}
