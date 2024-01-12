package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.ApplicationContextSupport;
import com.kapresoft.articles.nodi.model.User;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest implements ApplicationContextSupport {

    @Test
    void registerUser() {
        User newUser = User.builder().email("steve.rogers@gmail.com")
                .first("Steve")
                .last("Rogers")
                .active(true)
                .build();

        User createdUser = userService().registerUser(newUser);
        assertThat(createdUser).isNotNull().satisfies(u -> {
            assertThat(u.getId()).as("Id")
                    .isGreaterThan(0L);
            assertThat(u.getEmail()).as("Email")
                    .isEqualTo("steve.rogers@gmail.com");
            assertThat(u.getFirst()).as("First Name")
                    .isEqualTo("Steve");
            assertThat(u.getLast()).as("Last Name")
                    .isEqualTo("Rogers");
        });
    }

}
