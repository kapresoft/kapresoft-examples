package com.kapresoft.articles.nodi;

import com.kapresoft.articles.nodi.dao.UserDAO;
import com.kapresoft.articles.nodi.dao.UserDAOImpl;
import com.kapresoft.articles.nodi.email.EmailSender;
import com.kapresoft.articles.nodi.email.EmailSenderImpl;
import com.kapresoft.articles.nodi.service.EmailService;
import com.kapresoft.articles.nodi.service.EmailServiceImpl;
import com.kapresoft.articles.nodi.service.UserService;
import com.kapresoft.articles.nodi.service.UserServiceImpl;

public class ApplicationContext {

    private static class Holder {
        private static final ApplicationContext CTX = new ApplicationContext();
        private static final UserService USER_SERVICE = new UserServiceImpl();
        private static final EmailService EMAIL_SERVICE = new EmailServiceImpl();
    }

    public static ApplicationContext getInstance() {
        return Holder.CTX;
    }

    UserService userService() {
        return Holder.USER_SERVICE;
    }


    EmailService emailService() {return Holder.EMAIL_SERVICE; }

    // Prototype
    UserDAO userDAO() {
        return new UserDAOImpl();
    }

    // Prototype
    EmailSender emailSender() {
        return new EmailSenderImpl();
    }

}
