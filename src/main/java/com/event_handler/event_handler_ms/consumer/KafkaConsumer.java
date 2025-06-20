package com.event_handler.event_handler_ms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumer {


    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "learn-topic",groupId = "myGroup")
    public void consumerEvents(Map<String, Object> eventMessage) {
        logger.info("Message received-->{}", eventMessage);
    }

    @KafkaListener(topics = "wiki-topic",groupId = "wiki-group")
    public void consumeWikiEvents(String wikiEvents) {
        logger.info("WikiEvents-->{}",wikiEvents);
    }



}
