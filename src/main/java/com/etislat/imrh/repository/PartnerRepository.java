package com.etislat.imrh.repository;

import com.etislat.imrh.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
