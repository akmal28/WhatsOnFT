package com.nine.whatsonft.exception;

import com.nine.whatsonft.models.Users;

import java.sql.SQLException;

/**
 * Method exception untuk melakukan pengecekan registrasi user
 */
public class UserAlreadyExistsException extends SQLException {
    private Users user_error;

    /**
     * Constructor untuk exception
     * @param user_input
     */
    public UserAlreadyExistsException(Users user_input){
        super("Username: ");
        user_error = user_input;
    }

    /**
     * Method getter untuk mendapatkan pesan exception
     * @return
     */
    public String getExMessage(){
        return super.getMessage() + user_error.getUsername() + ", or E-mail: " + user_error.getEmail() + " already exists.";
    }
}
