package com.nine.whatsonft.controller;

import com.nine.whatsonft.database.DatabaseUsers;
import com.nine.whatsonft.models.Users;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UsersController {
    private DatabaseUsers db = new DatabaseUsers();

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

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
