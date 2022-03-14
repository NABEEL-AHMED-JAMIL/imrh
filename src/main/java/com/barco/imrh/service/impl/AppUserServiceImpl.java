package com.barco.imrh.service.impl;

import com.barco.imrh.service.AppUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    public Logger logger = LogManager.getLogger(AppUserServiceImpl.class);
}
