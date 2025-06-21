package com.event_handler.event_handler_ms.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class KafkaPublisher implements Publish {


    private static final Logger log = LoggerFactory.getLogger(KafkaPublisher.class);


    @Autowired
    private KafkaTemplate<String, Object> kafkaWikiTemplate;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void processEvent(String destination,Map<String, Object> eventMessage) {
        try {
            kafkaWikiTemplate.send(destination, eventMessage);
            log.info("message for event {} , published successfully",eventMessage.get("eventType"));
        } catch (Exception e) {

        }


    }
}
