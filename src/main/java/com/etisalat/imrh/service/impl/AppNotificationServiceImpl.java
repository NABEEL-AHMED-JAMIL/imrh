package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.service.AppNotificationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class AppNotificationServiceImpl implements AppNotificationService {

    public Logger logger = LogManager.getLogger(AppNotificationServiceImpl.class);
}
