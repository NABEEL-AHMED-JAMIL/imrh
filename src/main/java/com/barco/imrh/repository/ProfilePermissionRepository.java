package com.barco.imrh.repository;

import com.barco.imrh.entity.ProfilePermission;
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
