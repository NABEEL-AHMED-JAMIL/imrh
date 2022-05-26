package com.barco.imrh.repository;

import com.barco.imrh.entity.Bank;
import com.barco.imrh.util.ConstantUtils.BankRepositoryConst;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface BankRepository extends CrudRepository<Bank, Long> {

    public Optional<Bank> findByBankName(String bankName);
    @Modifying
    @Query(value = BankRepositoryConst.SET_ALL_BANK_STATUS_BY_COUNTRY_CODE, nativeQuery = true)
    public int setAllBankStatusByCountryCode(String enabled, String countryCode);

}