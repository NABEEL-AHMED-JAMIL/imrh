package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.PartnerCountryProduct;
import com.etisalat.imrh.entity.PartnerCountryProductId;
import com.etisalat.imrh.repository.projection.MtoPartnerCountryProductProjection;
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
public interface PartnerCountryProductRepository extends JpaRepository<PartnerCountryProduct, PartnerCountryProductId> {

    public void deleteByProductId(Long productId);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM partner_country_product WHERE\n" +
            "partner_id = ?1 and product_id = ?2 and country_code = ?3", nativeQuery = true)
    public boolean isAttachMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto partner country product on partner id and  country code
     * */
    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url as partnerImageUrl\n" +
        "country.country_code AS countryCode, country.country_name AS countryName, country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled,\n" +
        "product.product_id, product.product_name, product.product_image_url as productImageUrl, product.enabled from partner_country_product\n" +
        "INNER JOIN country ON country.country_code = partner_country_product.country_code\n" +
        "INNER JOIN partner ON partner.partner_id = partner_country_product.partner_id\n" +
        "INNER JOIN product ON product.product_id = partner_country_product.product_id\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2", nativeQuery = true)
    public List<MtoPartnerCountryProductProjection> findProductByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link partner product country
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country_product WHERE partner_id = ?1 AND product_id = ?2 AND country_code = ?3", nativeQuery = true)
    public void deleteMtoPartnerCountryProduct(Long partnerId, Long productId, String countryCode);

}