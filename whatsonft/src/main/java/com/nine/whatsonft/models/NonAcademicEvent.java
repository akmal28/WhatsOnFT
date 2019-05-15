package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.EventType;
import com.nine.whatsonft.enums.NonAcadEventCategory;
import com.nine.whatsonft.models.Events;
import com.nine.whatsonft.models.Organizations;

import java.util.Calendar;

public class NonAcademicEvent extends Events {
    final private EventType type = EventType.NonAcademic;
    private NonAcadEventCategory category;

    public NonAcademicEvent(int id, String name, Organizations organization, String description, NonAcadEventCategory category, Calendar date) {
        super(id, name, organization, description, date);
        this.category = category;
    }

    public NonAcademicEvent(int id, String name, Organizations organization, String description, NonAcadEventCategory category, int dayOfMonth, int month, int year) {
        super(id, name, organization, description, dayOfMonth, month, year);
        this.category = category;
    }

    public EventType getType() {
        return type;
    }

    public NonAcadEventCategory getCategory() {
        return category;
    }

    public void setCategory(NonAcadEventCategory category) {
        this.category = category;
    }
}
