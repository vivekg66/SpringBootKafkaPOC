package com.event_handler.event_handler_ms.controller;

import com.event_handler.event_handler_ms.service.CryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoDashboardController {

    private final CryptoService cryptoService;

    public CryptoDashboardController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto-dashboard")
    public String dashboard(Model model) {
        model.addAttribute("prices", cryptoService.getLatestCryptoPrices());
        model.addAttribute("lastPrices", cryptoService.getLastPriceMap());
        return "cryptoDashboard";
    }
}

