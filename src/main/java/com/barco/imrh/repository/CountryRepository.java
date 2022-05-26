package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.CountryProjection;
import com.barco.imrh.entity.Country;
import com.barco.imrh.util.ConstantUtils.CountryRepositoryConst;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface CountryRepository extends CrudRepository<Country, String> {

    @Query(value = CountryRepositoryConst.FIND_ALL_COUNTRY, nativeQuery = true)
    public List<CountryProjection> findAllCountry();

    @Modifying
    @Query(value = CountryRepositoryConst.SET_ALL_COUNTRY_STATUS)
    public int setAllCountryStatus(String enabled);

}