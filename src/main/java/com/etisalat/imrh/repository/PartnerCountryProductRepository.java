package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCountryProduct;
import com.etisalat.imrh.entity.PartnerCountryProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface PartnerCountryProductRepository extends
    JpaRepository<PartnerCountryProduct, PartnerCountryProductId> {

    public void deleteByPartnerId(Long partnerId);

    public void deleteByCountryCode(String countryCode);

    public void deleteByProductId(Long productId);

}