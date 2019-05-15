package com.nine.whatsonft.database;

import com.nine.whatsonft.database.DbConnection;
import com.nine.whatsonft.models.Users;

import java.sql.*;

public class DatabaseUsers extends DbConnection {
    private final Connection conn = super.connection();

    public Users newUser(String name, String username, String department, String email, String password) throws SQLException{
        int id = 0;
        PreparedStatement posted = conn.prepareStatement("INSERT INTO users(name, username, department, email, password) VALUES (?,?,?,?,?) RETURNING id");
        posted.setString(1, name);
        posted.setString(2, username);
        posted.setString(3, department);
        posted.setString(4, email);
        posted.setString(5, password);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            id = rs.getInt("id");
        }
        Users user = new Users(id, name, username, department, email, password);
        return user;
    }

    public Users getUsers(int id) throws SQLException{
        Users user = null;
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM users WHERE id = (?)");
        posted.setInt(1, id);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            user = new Users(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("department"), rs.getString("email"), rs.getString("password"));
        }
        return user;
    }

    public Users loginUser(String email, String password) throws SQLException{
        Users user = null;
        PreparedStatement posted = conn.prepareStatement("SELECT * FROM users WHERE email = (?) AND password = (?)");
        posted.setString(1, email);
        posted.setString(2, password);
        ResultSet rs = posted.executeQuery();
        while (rs.next()){
            user = new Users(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("department"), rs.getString("email"), rs.getString("password"));
        }
        return user;
    }

    public boolean deleteUser(int id) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("DELETE FROM user WHERE id = (?)");
        posted.setInt(1, id);
        posted.executeQuery();
        return true;
    }
}
