package com.nine.whatsonft.models;

import java.util.regex.*;

public class Users {
    private int id;
    private String name;
    private String username;
    private String department;
    private String email;
    private String password;

    public Users(int id, String name, String username, String department, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if(m.find()){
            System.out.println("Password: " + m.group());
            this.password = password;
        }else{
            System.out.println("Password: NULL");
            this.password = "NULL";
        }
    }

}
