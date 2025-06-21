package com.event_handler.event_handler_ms.publisher;

import com.event_handler.event_handler_ms.client.BinanceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaCryptoPricePublisher {
    private final Logger logger = LoggerFactory.getLogger(KafkaPublisher.class);



    @Value("${binance.symbols}")
    private String symbols;

    @Value("${topic.binance}")
    private String cryptoTopic;

    private KafkaTemplate<String,Object> kafkaCryptoTemplate;

    private BinanceClient binanceClient;

    public KafkaCryptoPricePublisher(KafkaTemplate<String, Object> kafkaCryptoTemplate, BinanceClient binanceClient) {
        this.kafkaCryptoTemplate = kafkaCryptoTemplate;
        this.binanceClient = binanceClient;
    }

    @Scheduled(fixedRate = 10000)
    public void fetchAndPublishPrices() {
        logger.info("----Scheduling after every 10 seconds-----");
        binanceClient.fetchCryptoPrices().subscribe(prices-> {
            List<String> interested = List.of(symbols.split(","));
            prices.stream().filter(p->interested.contains(p.getSymbol())).forEach(p-> {
                kafkaCryptoTemplate.send(cryptoTopic,p);
                logger.info("----PriceData Published----");
            });

        });

    }

}



