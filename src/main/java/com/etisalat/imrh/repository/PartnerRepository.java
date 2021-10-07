package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Partner;
import com.etisalat.imrh.repository.projection.PartnerProjection;
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
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Modifying
    @Query(value = "INSERT INTO partner_country(partner_id, country_code) VALUES (?1, ?2)", nativeQuery = true)
    void attachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    @Modifying
    @Query(value = "UPDATE Partner SET ENABLED = ?1", nativeQuery = true)
    public int setAllPartnerStatus(String enabled);

    @Query(value = "SELECT partner_id as partnerId, partner_name as partnerName, enabled FROM partner", nativeQuery = true)
    public List<PartnerProjection> findAllPartner();

    @Query(value = "SELECT CASE WHEN COUNT(partner_country) > 0 THEN true ELSE false END FROM partner_country WHERE " +
            "partner_id = ?1 and country_code = ?2", nativeQuery = true)
    public boolean isAttachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE country_code = ?1", nativeQuery = true)
    public void deletePartnerCountryByCountryCode(String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE partner_id = ?1 AND country_code = ?2", nativeQuery = true)
    public void deletePartnerCountryByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerCountryByPartnerId(Long partnerId);

    @Modifying
    @Query(value = "INSERT INTO partner_city(partner_id, city_id) VALUES (?1, ?2)", nativeQuery = true)
    void attachMtoCityWithMtoPartner(Long partnerId, Long cityId);

    @Query(value = "SELECT CASE WHEN COUNT(partner_city) > 0 THEN true ELSE false END FROM partner_city WHERE " +
            "partner_id = ?1 and city_id = ?2", nativeQuery = true)
    public boolean isAttachMtoCityWithMtoPartner(Long partnerId, Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_city WHERE city_id = ?1", nativeQuery = true)
    public void deletePartnerCityByCityId(Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_city WHERE partner_id = ?1 AND city_id = ?2", nativeQuery = true)
    public void deletePartnerCityByPartnerIdAndCityId(Long partnerId, Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_city WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerCityByPartnerId(Long partnerId);

    @Modifying
    @Query(value = "INSERT INTO partner_wallet(partner_id, wallet_id) VALUES (?1, ?2)", nativeQuery = true)
    void attachMtoWalletWithMtoPartner(Long partnerId, Long walletId);

    @Query(value = "SELECT CASE WHEN COUNT(partner_wallet) > 0 THEN true ELSE false END FROM partner_wallet WHERE " +
            "partner_id = ?1 and wallet_id = ?2", nativeQuery = true)
    public boolean isAttachMtoWalletWithMtoPartner(Long partnerId, Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_wallet WHERE wallet_id = ?1", nativeQuery = true)
    public void deletePartnerWalletByWalletId(Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_wallet WHERE partner_id = ?1 AND wallet_id = ?2", nativeQuery = true)
    public void deletePartnerWalletByPartnerIdAndWalletId(Long partnerId, Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_wallet WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerWalletByPartnerId(Long partnerId);

    @Modifying
    @Query(value = "INSERT INTO partner_bank(partner_id, bank_id) VALUES (?1, ?2)", nativeQuery = true)
    void attachMtoBankWithMtoPartner(Long partnerId, Long bankId);

    @Query(value = "SELECT CASE WHEN COUNT(partner_bank) > 0 THEN true ELSE false END FROM partner_bank WHERE " +
        "partner_id = ?1 and bank_id = ?2", nativeQuery = true)
    public boolean isAttachMtoBankWithMtoPartner(Long partnerId, Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_bank WHERE bank_id = ?1", nativeQuery = true)
    public void deletePartnerBankByBankId(Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_bank WHERE partner_id = ?1 AND bank_id = ?2", nativeQuery = true)
    public void deletePartnerBankByPartnerIdAndBankId(Long partnerId, Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_bank WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerBankByPartnerId(Long partnerId);

}