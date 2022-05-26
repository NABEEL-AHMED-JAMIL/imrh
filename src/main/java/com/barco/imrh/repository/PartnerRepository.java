package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.MtoBankLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.MtoCityLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.MtoWalletLinkMtoPartnerProjection;
import com.barco.imrh.repository.projection.PartnerProjection;
import com.barco.imrh.entity.Partner;
import com.barco.imrh.util.ConstantUtils.PartnerRepositoryConst;
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
    @Query(value = PartnerRepositoryConst.ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER, nativeQuery = true)
    public void attachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    @Modifying
    @Query(value = PartnerRepositoryConst.SET_ALL_PARTNER_STATUS, nativeQuery = true)
    public int setAllPartnerStatus(String enabled);

    @Query(value = PartnerRepositoryConst.FIND_ALL_PARTNER, nativeQuery = true)
    public List<PartnerProjection> findAllPartner();

    @Query(value = PartnerRepositoryConst.IS_ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER, nativeQuery = true)
    public boolean isAttachMtoCountryWithMtoPartner(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_COUNTRY_BY_PARTNER_ID, nativeQuery = true)
    public void deletePartnerCountryByPartnerId(Long partnerId);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_COUNTRY_BY_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerCountryByCountryCode(String countryCode);

    /**
     * Note :- this query help to delete all link country from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_COUNTRY_BY_PARTNER_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerCountryByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link city from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_CITY_BY_PARTNER_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerCityByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link bank from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_BANK_BY_PARTNER_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerBankByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to delete all link wallet from the partner country table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_WALLET_BY_PARTNER_ID_AND_COUNTRY_CODE, nativeQuery = true)
    public void deletePartnerWalletByPartnerIdAndCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto city by base on partner id and  country code
     * */
    @Query(value = PartnerRepositoryConst.FIND_MOT_CITY_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, nativeQuery = true)
    public List<MtoCityLinkMtoPartnerProjection> findMtoCityByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto wallet by base on partner id and  country code
     * */
    @Query(value = PartnerRepositoryConst.FIND_MTO_WALLET_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, nativeQuery = true)
    public List<MtoWalletLinkMtoPartnerProjection> findMtoWalletByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    /**
     * Note :- this query help to fetch the data for mto bank by base on partner id and  country code
     * */
    @Query(value = PartnerRepositoryConst.FIND_MTO_BANK_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE, nativeQuery = true)
    public List<MtoBankLinkMtoPartnerProjection> findMtoBankByMtoPartnerIdAndMtoCountryCode(Long partnerId, String countryCode);

    @Modifying
    @Query(value = PartnerRepositoryConst.ATTACH_MTO_CITY_WITH_PARTNER, nativeQuery = true)
    public void attachMtoCityWithMtoPartner(Long partnerId, Long cityId);

    @Query(value = PartnerRepositoryConst.IS_ATTACH_MTO_CITY_WITH_MTO_PARTNER, nativeQuery = true)
    public boolean isAttachMtoCityWithMtoPartner(Long partnerId, Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_CITY_BY_CITY_ID, nativeQuery = true)
    public void deletePartnerCityByCityId(Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_CITY_BY_PARTNER_ID_AND_CITY_ID, nativeQuery = true)
    public void deletePartnerCityByPartnerIdAndCityId(Long partnerId, Long cityId);

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_CITY_BY_PARTNER_ID, nativeQuery = true)
    public void deletePartnerCityByPartnerId(Long partnerId);

    @Modifying
    @Query(value = PartnerRepositoryConst.ATTACH_MTO_WALLET_WITH_MTO_PARTNER, nativeQuery = true)
    void attachMtoWalletWithMtoPartner(Long partnerId, Long walletId);

    @Query(value = PartnerRepositoryConst.IS_ATTACH_MTO_WALLET_WITH_MTO_PARTNER, nativeQuery = true)
    public boolean isAttachMtoWalletWithMtoPartner(Long partnerId, Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_WALLET_BY_WALLET_ID, nativeQuery = true)
    public void deletePartnerWalletByWalletId(Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_WALLET_BY_PARTNER_ID_AND_WALLET_ID, nativeQuery = true)
    public void deletePartnerWalletByPartnerIdAndWalletId(Long partnerId, Long walletId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_WALLET_BY_PARTNER_ID, nativeQuery = true)
    public void deletePartnerWalletByPartnerId(Long partnerId);

    @Modifying
    @Query(value = PartnerRepositoryConst.ATTACH_MTO_BANK_WITH_MTO_PARTNER, nativeQuery = true)
    void attachMtoBankWithMtoPartner(Long partnerId, Long bankId);

    @Query(value = PartnerRepositoryConst.IS_ATTACH_MTO_BANK_WITH_MTO_PARTNER, nativeQuery = true)
    public boolean isAttachMtoBankWithMtoPartner(Long partnerId, Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_BANK_BY_BANK_ID, nativeQuery = true)
    public void deletePartnerBankByBankId(Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_BANK_BY_PARTNER_ID_AND_BANK_ID, nativeQuery = true)
    public void deletePartnerBankByPartnerIdAndBankId(Long partnerId, Long bankId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = PartnerRepositoryConst.DELETE_PARTNER_BANK_BY_PARTNER_ID, nativeQuery = true)
    public void deletePartnerBankByPartnerId(Long partnerId);

}