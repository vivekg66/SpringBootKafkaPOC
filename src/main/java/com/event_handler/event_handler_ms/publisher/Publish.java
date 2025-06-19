package com.event_handler.event_handler_ms.publisher;

import java.util.Map;

public interface Publish {

    void processEvent(String destination, Map<String,Object> eventMessage);
}
