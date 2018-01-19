package com.liqubase;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {


    @Autowired
    private DataSource dataSource;

    @Bean
    SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:config/liquibase/changelog-master.xml");
        liquibase.setDataSource(dataSource);
        liquibase.setContexts("test, production");
        return liquibase;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
