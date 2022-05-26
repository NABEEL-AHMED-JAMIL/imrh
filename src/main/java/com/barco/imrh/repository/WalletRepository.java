package com.barco.imrh.repository;

import com.barco.imrh.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.barco.imrh.util.ConstantUtils.WalletRepositoryConst;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Optional<Wallet> findByWalletName(String walletName);

    @Modifying
    @Query(value = WalletRepositoryConst.SET_ALL_WALLET_STATUS_BY_COUNTRY_CODE, nativeQuery = true)
    public int setAllWalletStatusByCountryCode(String enabled, String countryCode);

}