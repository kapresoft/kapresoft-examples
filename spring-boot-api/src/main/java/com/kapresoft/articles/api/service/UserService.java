package com.kapresoft.articles.api.service;

import com.kapresoft.articles.api.exception.client.UserNotFoundException;
import com.kapresoft.articles.api.exception.client2.InsufficientFundsException2;
import com.kapresoft.articles.api.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        if (id == 2L) {
            throw new UserNotFoundException(id);
        } else if (id == 3L) {
            throw new InsufficientFundsException2("Not enough funds.");
        }
        return User.builder()
                .id(1L)
                .first("John")
                .last("Doe")
                .email("johndoe@gmail.com")
                .active(true)
                .build();
    }

}
