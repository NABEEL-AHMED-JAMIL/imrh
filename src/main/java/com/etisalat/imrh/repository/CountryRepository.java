package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Country;
import com.etisalat.imrh.repository.projection.CountryProjection;
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

    @Query(value = "SELECT COUNTRY_CODE AS countryCode, COUNTRY_NAME AS countryName, " +
        "COUNTRY_LEGACY_CODE AS countryLegacyCode, ENABLED AS enabled FROM COUNTRY", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<CountryProjection> findAllCountry();

    @Modifying
    @Query("UPDATE Country country SET country.enabled = ?1")
    public int setAllCountryStatus(String enabled);

}