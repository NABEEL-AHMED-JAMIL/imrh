package com.etisalat.imrh.controller;

import com.etisalat.imrh.repository.WalletRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imrh/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {

    public Logger logger = LogManager.getLogger(WalletController.class);

    @Autowired
    private WalletRepository walletRepository;

    public void createWallet() {}
    public void updateWallet() {}
    public void deleteWallet() {}
    public void disableWallet() {}
    public void fetchWallet() {}
}
