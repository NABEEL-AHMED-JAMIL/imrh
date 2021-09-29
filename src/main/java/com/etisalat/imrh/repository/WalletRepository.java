package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nabeel Ahmed
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
