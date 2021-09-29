package com.etisalat.imrh.controller;

import com.etisalat.imrh.repository.PartnerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imrh/partner")
@CrossOrigin(origins = "http://localhost:4200")
public class PartnerController {

    public Logger logger = LogManager.getLogger(PartnerController.class);

    @Autowired
    private PartnerRepository partnerRepository;

    public void createPartner() {}
    public void updatePartner() {}
    public void deletePartner() {}
    public void disablePartner() {}
    public void fetchPartner() {}
}
