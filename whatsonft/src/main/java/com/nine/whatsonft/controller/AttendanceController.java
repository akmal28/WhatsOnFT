package com.nine.whatsonft.controller;

import com.nine.whatsonft.database.DatabaseAttendant;
import com.nine.whatsonft.models.Attendant;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class ini merupakan controller untuk sistem kehadiran atau Attendance
 * @author Hasnan Fiqih
 * @version 16-02-2019
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AttendanceController {
    private DatabaseAttendant db = new DatabaseAttendant();

    /**
     * Method ini berfungsi sebagai penanda kehadiran
     * @param eventId
     * @param userId
     * @return
     */

    @RequestMapping(value = "/attendant/addattendant", method = RequestMethod.POST)
    public Attendant addAttendant(@RequestParam(value = "event_id")int eventId,
                                  @RequestParam(value = "user_id")int userId)
    {
        try{
            return db.addAttendant(eventId, userId);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk melihat daftar kehadiran berdasarkan dari eventId
     * @param eventId
     * @return
     */

    @RequestMapping("/attendant/eventattendant/{eventId}")
    public ArrayList<Attendant> getEventAttendant(@PathVariable int eventId)
    {
        try {
            return db.getEventAttendant(eventId);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk melihat daftar kehadiran berdasarkan dari userId
     * @param userId
     * @return
     */

    @RequestMapping("/attendant/userattendant/{userId}")
    public ArrayList<Attendant> getUserAttendant(@PathVariable int userId)
    {
        try {
            return db.getUserAttendance(userId);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk menghapus data kehadiran dari User dengan menggunakan userId
     * @param userId
     * @return
     */

    @RequestMapping(value = "/attendant/delete", method = RequestMethod.DELETE)
    public boolean removeAttendant(@RequestParam(value = "userId") int userId)
    {
        try {
            return db.removeAttendant(userId);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

}