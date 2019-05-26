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

    /**
     * Constructor untuk class AcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param date
     */
    public AcademicEvent(int id, String name, Organizations organization, String description,String date) {
        super(id, name, organization, description, date);
    }

    /**
     * Constructor untuk class AcademicEvent
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param dayOfMonth
     * @param month
     * @param year
     */
    public AcademicEvent(int id, String name, Organizations organization, String description, int dayOfMonth, int month, int year) {
        super(id, name, organization, description, dayOfMonth, month, year);
    }

    /**
     * Method getter untuk mendapatkan tipe event
     * @return
     */
    public EventType getEventType() {
        return eventType;
    }

}
