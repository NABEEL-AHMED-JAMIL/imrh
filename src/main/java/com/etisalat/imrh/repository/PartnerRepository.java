package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
