package com.nine.whatsonft.database;

import com.nine.whatsonft.database.DbConnection;
import com.nine.whatsonft.enums.AcadEventCategory;
import com.nine.whatsonft.enums.EventType;
import com.nine.whatsonft.enums.NonAcadEventCategory;
import com.nine.whatsonft.enums.OrgCategory;
import com.nine.whatsonft.models.AcademicEvent;
import com.nine.whatsonft.models.NonAcademicEvent;
import com.nine.whatsonft.models.Events;
import com.nine.whatsonft.models.Organizations;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class ini merupakan class yang terhubung ke database Event
 * @author WhatsonFTDEV
 * @version 16-05-2019
 */

public class DatabaseEvent extends DbConnection {
    private final Connection conn = super.connection();
    private DatabaseOrganizations dbo = new DatabaseOrganizations();

    public Events newEvent(String name, int orgId, String type, String category, String description, String date) throws SQLException {
        int id = 0;
        PreparedStatement posted = conn.prepareStatement("insert into events(name, org_id, type, category, description, date) values (?, ?,?,?,?,?) RETURNING id");
        posted.setString(1, name);
        posted.setInt(2, orgId);
        posted.setString(4, category);
        posted.setString(5, description);
        posted.setString(6, date);
        if (type.equals("Academic")){
            posted.setString(3, EventType.Academic.toString());
            ResultSet res = posted.executeQuery();
            while (res.next()){
                id = res.getInt("id");
            }
            return new AcademicEvent(id, name, dbo.getOrganizationById(orgId), description, date);
        }

        else {
            posted.setString(3, EventType.NonAcademic.toString());
            ResultSet res = posted.executeQuery();
            while (res.next()){
                id = res.getInt("id");
            }
            return new NonAcademicEvent(id, name, dbo.getOrganizationById(orgId), description, NonAcadEventCategory.valueOf(category), date);

        }

    }

//    public Events newNonAcademicEvent(String name, Organizations org, String type, NonAcadEventCategory category, String description, Calendar date) throws SQLException {
//
//        int id = 0;
//        PreparedStatement posted = conn.prepareStatement("insert into events(name, org_id, type, category, description, date) values (?, ?, ?, ?, ?) RETURNING id")
//        posted.setString(1, name);
//        posted.setInt(2, org.getId());
//        posted.setString(3, NonAcademicEvent.getEventType().toString());
//        posted.setString(4, category.toString());
//        posted.setString(5, description);
//        posted.setString(6, date.toString());
//        ResultSet res = posted.executeQuery();
//        while (res.next()){
//            id = res.getInt("id");
//        }
//        Events event = new NonAcademicEvent(id, name, org, description, category, date);
//        return event;
//    }

    public Events getEventsbyId(int id) throws SQLException {
        Events event = null;
        PreparedStatement posted = conn.prepareStatement("select * from events where id = (?)");
        posted.setInt(1, id);
        ResultSet res = posted.executeQuery();
        while (res.next()) {
            String date = res.getDate("date").toString();
            if (res.getString("type").equals("Academic")){
                event = new AcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")),  res.getString("description"),date);
            }else {
                event = new NonAcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")), res.getString("description"), NonAcadEventCategory.valueOf(res.getString("category")), date);
            }
        }
        return event;
    }

    public boolean deleteEvent (int id) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("DELETE FROM events WHERE id = (?)");
        posted.setInt(1, id);
        posted.executeUpdate();
        return true;
    }

    public ArrayList<Events> getEvents() throws SQLException{
        ArrayList<Events> eventList = new ArrayList<>();
        PreparedStatement posted = conn.prepareStatement("select * from events");
        ResultSet res = posted.executeQuery();
        while (res.next()){
            if (res.getString("type").equals("Academic")){
                eventList.add(new AcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")),  res.getString("description"),res.getString("date")));
            }
            else {
                eventList.add(new NonAcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")), res.getString("description"), NonAcadEventCategory.valueOf(res.getString("category")), res.getString("date")));
            }
        }
        return eventList;
    }

    public ArrayList<Events> getEventsByOrganization(int orgId) throws SQLException{
        ArrayList<Events> eventList = new ArrayList<>();
        PreparedStatement posted = conn.prepareStatement("select * from events where org_id = (?)");
        posted.setInt(1, orgId);
        ResultSet res = posted.executeQuery();
        while (res.next()){
            if (res.getString("type").equals("Academic")){
                eventList.add(new AcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")),  res.getString("description"),res.getString("date")));
            }
            else {
                eventList.add(new NonAcademicEvent(res.getInt("id"), res.getString("name"), dbo.getOrganizationById(res.getInt("org_id")), res.getString("description"), NonAcadEventCategory.valueOf(res.getString("category")), res.getString("date")));
            }
        }
        return eventList;
    }


}