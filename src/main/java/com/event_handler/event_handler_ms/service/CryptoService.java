package com.event_handler.event_handler_ms.service;

import com.event_handler.event_handler_ms.model.CryptoPriceResponse;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CryptoService {


    private final Map<String, CryptoPriceResponse> latestPrices = new ConcurrentHashMap<>();
    private final Map<String, Double> lastPrices = new ConcurrentHashMap<>();

    public void updateCryptoPrices(CryptoPriceResponse priceResponse) {
        if (priceResponse.getPrice() != null) {
            lastPrices.put(priceResponse.getSymbol(), getCurrentPrice(priceResponse.getSymbol()));
            latestPrices.put(priceResponse.getSymbol(), priceResponse);
        }
    }

    public Collection<CryptoPriceResponse> getLatestCryptoPrices() {
        return latestPrices.values();
    }


    public double getCurrentPrice(String symbol) {
        return latestPrices.containsKey(symbol)
                ? Double.parseDouble(latestPrices.get(symbol).getPrice())
                : 0.0;
    }

    public Map<String, Double> getLastPriceMap() {
        return lastPrices;
    }


}
