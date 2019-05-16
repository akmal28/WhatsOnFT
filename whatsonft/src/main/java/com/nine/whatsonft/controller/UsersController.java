package com.nine.whatsonft.controller;

import com.nine.whatsonft.database.DatabaseUsers;
import com.nine.whatsonft.models.Users;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Class ini merupakan controller untuk User
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
@RestController
public class UsersController {
    private DatabaseUsers db = new DatabaseUsers();

    /**
     * Method ini berfungsi untuk registrasi user baru
     * @param name
     * @param username
     * @param department
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public Users userRegistration(@RequestParam(value="name") String name,
                         @RequestParam(value="username") String username,
                         @RequestParam(value="department") String department,
                         @RequestParam(value="email") String email,
                         @RequestParam(value="password") String password)
    {
        try {
            return db.newUser(name, username, department, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk mendapatkan informasi user dengan ID
     * @param id
     * @return
     */
    @RequestMapping("/users/{id}")
    public Users getUser(@PathVariable int id)
    {
        try {
            return db.getUsers(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk login user
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public Users userLogin(@RequestParam(value = "email") String email,
                           @RequestParam(value = "password") String password)
    {
        try{
            return db.loginUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method untuk menghapus data user
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/delete", method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam(value = "id") int id)
    {
        try {
            return db.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
