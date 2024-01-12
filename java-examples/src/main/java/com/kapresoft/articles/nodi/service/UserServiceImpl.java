package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.ApplicationContextSupport;
import com.kapresoft.articles.nodi.exception.CreateUserFailedException;
import com.kapresoft.articles.nodi.exception.UserExistsException;
import com.kapresoft.articles.nodi.exception.UserNotFoundException;
import com.kapresoft.articles.nodi.model.User;

import static java.util.Optional.ofNullable;

public class UserServiceImpl implements UserService, ApplicationContextSupport {

    @Override
    public User registerUser(User user) throws UserExistsException {
        userDao().createUser(user);
        String email = user.getEmail();
        return userDao().findUserByEmail(email)
                .orElseThrow(() -> new CreateUserFailedException(email));
    }

    @Override
    public User findUser(String email) throws UserNotFoundException {
        return ofNullable(email)
                .flatMap(em -> userDao().findUserByEmail(em))
                .orElseThrow(() -> new UserNotFoundException(email));
    }

}
