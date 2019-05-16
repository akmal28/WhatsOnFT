package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.AcadEventCategory;
import com.nine.whatsonft.enums.EventType;

import java.util.Calendar;

/**
 * Class ini merupakan subclass dari class Events yang berfungsi untuk model event akademis
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class AcademicEvent extends Events {
    private EventType eventType = EventType.Academic;
    private AcadEventCategory category;

    /**
     * Constructor untuk class AcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param category
     * @param date
     */
    public AcademicEvent(int id, String name, Organizations organization, String description, AcadEventCategory category,Calendar date) {
        super(id, name, organization, description, date);
        this.category = category;
    }

    /**
     * Constructor untuk class AcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param category
     * @param dayOfMonth
     * @param month
     * @param year
     */
    public AcademicEvent(int id, String name, Organizations organization, String description, AcadEventCategory category, int dayOfMonth, int month, int year) {
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
    public AcadEventCategory getCategory() {
        return category;
    }

    /**
     * Method setter untuk mengubah kategori event
     * @param category
     */
    public void setCategory(AcadEventCategory category) {
        this.category = category;
    }
}
