package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Optional<Wallet> findByWalletName(String walletName);

    @Modifying
    @Query(value = "UPDATE WALLET SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ", nativeQuery = true)
    public int setAllWalletStatusByCountryCode(String enabled, String countryCode);

}
