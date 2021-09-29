package com.etislat.imrh.controller;

import com.etislat.imrh.repository.CityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imrh/city")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    public Logger logger = LogManager.getLogger(CityController.class);

    @Autowired
    private CityRepository cityRepository;

    public void createCity() {}
    public void updateCity() {}
    public void deleteCity() {}
    public void disableCity() {}
    public void fetchCity() {}
}
