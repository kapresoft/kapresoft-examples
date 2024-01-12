package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.exception.UserExistsException;
import com.kapresoft.articles.nodi.exception.UserNotFoundException;
import com.kapresoft.articles.nodi.model.User;

@SuppressWarnings("unused")
public interface UserService {

    User registerUser(User user) throws UserExistsException;

    User findUser(String email) throws UserNotFoundException;

}
