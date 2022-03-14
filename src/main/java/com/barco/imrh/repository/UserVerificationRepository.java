package com.barco.imrh.repository;

import com.barco.imrh.entity.UserVerification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface UserVerificationRepository extends CrudRepository<UserVerification, Long> {
}
