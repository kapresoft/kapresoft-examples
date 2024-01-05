package com.kapresoft.articles.api.service;

import com.kapresoft.articles.api.exception.client.UserNotFoundException;
import com.kapresoft.articles.api.model.User;
import com.kapresoft.articles.api.repository.StaticUserRepository;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Optional.ofNullable;

@Service
public class UserService implements StaticUserRepository {

    private final Map<Long, User> staticUsers;

    public UserService() {
        staticUsers = allUsers();
    }

    public User getUserById(@NonNull Long id) {
        return ofNullable(staticUsers.get(id))
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
