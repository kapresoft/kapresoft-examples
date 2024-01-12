package com.kapresoft.articles.nodi.dao;

import com.kapresoft.articles.nodi.exception.UserExistsException;
import com.kapresoft.articles.nodi.model.User;

import java.util.Optional;

public interface UserDAO {

    Optional<User> findUserByEmail(String email);

    void createUser(User user) throws UserExistsException;

}
