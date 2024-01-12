package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.ApplicationContextSupport;
import com.kapresoft.articles.nodi.model.User;

public class EmailServiceImpl implements EmailService, ApplicationContextSupport {

    /**
     * Email confirm the email address on the newly created account.
     */
    @Override
    public void confirmEmailAddress(User user) {
        String email = user.getEmail();
        String subject = "Confirm Email Address";
        String body = "Please confirm email address: " + email;
        emailSender().sendEmail(email, subject, body);
    }

}
