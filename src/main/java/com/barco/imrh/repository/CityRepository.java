package com.barco.imrh.repository;

import com.barco.imrh.entity.City;
import com.barco.imrh.util.ConstantUtils.CityRepositoryConst;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Long> {

    public Optional<City> findByCityName(String cityName);
    @Modifying
    @Query(value = CityRepositoryConst.SET_ALL_CITY_STATUS_BY_COUNTRY_CODE, nativeQuery = true)
    public int setAllCityStatusByCountryCode(String enabled, String countryCode);

}