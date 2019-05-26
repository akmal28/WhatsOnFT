package com.nine.whatsonft.controller;

import com.nine.whatsonft.database.DatabaseEvent;
import com.nine.whatsonft.enums.AcadEventCategory;
import com.nine.whatsonft.enums.NonAcadEventCategory;
import com.nine.whatsonft.models.Events;

import com.nine.whatsonft.models.Organizations;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EventsController{
    private DatabaseEvent db = new DatabaseEvent();

    @RequestMapping(value = "/events/new", method = RequestMethod.POST)
    public Events eventRegistration(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "organization") int orgId,
            @RequestParam(value = "category") String category,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "date")String date)
    {
        try {
            return db.newEvent(name,orgId,category,description, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/events/delete", method = RequestMethod.DELETE)
    public boolean deleteEvent(@RequestParam(value = "id") int id) {
        try {
            return db.deleteEvent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @RequestMapping ("/events/{id}")
    public Events getUser(@PathVariable int id)
    {
        try {
            return db.getEventsbyId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/events")
    public ArrayList<Events> getEvents(){
        try {
            return db.getEvents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

