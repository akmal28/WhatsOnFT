package com.nine.whatsonft.models;

import com.nine.whatsonft.models.Organizations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class ini adalah abstract class untuk model Event
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public abstract class Events {
    private int id;
    private String name;
    private Organizations organization;
    private String description;
    private Calendar date;

    /**
     * Constructor untuk class Event
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param date
     */
    public Events(int id, String name, Organizations organization, String description, Calendar date) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.description = description;
        this.date = date;
    }

    /**
     * Constructor untuk class Event
     * @param id
     * @param name
     * @param organization
     * @param description
     * @param dayOfMonth
     * @param month
     * @param year
     */
    public Events(int id, String name, Organizations organization, String description, int dayOfMonth, int month, int year) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.description = description;
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Method getter untuk mendapatkan ID event
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Method setter untuk mengubah ID event
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method getter untuk mendapatkan nama event
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method setter untuk mengubah nama event
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getter untuk mendapatkan organisasi penyelenggara
     * @return
     */
    public Organizations getOrganization() {
        return organization;
    }

    /**
     * Method setter untuk mengubah organisasi
     * @param organization
     */
    public void setOrganization(Organizations organization) {
        this.organization = organization;
    }

    /**
     * Method getter untuk mendapatkan deskripsi event
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method setter untuk mengubah deskripsi event
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method getter untuk mendapatkan tanggal event
     * @return
     */
    public Calendar getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");
        return date;
    }

    /**
     * Method setter untuk mengubah tanggal event
     * @param dayOfMonth
     * @param month
     * @param year
     */
    public void setDate(int dayOfMonth, int month, int year) {
        GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
    }
}
