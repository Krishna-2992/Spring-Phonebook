package com.yash.contactapp;

import com.yash.contactapp.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);

        String sql = "INSERT into user (`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"Krishna", "7999609158", "krishnaagrawal2992@gmail.com", "Indore", "Krishna2992", "Krishna@123"};
        jt.update(sql, param);
        System.out.println("-----------------SQL EXECUTED---------------");
    }
}
