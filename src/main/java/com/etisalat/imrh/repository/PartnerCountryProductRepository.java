package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCountryProduct;
import com.etisalat.imrh.entity.PartnerCountryProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface PartnerCountryProductRepository extends JpaRepository<PartnerCountryProduct, PartnerCountryProductId> {
}
