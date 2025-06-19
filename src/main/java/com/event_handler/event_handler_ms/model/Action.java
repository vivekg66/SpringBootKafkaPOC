package com.event_handler.event_handler_ms.model;

import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
public class Action {
    private String service;
    private String destination;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Action{" +
                "service='" + service + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
