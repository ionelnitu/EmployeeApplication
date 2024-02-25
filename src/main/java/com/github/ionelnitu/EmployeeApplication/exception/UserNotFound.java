package com.github.ionelnitu.EmployeeApplication.exception;


public class UserNotFound extends RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
}
