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
    @Query(value = "UPDATE Partner SET ENABLED = ?1", nativeQuery = true)
    public int setAllPartnerStatus(String enabled);

    @Query(value = "SELECT partner_id as partnerId, partner_name as partnerName, enabled FROM partner", nativeQuery = true)
    public List<PartnerProjection> findAllPartner();

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE country_code = ?1", nativeQuery = true)
    public void deletePartnerCountryByCountryCode(Long countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerCountryByPartnerId(Long partnerId);

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
    @Query(value = "DELETE FROM partner_city WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerCityByPartnerId(Long partnerId);

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
    @Query(value = "DELETE FROM partner_wallet WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerWalletByPartnerId(Long partnerId);

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
    @Query(value = "DELETE FROM partner_bank WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerBankByPartnerId(Long partnerId);
}

