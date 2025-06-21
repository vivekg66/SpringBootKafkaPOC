package com.event_handler.event_handler_ms.client;

import com.event_handler.event_handler_ms.model.CryptoPriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BinanceClient {

    private static final Logger logger = LoggerFactory.getLogger(BinanceClient.class);
    @Value("${binance.api.url}")
    private String binanceApiUrl;

    private final WebClient webClient = WebClient.create();

    public Mono<List<CryptoPriceResponse>> fetchCryptoPrices() {
        logger.info("----Calling binanceApi---- ");
        return webClient.get()
                .uri(binanceApiUrl)
                .retrieve()
                .bodyToFlux(CryptoPriceResponse.class)
                //.doOnNext(p-> logger.info("Fetched:"+ p.getSymbol()+ " "+ p.getPrice()))
                .collectList();
    }


}
