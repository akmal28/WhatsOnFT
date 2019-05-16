package com.nine.whatsonft.enums;

/**
 * Enum untuk tipe event
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public enum EventType {
    Academic("Academic"), NonAcademic("Non-Academic");
    private String value;

    /**
     * Method untuk value dari enum
     * @param value
     */
    EventType(String value) {
        this.value = value;
    }
}
