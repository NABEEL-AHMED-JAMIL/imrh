package com.etisalat.imrh.controller;

import com.etisalat.imrh.repository.CountryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imrh/country")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    public Logger logger = LogManager.getLogger(CountryController.class);

    @Autowired
    private CountryRepository countryRepository;

    public void createCountry() {}
    public void updateCountry() {}
    public void deleteCountry() {}
    public void disableCountry() {}
    public void fetchCountry() {}
}
