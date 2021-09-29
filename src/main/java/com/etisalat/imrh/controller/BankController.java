package com.etisalat.imrh.controller;

import com.etisalat.imrh.repository.BankRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imrh/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {

    public Logger logger = LogManager.getLogger(BankController.class);

    @Autowired
    private BankRepository bankRepository;

    public void createBank() {}
    public void updateBank() {}
    public void deleteBank() {}
    public void disableBank() {}
    public void fetchBank() {}

}
