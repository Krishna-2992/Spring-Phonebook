package com.yash.contactapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.yash"})
public class SpringRootConfig {
    //TODO: Services, DAO, DataSource, Email sender or some other business layer beans
}
