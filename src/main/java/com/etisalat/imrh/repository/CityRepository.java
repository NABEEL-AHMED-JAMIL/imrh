package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByCityName(String cityName);

    @Modifying
    @Query(value = "UPDATE CITY SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ", nativeQuery = true)
    public int setAllCityStatusByCountryCode(String enabled, String countryCode);
}
