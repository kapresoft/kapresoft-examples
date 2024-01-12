package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.model.User;

@SuppressWarnings("unused")
public interface EmailService {

    void confirmEmailAddress(User user);

}
