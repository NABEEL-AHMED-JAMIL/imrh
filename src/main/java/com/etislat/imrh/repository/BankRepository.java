package com.etislat.imrh.repository;

import com.etislat.imrh.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
