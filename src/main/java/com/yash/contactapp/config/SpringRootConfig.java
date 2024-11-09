package com.yash.contactapp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan(basePackages = {"com.yash"})
public class SpringRootConfig {
    //TODO: Services, DAO, DataSource, Email sender or some other business layer beans

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/contact_app");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxTotal(2); // adjusting the load based on the connection
        ds.setInitialSize(1); // setting initial 1 connection
        ds.setTestOnBorrow(true); // connection will be tested by validation query when borrowed
        ds.setValidationQuery("select 1"); // query to test weather or not connection is valid
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
