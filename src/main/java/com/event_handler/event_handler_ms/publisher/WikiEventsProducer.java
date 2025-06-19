package com.event_handler.event_handler_ms.publisher;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
public class WikiEventsProducer {


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;



    String url = "https://stream.wikimedia.org/v2/stream/recentchange";

//    public void sendWikiData() throws InterruptedException {
//        EventHandler eventHandler = new WikiEventHandler(kafkaTemplate,"wiki-topic");
//
//        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
//        eventSource.start();
//        TimeUnit.MINUTES.sleep(1);
//    }



}


