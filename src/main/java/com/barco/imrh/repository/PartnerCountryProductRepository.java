package com.barco.imrh.repository;

import com.barco.imrh.entity.PartnerCountryProduct;
import com.barco.imrh.entity.PartnerCountryProductId;
import com.barco.imrh.util.ConstantUtils.PartnerCountryProductRepositoryConst;
import com.barco.imrh.repository.projection.MtoPartnerCountryProductProjection;
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
public interface PartnerCountryProductRepository extends
    CrudRepository<PartnerCountryProduct, PartnerCountryProductId> {

    public void deleteByProductId(Long productId);

    @Query(value = PartnerCountryProductRepositoryConst.IS_ATTACH_MTO_PARTNER_COUNTRY_PRODUCT, nativeQuery = true)
    public boolean isAttachMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto partner country product on partner id and  country code
     * */
    @Query(value = PartnerCountryProductRepositoryConst.FIND_PRODUCT_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, nativeQuery = true)
    public List<MtoPartnerCountryProductProjection> findProductByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link partner product country
     * */
    @Modifying
    @Query(value = PartnerCountryProductRepositoryConst.DELETE_MTO_PARTNER_COUNTRY_PRODUCT_BY_PARTNER_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deleteMtoPartnerCountryProductByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link partner product country
     * */
    @Modifying
    @Query(value = PartnerCountryProductRepositoryConst.DELETE_MTO_PARTNER_COUNTRY_PRODUCT_BY_PARTNER_ID_AND_PRODUCT_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deleteMtoPartnerCountryProductByPartnerIdAndProductIdAndCountryCode(Long partnerId, Long productId, String countryCode);
}