package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface PartnerCustomerRepository extends JpaRepository<PartnerCustomer, Long> {
}
