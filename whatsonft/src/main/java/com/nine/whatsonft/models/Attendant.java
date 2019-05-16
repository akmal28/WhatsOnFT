package com.nine.whatsonft.models;

/**
 * Class untuk model pengunjung event
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class Attendant {
    private int event;
    private int user;

    /**
     * Constructor untuk class Attendant
     * @param event
     * @param user
     */
    public Attendant(int event, int user) {
        this.event = event;
        this.user = user;
    }

    /**
     * Method getter untuk mendapatkan event
     * @return
     */
    public int getEvent() {
        return event;
    }

    /**
     * Method setter untuk mengubah event
     * @param event
     */
    public void setEvent(int event) {
        this.event = event;
    }

    /**
     * Method getter untuk mendapatkan user
     * @return
     */
    public int getUser() {
        return user;
    }

    /**
     * Method setter untuk mengubah user
     * @param user
     */
    public void setUser(int user) {
        this.user = user;
    }
}
