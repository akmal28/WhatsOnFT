package com.nine.whatsonft.models;

import com.nine.whatsonft.models.Organizations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Events {
    private int id;
    private String name;
    private Organizations organization;
    private String description;
    private Calendar date;

    public Events(int id, String name, Organizations organization, String description, Calendar date) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.description = description;
        this.date = date;
    }

    public Events(int id, String name, Organizations organization, String description, int dayOfMonth, int month, int year) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.description = description;
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organizations getOrganization() {
        return organization;
    }

    public void setOrganization(Organizations organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");
        return date;
    }

    public void setDate(int dayOfMonth, int month, int year) {
        GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
    }
}
