package com.yash.contactapp;

import com.yash.contactapp.config.SpringRootConfig;
import com.yash.contactapp.dao.UserDAO;
import com.yash.contactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOFindSingleRecord {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        User u = userDAO.findById(1);

        System.out.println("---------user details---------");
        System.out.println(u);
    }
}
