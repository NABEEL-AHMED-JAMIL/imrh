package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.ProfilePermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface ProfilePermissionRepository extends CrudRepository<ProfilePermission, Long> {
}
