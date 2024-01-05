package com.kapresoft.articles.api.exception.client;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Long userID) {
        super("user-not-found", "User with ID is not found: " + userID);
    }

}
