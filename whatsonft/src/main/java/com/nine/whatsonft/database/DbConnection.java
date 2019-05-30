package com.nine.whatsonft.database;

import java.sql.*;

/**
 * Class untuk inisiasi koneksi dengan database
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class DbConnection {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "converse";
    private static final String CONN = "jdbc:postgresql://localhost:5432/whatsonft";

    /**
     * Method untuk mengatur koneksi dengan database
     * @return
     */
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
