package com.event_handler.event_handler_ms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@RequiredArgsConstructor
public class EventMapping {

    private String name;
    private List<Events> events;
    private List<Attributes> requiredAttributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<Attributes> getRequiredAttributes() {
        return requiredAttributes;
    }

    public void setRequiredAttributes(List<Attributes> requiredAttributes) {
        this.requiredAttributes = requiredAttributes;
    }

    @Override
    public String toString() {
        return "EventMapping{" +
                "name='" + name + '\'' +
                ", events=" + events +
                ", requiredAttributes=" + requiredAttributes +
                '}';
    }
}
