package com.barco.imrh.controller;

import com.barco.imrh.service.AppUserService;
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
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/appUser")
public class AppUserController {

    public Logger logger = LogManager.getLogger(AppUserController.class);

    @Autowired
    private AppUserService appUserService;

}