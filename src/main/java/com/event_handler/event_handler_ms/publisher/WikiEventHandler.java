package com.event_handler.event_handler_ms.publisher;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.springframework.kafka.core.KafkaTemplate;


public class WikiEventHandler implements EventHandler {

    private final KafkaTemplate<String,String> kafkaWikiTemplate;
    private final String topic;

    public WikiEventHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaWikiTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        // TODO document why this method is empty
    }

    @Override
    public void onClosed() throws Exception {
        // TODO document why this method is empty
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        String data = messageEvent.getData();
        kafkaWikiTemplate.send(topic,data);
    }

    @Override
    public void onComment(String s) throws Exception {
        // TODO document why this method is empty
    }

    @Override
    public void onError(Throwable throwable) {
        // TODO document why this method is empty
    }
}
