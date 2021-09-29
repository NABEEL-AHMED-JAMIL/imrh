package com.etislat.imrh.repository;

import com.etislat.imrh.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
