package com.nine.whatsonft.database;

import java.sql.*;

public class DbConnection {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "memento56";
    private static final String CONN = "jdbc:postgresql://localhost:5432/whatsonft";

    public Connection connection(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("Opened database successfully");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return conn;
    }
}
