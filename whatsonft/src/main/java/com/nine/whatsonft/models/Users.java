package com.nine.whatsonft.models;

import java.util.regex.*;

/**
 * Class ini merupakan model Users
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class Users {
    private int id;
    private String name;
    private String username;
    private String department;
    private String email;
    private String password;

    /**
     * Constructor untuk class Users.
     * @param id
     * @param name
     * @param username
     * @param department
     * @param email
     * @param password
     */
    public Users(int id, String name, String username, String department, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Method getter untuk mendapatkan ID user
     * @return  id
     */
    public int getId() {
        return id;
    }

    /**
     * Method setter untuk mengubah nilai ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method getter untuk mendapatkan nama user
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method setter untuk mengubah nama user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getter untuk mendapatkan username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method setter untuk mengubah username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method getter untuk mendapatkan asal departemen user
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Method setter untuk mengubah departemen user
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method getter untuk mendapatkan asal email user
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method setter untuk mengubah email user. Method ini menggunakan regular expression.
     * @param email
     */
    public void setEmail(String email) {
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if(m.find()){
            System.out.println("Email: " + m.group());
            this.email = email;
        }else{
            System.out.println("Email: NULL");
            this.email = "NULL";
        }
    }

    /**
     * Method getter untuk mendapatkan password user
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method setter untuk mengubah password user. Method ini menggunakan regular expression.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
