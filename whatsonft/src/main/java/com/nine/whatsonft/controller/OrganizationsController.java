package com.nine.whatsonft.controller;

import com.nine.whatsonft.database.DatabaseOrganizations;
import com.nine.whatsonft.database.DatabaseUsers;
import com.nine.whatsonft.enums.OrgCategory;
import com.nine.whatsonft.models.Organizations;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrganizationsController {
    private DatabaseOrganizations db = new DatabaseOrganizations();

    @RequestMapping(value = "/organizations/register", method = RequestMethod.POST)
    public Organizations organizationsRegistration(@RequestParam(value="name") String name,
                                                   @RequestParam(value="category") String category,
                                                   @RequestParam(value="admin") int adminId)
    {
        try {
            return db.newOrganization(name, OrgCategory.valueOf(category), adminId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/organizations/login", method = RequestMethod.POST)
    public Organizations organizationsLogin(@RequestParam(value = "email") String email,
                                            @RequestParam(value = "password") String password)
    {
        try {
            return db.loginOrganization(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/organizations/{id}")
    public Organizations getOrganization(@PathVariable int id){
        try {
            return db.getOrganizationById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/organizations/update", method = RequestMethod.PATCH)
    public Organizations updateOrganization(@RequestParam(value = "id") int id,
                                            @RequestParam(value = "name") String name,
                                            @RequestParam(value = "category") String category)
    {
        try {
            return db.updateOrganization(id, name, OrgCategory.valueOf(category));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/organizations/delete", method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam(value = "id") int id)
    {
        try {
            return db.deleteOrganization(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
