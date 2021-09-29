package com.etislat.imrh.repository;

import com.etislat.imrh.entity.PartnerCountryProduct;
import com.etislat.imrh.entity.PartnerCountryProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerCountryProductRepository extends JpaRepository<PartnerCountryProduct, PartnerCountryProductId> {
}
