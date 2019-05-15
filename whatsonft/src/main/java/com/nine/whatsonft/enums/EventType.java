package com.nine.whatsonft.enums;

public enum EventType {
    Academic("Academic"), NonAcademic("Non-Academic");
    private String value;

    EventType(String value) {
        this.value = value;
    }
}
