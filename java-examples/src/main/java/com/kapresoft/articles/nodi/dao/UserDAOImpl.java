package com.kapresoft.articles.nodi.dao;

import com.kapresoft.articles.nodi.exception.UserExistsException;
import com.kapresoft.articles.nodi.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static java.util.Optional.ofNullable;

public class UserDAOImpl implements UserDAO {

    private static final Random RANDOM_ID = new Random(1000L);
    private final static Map<String, User> dataSource = new HashMap<>();

    @Override
    public Optional<User> findUserByEmail(String email) {
        // Example: A sql datasource to query to retrieve user info
        return ofNullable(dataSource.get(email));
    }

    public void createUser(User user) {
        String email = ofNullable(user).map(User::getEmail)
                .orElseThrow(() -> new IllegalArgumentException("Email missing"));
        if (dataSource.containsKey(user.getEmail())) {
            throw new UserExistsException(email);
        }
        final User newUser = user.withId(RANDOM_ID.nextLong(0, Long.MAX_VALUE));
        dataSource.put(email, newUser);
    }

}
