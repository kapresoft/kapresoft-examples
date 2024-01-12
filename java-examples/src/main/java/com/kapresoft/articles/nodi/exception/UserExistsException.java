package com.kapresoft.articles.nodi.exception;

public class UserExistsException extends BusinessException {
    public UserExistsException(String email) {
        super("User with email already exists: " + email);
    }
}
