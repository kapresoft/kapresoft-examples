package com.kapresoft.articles.nodi.exception;

public class UserNotFoundException extends ObjectNotFoundException {
    public UserNotFoundException(String email) {
        super("User not found with email: " + email);
    }

}
