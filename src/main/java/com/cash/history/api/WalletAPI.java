package com.cash.history.api;

import com.cash.history.model.Wallet;
import com.cash.history.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletAPI {
    @Autowired
    private WalletService walletService;

    @GetMapping("/wallet")
    Wallet getWallet() {
        return walletService.findCurrentMonthWallet();
    }
}
