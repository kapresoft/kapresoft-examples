package com.kapresoft.articles.api.repository;

import com.kapresoft.articles.api.model.User;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface StaticUserRepository {

    default Map<Long, User> allUsers() {
        return Stream.of(steveRogers(), lindaCarter())
                .collect(Collectors.toUnmodifiableMap(User::getId, u -> u));
    }

    default User steveRogers() {
        return User.builder().id(1L).email("steve.rogers@gmail.com")
                .first("Steve")
                .last("Rogers")
                .build();
    }
    default User lindaCarter() {
        return User.builder().id(2L).email("linda.carter@gmail.com")
                .first("Linda")
                .last("Carter")
                .build();
    }
}
