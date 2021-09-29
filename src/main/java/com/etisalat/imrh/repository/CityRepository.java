package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
