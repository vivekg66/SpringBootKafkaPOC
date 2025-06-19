package com.event_handler.event_handler_ms.service;

import com.event_handler.event_handler_ms.config.EventConfig;
import com.event_handler.event_handler_ms.model.EventMapping;
import com.event_handler.event_handler_ms.publisher.KafkaPublisher;
import com.event_handler.event_handler_ms.publisher.Publish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class EventServiceImpl implements EventService {



    @Autowired
    private EventConfig eventConfig;

    @Autowired
    private KafkaPublisher publisher;


    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);


    @Override
    public void processEvent(String service ,String eventType,
                             Map<String, Object> eventMessage) {


        List<EventMapping> eventServices = eventConfig.getServices();

        if(ObjectUtils.isEmpty(eventServices)) {
            System.out.println("eventService is empty");
        }

        Optional<EventMapping> serviceData = eventServices.stream()
                .filter(s -> s.getName().equalsIgnoreCase(service))
                .findFirst();
        log.info("eventConfig {}",eventServices);
        log.info("servicedata{}", serviceData.get());
        publisher.processEvent("learn-topic",eventMessage);



    }
}
