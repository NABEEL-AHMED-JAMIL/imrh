package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCustomer;
import com.etisalat.imrh.repository.projection.PartnerCustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface PartnerCustomerRepository extends JpaRepository<PartnerCustomer, Long> {

    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner_customer.customer_number AS partnerCustomer\n" +
        "FROM partner_customer\n" +
        "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id", nativeQuery = true)
    public List<PartnerCustomerProjection> fetchAllCustomerDetail();
}
