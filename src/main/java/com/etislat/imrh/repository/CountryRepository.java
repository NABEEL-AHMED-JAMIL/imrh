package com.etislat.imrh.repository;

import com.etislat.imrh.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
