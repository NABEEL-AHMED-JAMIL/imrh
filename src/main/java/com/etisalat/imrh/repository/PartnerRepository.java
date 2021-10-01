package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    /**
     * Note :- this query help to delete all link city from the partner city table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_city WHERE city_id = ?1", nativeQuery = true)
    public void deletePartnerCityByCityId(Long cityId);

    /**
     * Note :- this query help to delete all link wallet from the partner wallet table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_wallet WHERE wallet_id = ?1", nativeQuery = true)
    public void deletePartnerWalletByWalletId(Long walletId);

    /**
     * Note :- this query help to delete all link bank from the partner bank table
     * */
    @Modifying
    @Query(value = "DELETE FROM partner_bank WHERE bank_id = ?1", nativeQuery = true)
    public void deletePartnerBankByBankId(Long bankId);
}
