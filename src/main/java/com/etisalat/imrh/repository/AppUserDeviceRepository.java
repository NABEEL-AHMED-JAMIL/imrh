package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.AppUserDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface AppUserDeviceRepository extends CrudRepository<AppUserDevice, Long> {
}
