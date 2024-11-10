package com.yash.contactapp;

import com.yash.contactapp.config.SpringRootConfig;
import com.yash.contactapp.dao.UserDAO;
import com.yash.contactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOUpdate {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        User u = new User();
        u.setUserId(2);
        u.setName("Shreyash Agrawal");
        u.setPhone("1234567890");
        u.setEmail("Shreyash@yash.com");
        u.setAddress("Indore");
        u.setRole(1);
        u.setLoginStatus(1);

        userDAO.update(u);
        System.out.println("---------update success---------");
    }
}
