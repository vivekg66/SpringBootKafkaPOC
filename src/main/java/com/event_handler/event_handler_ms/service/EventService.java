package com.event_handler.event_handler_ms.service;


import java.util.Map;

public interface EventService {

     void processEvent(String service, String eventType, Map<String,Object> eventMessage);
}
