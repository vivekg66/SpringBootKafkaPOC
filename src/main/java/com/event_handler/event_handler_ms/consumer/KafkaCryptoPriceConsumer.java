package com.event_handler.event_handler_ms.consumer;

import com.event_handler.event_handler_ms.model.CryptoPriceResponse;
import com.event_handler.event_handler_ms.service.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaCryptoPriceConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaCryptoPriceConsumer.class);

    @Value("${topic.binance}")
    private String cryptoTopic;

    @Autowired
    private CryptoService cryptoService;

    @KafkaListener(topics = "binance-topic",groupId = "crypto-group")
    public void consumeWikiEvents(CryptoPriceResponse cryptoPrices) {
       cryptoService.updateCryptoPrices(cryptoPrices);
        logger.info("----binanceEvents-->{}",cryptoPrices);
    }
}
