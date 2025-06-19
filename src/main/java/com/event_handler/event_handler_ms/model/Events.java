package com.event_handler.event_handler_ms.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public class Events {

    private String type;
    private List<Attributes> requiredAttributes;
    private Action action;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attributes> getRequiredAttributes() {
        return requiredAttributes;
    }

    public void setRequiredAttributes(List<Attributes> requiredAttributes) {
        this.requiredAttributes = requiredAttributes;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Events{" +
                "type='" + type + '\'' +
                ", requiredAttributes=" + requiredAttributes +
                ", action=" + action +
                '}';
    }
}
