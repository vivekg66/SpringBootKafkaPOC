package com.event_handler.event_handler_ms.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "learn-topic",groupId = "myGroup")
    public void consumerEvents(Map<String, Object> eventMessage) {
        System.out.println("Message received-->"+ eventMessage);
    }


}
