package com.yash.contactapp;

import com.yash.contactapp.config.SpringRootConfig;
import com.yash.contactapp.domain.User;
import com.yash.contactapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserServiceRegister {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);

        User u = new User();
        u.setName("Nitin");
        u.setPhone("1234567890");
        u.setEmail("Nitin@gmail.com");
        u.setAddress("Satna");
        u.setLoginName("nitin");
        u.setPassword("nitin@123");
        u.setRole(1);
        u.setLoginStatus(1);
        userService.register(u);
        System.out.println("---------User Registered successfully---------");
    }
}
