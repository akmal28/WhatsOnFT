package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.AcadEventCategory;
import com.nine.whatsonft.enums.EventType;

import java.util.Calendar;

public class AcademicEvent extends Events {
    private EventType eventType = EventType.Academic;
    private AcadEventCategory category;

    public AcademicEvent(int id, String name, Organizations organization, String description, AcadEventCategory category,Calendar date) {
        super(id, name, organization, description, date);
        this.category = category;
    }

    public AcademicEvent(int id, String name, Organizations organization, String description, AcadEventCategory category, int dayOfMonth, int month, int year) {
        super(id, name, organization, description, dayOfMonth, month, year);
        this.category = category;
    }

    public EventType getEventType() {
        return eventType;
    }

    public AcadEventCategory getCategory() {
        return category;
    }

    public void setCategory(AcadEventCategory category) {
        this.category = category;
    }
}
