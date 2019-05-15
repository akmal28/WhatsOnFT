package com.nine.whatsonft.database;

import com.nine.whatsonft.database.DbConnection;
import com.nine.whatsonft.enums.OrgCategory;
import com.nine.whatsonft.models.Organizations;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseOrganizations extends DbConnection {
    private final Connection conn = super.connection();

    public Organizations newOrganization(int id, String name, OrgCategory category) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("INSERT INTO organizations (name, category) VALUES (?,?) RETURNING id");
        posted.setString(1, name);
        posted.setString(2, category.toString());
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            id = rs.getInt("id");
        }
        Organizations organization = new Organizations(id, name, category);
        return organization;
    }

    public ArrayList<Organizations> getOrganizations() throws SQLException{
        ArrayList<Organizations> orgList = new ArrayList<>();
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM organizations");
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            orgList.add(new Organizations(rs.getInt("id"), rs.getString("name"), OrgCategory.valueOf(rs.getString("category"))));
        }
        return orgList;
    }

    public Organizations getOrganizationById(int id) throws SQLException{
        Organizations organization = null;
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM organizations WHERE id = (?)");
        posted.setInt(1,id);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            organization = new Organizations(rs.getInt("id"), rs.getString("name"), OrgCategory.valueOf(rs.getString("category")));
        }
        return organization;
    }

    public Organizations updateOrganization(int id, String name, OrgCategory category) throws SQLException{
        Organizations organization = null;
        PreparedStatement posted = conn.prepareStatement("UPDATE FROM organizations SET name = (?) AND category = (?) WHERE id = (?) RETURNING *");
        posted.setString(1, name);
        posted.setString(2, category.toString());
        posted.setInt(2, id);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            organization = new Organizations(rs.getInt("id"), rs.getString("name"), OrgCategory.valueOf(rs.getString("category")));
        }
        return organization;
    }

    public boolean deleteOrganization(int id) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("DELETE FROM organizations WHERE id = (?)");
        posted.setInt(1, id);
        posted.executeQuery();
        return true;
    }

}
