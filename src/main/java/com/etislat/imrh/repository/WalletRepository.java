package com.etislat.imrh.repository;

import com.etislat.imrh.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nabeel Ahmed
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
