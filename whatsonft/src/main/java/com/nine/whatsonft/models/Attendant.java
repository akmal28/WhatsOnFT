package com.nine.whatsonft.models;

public class Attendant {
    private int event;
    private int user;

    public Attendant(int event, int user) {
        this.event = event;
        this.user = user;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
