package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.PartnerCustomerProjection;
import com.barco.imrh.entity.PartnerCustomer;
import com.barco.imrh.util.ConstantUtils.PartnerCustomerRepositoryConst;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface PartnerCustomerRepository extends CrudRepository<PartnerCustomer, Long> {

    @Modifying
    @Query(value = PartnerCustomerRepositoryConst.UPDATE_PARTNER_CUSTOMER_MSISDN, nativeQuery = true)
    public int updatePartnerCustomerMsisdn(Long partnerId, Long customerId);

    @Modifying
    @Query(value = PartnerCustomerRepositoryConst.DELETE_PARTNER_COUNTRY_BY_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerCountryByCountryCode(Long customerId);

    @Query(value = PartnerCustomerRepositoryConst.FETCH_ALL_CUSTOMER_DETAIL, nativeQuery = true)
    public List<PartnerCustomerProjection> fetchAllCustomerDetail(String customerNumber);

    @Query(value = PartnerCustomerRepositoryConst.FETCH_ALL_CUSTOMER_DETAIL_WITH_PAGE,
        countQuery = PartnerCustomerRepositoryConst.FETCH_ALL_CUSTOMER_DETAIL_WITH_PAGE_COUNT,
        nativeQuery = true)
    public Page<PartnerCustomerProjection> fetchAllCustomerDetailWithPage(Pageable pageable);

    @Query(value = PartnerCustomerRepositoryConst.FETCH_ALL_CUSTOMER_DETAIL_V1, nativeQuery = true)
    public List<PartnerCustomerProjection> fetchAllCustomerDetail();

    @Modifying
    @Query(value = PartnerCustomerRepositoryConst.TRUNCATE_PARTNER_CUSTOMER, nativeQuery = true)
    public void truncatePartnerCustomer();

}