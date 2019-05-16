package com.nine.whatsonft.database;

import com.nine.whatsonft.database.DbConnection;
import com.nine.whatsonft.models.Users;

import java.sql.*;

/**
 * Class ini berfungsi untuk berinterkasi dengan table user pada database
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class DatabaseUsers extends DbConnection {
    private final Connection conn = super.connection();

    /**
     * Method ini berfungsi untuk membuat user baru
     * @param name
     * @param username
     * @param department
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
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

    /**
     * Method ini berfungsi mendapatkan user dengan ID
     * @param id
     * @return
     * @throws SQLException
     */
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

    /**
     * Method ini berfungsi untuk user login
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
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

    /**
     * Method menghapus data user
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteUser(int id) throws SQLException{
        PreparedStatement posted = conn.prepareStatement("DELETE FROM users WHERE id = (?)");
        posted.setInt(1, id);
        posted.executeUpdate();
        return true;
    }
}
