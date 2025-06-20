package com.event_handler.event_handler_ms.publisher;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class WikiEventsProducer {

    private static final Logger logger = LoggerFactory.getLogger(WikiEventsProducer.class);

    @Value("${wikimedia.url}")
    private String wikiMediaUrl;

    @Value("${topic.wiki}")
    private String wikiTopic;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void sendWikiData() throws InterruptedException {
        EventHandler eventHandler = new WikiEventHandler(kafkaTemplate,wikiTopic);

        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(wikiMediaUrl)).build();
        eventSource.start();
        logger.info("Stream Started..!!!");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(()-> {
            logger.info("Stopping Stream after a minute...!!!!!");
            eventSource.close();
        },20,TimeUnit.SECONDS);
        TimeUnit.MINUTES.sleep(1);
    }



}


