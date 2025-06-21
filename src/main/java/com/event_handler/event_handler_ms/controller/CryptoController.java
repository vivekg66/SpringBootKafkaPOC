package com.event_handler.event_handler_ms.controller;

import com.event_handler.event_handler_ms.model.CryptoPriceResponse;
import com.event_handler.event_handler_ms.service.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CryptoController {


    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }


    @GetMapping("/crypto/prices")
    public Collection<CryptoPriceResponse> getLatestPrices() {
        return cryptoService.getLatestCryptoPrices();
    }

}
