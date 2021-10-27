package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.AppUserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface AppUserNotificationRepository extends JpaRepository<AppUserNotification, Long> {
}
