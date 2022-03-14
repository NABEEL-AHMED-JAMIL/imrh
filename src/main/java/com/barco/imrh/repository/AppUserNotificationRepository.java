package com.barco.imrh.repository;

import com.barco.imrh.entity.AppUserNotification;
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
