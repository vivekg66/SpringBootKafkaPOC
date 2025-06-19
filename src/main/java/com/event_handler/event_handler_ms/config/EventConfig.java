package com.event_handler.event_handler_ms.config;

import com.event_handler.event_handler_ms.model.EventMapping;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@ConfigurationProperties(prefix = "")
public class EventConfig {

    List<EventMapping> services;

    public EventConfig() {
    }

    public EventConfig(List<EventMapping> services) {
        this.services = services;
    }

    public List<EventMapping> getServices() {
        return services;
    }

    public void setServices(List<EventMapping> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "EventConfig{" +
                "services=" + services +
                '}';
    }
}
