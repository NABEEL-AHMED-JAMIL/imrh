package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCustomer;
import com.etisalat.imrh.repository.projection.PartnerCustomerProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = "UPDATE partner_customer SET PARTNER_ID = ?1 where CUSTOMER_ID = ?2", nativeQuery = true)
    public int updatePartnerCustomerMsisdn(Long partnerId, Long customerId);

    @Modifying
    @Query(value = "DELETE FROM partner_customer WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    public void deletePartnerCountryByCountryCode(Long customerId);

    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url AS partnerImageUrl," +
        "partner_customer.customer_id as customerId, partner_customer.customer_number AS partnerCustomer FROM partner_customer\n" +
        "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id\n" +
        "WHERE partner_customer.customer_number = ?1", nativeQuery = true)
    public List<PartnerCustomerProjection> fetchAllCustomerDetail(String customerNumber);

    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url AS partnerImageUrl," +
        "partner_customer.customer_id as customerId, partner_customer.customer_number AS partnerCustomer FROM partner_customer\n" +
        "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id ORDER BY partner_customer.customer_id ",
        countQuery = "SELECT COUNT(*) FROM partner_customer\n" +
            "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id",
        nativeQuery = true)
    public Page<PartnerCustomerProjection> fetchAllCustomerDetailWithPage(Pageable pageable);

    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner_customer.customer_number AS partnerCustomer\n" +
        "FROM partner_customer\n" +
        "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id", nativeQuery = true)
    public List<PartnerCustomerProjection> fetchAllCustomerDetail();

    @Modifying
    @Query(value = "TRUNCATE TABLE partner_customer", nativeQuery = true)
    public void truncatePartnerCustomer();

}