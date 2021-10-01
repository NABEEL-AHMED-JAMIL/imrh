package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    public Optional<Bank> findByBankName(String bankName);

    @Modifying
    @Query(value = "UPDATE BANK SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ", nativeQuery = true)
    public int setAllBankStatusByCountryCode(String enabled, String countryCode);

}
