package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.EventType;
import com.nine.whatsonft.enums.NonAcadEventCategory;
import com.nine.whatsonft.models.Events;
import com.nine.whatsonft.models.Organizations;

import java.util.Calendar;

/**
 * Class ini merupakan subclass dari class Event yang berfungsi untuk model event non-akademis
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class NonAcademicEvent extends Events {
    private EventType eventType = EventType.NonAcademic;
    private NonAcadEventCategory category;

    /**
     * Constructor untuk class NonAcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param category
     * @param date
     */
    public NonAcademicEvent(int id, String name, Organizations organization, String description, NonAcadEventCategory category, String date) {
        super(id, name, organization, description, date);
        this.category = category;
    }

    /**
     * Constructor untuk class NonAcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param category
     * @param dayOfMonth
     * @param month
     * @param year
     */
    public NonAcademicEvent(int id, String name, Organizations organization, String description, NonAcadEventCategory category, int dayOfMonth, int month, int year) {
        super(id, name, organization, description, dayOfMonth, month, year);
        this.category = category;
    }

    /**
     * Method getter untuk mendapatkan tipe event
     * @return
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * Method getter untuk mendapatkan kategori event
     * @return
     */
    public NonAcadEventCategory getCategory() {
        return category;
    }

    /**
     * Method setter untuk mengubah kategori event
     * @param category
     */
    public void setCategory(NonAcadEventCategory category) {
        this.category = category;
    }
}
