package com.nine.whatsonft.database;

import com.nine.whatsonft.database.DbConnection;
import com.nine.whatsonft.models.Attendant;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAttendant extends DbConnection {
    private final Connection conn = super.connection();

    public Attendant addAttendant(int eventId, int userID) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("INSERT INTO attendants VALUES (?,?)");
        posted.setInt(1, eventId);
        posted.setInt(2, userID);
        posted.executeQuery();
        Attendant attendant = new Attendant(eventId, userID);
        return attendant;
    }

    public ArrayList<Attendant> getEventAttendant(int eventId) throws SQLException{
        ArrayList<Attendant> attendantList = new ArrayList<>();
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM attendants WHERE event_id = (?)");
        posted.setInt(1, eventId);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            attendantList.add(new Attendant(rs.getInt("event_id"), rs.getInt("user_id")));
        }
        return attendantList;
    }

    public ArrayList<Attendant> getUserAttendace(int userId) throws SQLException{
        ArrayList<Attendant> eventList = new ArrayList<>();
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM attendants WHERE user_id = (?)");
        posted.setInt(1, userId);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            eventList.add(new Attendant(rs.getInt("event_id"), rs.getInt("user_id")));
        }
        return eventList;
    }

    public boolean removeAttendant(int userId) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("DELETE FROM attendants WHERE user_id = (?)");
        posted.setInt(1, userId);
        posted.executeQuery();
        return true;
    }
}
