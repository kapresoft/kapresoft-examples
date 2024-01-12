package com.kapresoft.articles.nodi;

import com.kapresoft.articles.nodi.dao.UserDAO;
import com.kapresoft.articles.nodi.email.EmailSender;
import com.kapresoft.articles.nodi.service.EmailService;
import com.kapresoft.articles.nodi.service.UserService;

@SuppressWarnings("unused")
public interface ApplicationContextSupport {

    default ApplicationContext applicationContext() {
        return ApplicationContext.getInstance();
    }

    default UserDAO userDao() {
        return applicationContext().userDAO();
    }

    default EmailSender emailSender() {
        return applicationContext().emailSender();
    }

    default UserService userService() {
        return applicationContext().userService();
    }

    default EmailService emailService() {
        return applicationContext().emailService();
    }

}
