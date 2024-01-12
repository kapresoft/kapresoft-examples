package com.kapresoft.articles.nodi.exception;

public class CreateUserFailedException extends BusinessException {
    public CreateUserFailedException(String email) {
        super("Failed to create user: " + email);
    }
}
