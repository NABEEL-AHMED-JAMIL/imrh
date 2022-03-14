package com.barco.imrh.repository;

import com.barco.imrh.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface BankRepository extends JpaRepository<Bank, Long> {

    public Optional<Bank> findByBankName(String bankName);

    @Modifying
    @Query(value = "UPDATE BANK SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ", nativeQuery = true)
    public int setAllBankStatusByCountryCode(String enabled, String countryCode);

}