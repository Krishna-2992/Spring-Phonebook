package com.yash.contactapp;

import com.yash.contactapp.config.SpringRootConfig;
import com.yash.contactapp.dao.UserDAO;
import com.yash.contactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOSave {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        User u = new User();
        u.setName("Shreyash");
        u.setPhone("1234567890");
        u.setEmail("Shreyash@gmail.com");
        u.setAddress("Satna");
        u.setLoginName("Shreyash2992");
        u.setPassword("Shreyash@123");
        u.setRole(1);
        u.setLoginStatus(1);
        userDAO.save(u);
        System.out.println("---------Build success---------");
    }
}
