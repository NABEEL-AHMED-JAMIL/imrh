package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.MtoBankLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.MtoCityLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.MtoWalletLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.PartnerProjection;
import com.barco.imrh.entity.Partner;
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

    public List<Partner> findAllByOrderByPreferenceOrderAsc();

    @Modifying
    @Query(value = "INSERT INTO partner_country(partner_id, country_code) VALUES (?1, ?2)", nativeQuery = true)
    public void attachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    @Modifying
    @Query(value = "UPDATE Partner SET ENABLED = ?1", nativeQuery = true)
    public int setAllPartnerStatus(String enabled);

    @Query(value = "SELECT partner_id AS partnerId, partner_name AS partnerName, enabled FROM partner", nativeQuery = true)
    public List<PartnerProjection> findAllPartner();

    @Query(value = "SELECT CASE WHEN COUNT(partner_country) > 0 THEN true ELSE false END FROM partner_country WHERE\n" +
            "partner_id = ?1 and country_code = ?2", nativeQuery = true)
    public boolean isAttachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_country WHERE partner_id = ?1", nativeQuery = true)
    public void deletePartnerCountryByPartnerId(Long partnerId);

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
     * Note :- this query help to delete all link city from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_city\n" +
        "WHERE partner_city.partner_id = ?1 AND partner_city.city_id IN (\n" +
        "SELECT partner_city.city_id AS cityId FROM partner\n" +
        "INNER JOIN partner_city ON partner_city.partner_id = partner.partner_id\n" +
        "INNER JOIN city ON city.city_id = partner_city.city_id\n" +
        "INNER JOIN country ON country.country_code = city.country_code\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2)", nativeQuery = true)
    public void deletePartnerCityByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link bank from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_bank\n" +
            "WHERE partner_bank.partner_id = ?1 AND partner_bank.bank_id IN(\n" +
            "SELECT partner_bank.bank_id FROM partner\n" +
            "INNER JOIN partner_bank ON partner_bank.partner_id = partner.partner_id\n" +
            "INNER JOIN bank ON bank.bank_id = partner_bank.bank_id\n" +
            "INNER JOIN country ON country.country_code = bank.country_code\n" +
            "WHERE partner.partner_id = ?1 AND country.country_code = ?2)", nativeQuery = true)
    public void deletePartnerBankByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link wallet from the partner country table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_wallet\n" +
        "WHERE partner_wallet.partner_id = ?1 AND partner_wallet.wallet_id IN(\n" +
        "SELECT partner_wallet.wallet_id FROM partner\n" +
        "INNER JOIN partner_wallet ON partner_wallet.partner_id = partner.partner_id\n" +
        "INNER JOIN wallet ON wallet.wallet_id = partner_wallet.wallet_id\n" +
        "INNER JOIN country ON country.country_code = wallet.country_code\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2)", nativeQuery = true)
    public void deletePartnerWalletByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto city by base on partner id and  country code
     * */
    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url AS partnerImageUrl,\n" +
        "country.country_code AS countryCode, country.country_name AS countryName, country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled,\n" +
        "city.city_id AS cityId, city.city_name AS cityName, city.enabled AS cityEnabled FROM partner\n" +
        "INNER JOIN partner_city ON partner_city.partner_id = partner.partner_id\n" +
        "INNER JOIN city ON city.city_id = partner_city.city_id\n" +
        "INNER JOIN country ON country.country_code = city.country_code\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2", nativeQuery = true)
    public List<MtoCityLinkMtoPartnerProjection> findMtoCityByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto wallet by base on partner id and  country code
     * */
    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url AS partnerImageUrl,\n" +
        "country.country_code AS countryCode, country.country_name AS countryName, country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled,\n" +
        "wallet.wallet_id AS walletId, wallet.wallet_name AS walletName, wallet.wallet_image_url AS walletImageUrl, wallet.enabled AS walletEnabled FROM partner\n" +
        "INNER JOIN partner_wallet ON partner_wallet.partner_id = partner.partner_id\n" +
        "INNER JOIN wallet ON wallet.wallet_id = partner_wallet.wallet_id\n" +
        "INNER JOIN country ON country.country_code = wallet.country_code\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2", nativeQuery = true)
    public List<MtoWalletLinkMtoPartnerProjection> findMtoWalletByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto bank by base on partner id and  country code
     * */
    @Query(value = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, partner.partner_image_url AS partnerImageUrl,\n" +
        "country.country_code AS countryCode, country.country_name AS countryName, country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled,\n" +
        "bank.bank_id AS bankId, bank.bank_name AS bankName, bank.bank_image_url AS bankImageUrl, bank.enabled AS bankEnabled FROM partner\n" +
        "INNER JOIN partner_bank ON partner_bank.partner_id = partner.partner_id\n" +
        "INNER JOIN bank ON bank.bank_id = partner_bank.bank_id\n" +
        "INNER JOIN country ON country.country_code = bank.country_code\n" +
        "WHERE partner.partner_id = ?1 AND country.country_code = ?2", nativeQuery = true)
    public List<MtoBankLinkMtoPartnerProjection> findMtoBankByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    @Modifying
    @Query(value = "INSERT INTO partner_city(partner_id, city_id) VALUES (?1, ?2)", nativeQuery = true)
    public void attachMtoCityWithMtoPartner(Long partnerId, Long cityId);

    @Query(value = "SELECT CASE WHEN COUNT(partner_city) > 0 THEN true ELSE false END FROM partner_city WHERE\n" +
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

    @Query(value = "SELECT CASE WHEN COUNT(partner_wallet) > 0 THEN true ELSE false END FROM partner_wallet WHERE\n" +
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

    @Query(value = "SELECT CASE WHEN COUNT(partner_bank) > 0 THEN true ELSE false END FROM partner_bank WHERE\n" +
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