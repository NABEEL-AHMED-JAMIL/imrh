package com.barco.imrh.repository;

import com.barco.imrh.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {

    public Optional<City> findByCityName(String cityName);

    @Modifying
    @Query(value = "UPDATE CITY SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ", nativeQuery = true)
    public int setAllCityStatusByCountryCode(String enabled, String countryCode);

}