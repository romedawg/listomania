package com.romedawg.listomania.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String phonumber){
        super( phonumber + " does not exists in our records, please sign up https://romedawg.com");
    }
}
