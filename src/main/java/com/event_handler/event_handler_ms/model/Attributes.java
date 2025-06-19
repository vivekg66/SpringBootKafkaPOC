package com.event_handler.event_handler_ms.model;

import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
public class Attributes {

    private String name;
    private String valuePath;
    private String responseAttributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValuePath() {
        return valuePath;
    }

    public void setValuePath(String valuePath) {
        this.valuePath = valuePath;
    }

    public String getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(String responseAttributes) {
        this.responseAttributes = responseAttributes;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "name='" + name + '\'' +
                ", valuePath='" + valuePath + '\'' +
                ", responseAttributes='" + responseAttributes + '\'' +
                '}';
    }
}
