package com.etisalat.imrh.controller;

import com.etisalat.imrh.service.AppNotificationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nabeel Ahmed
 */
@RestController
@RequestMapping("/imrh/appNotification")
@CrossOrigin(origins = "http://localhost:4200")
public class AppNotificationController {

    public Logger logger = LogManager.getLogger(AppNotificationController.class);

    @Autowired
    private AppNotificationService appNotificationService;

}