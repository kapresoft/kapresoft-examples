package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.ApplicationContextSupport;
import com.kapresoft.articles.nodi.exception.BusinessException;
import com.kapresoft.articles.nodi.exception.CreateUserFailedException;
import com.kapresoft.articles.nodi.exception.UserNotFoundException;
import com.kapresoft.articles.nodi.model.User;

import static java.util.Optional.ofNullable;

public class UserServiceImpl implements UserService, ApplicationContextSupport {

    @Override
    public User registerUser(User user) throws BusinessException {
        userDao().createUser(user);
        String email = user.getEmail();
        var createdUser = userDao().findUserByEmail(email)
                .orElseThrow(() -> new CreateUserFailedException(email));
        emailService().confirmEmailAddress(createdUser);
        return createdUser;
    }

    @Override
    public User findUser(String email) throws UserNotFoundException {
        return ofNullable(email)
                .flatMap(em -> userDao().findUserByEmail(em))
                .orElseThrow(() -> new UserNotFoundException(email));
    }

}
