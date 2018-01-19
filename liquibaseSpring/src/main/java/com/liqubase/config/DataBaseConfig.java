package com.liqubase.config;

import com.liqubase.repository.PersonRepository;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author tao_wc
 * @date 2018/1/19
 */
@Configuration
public class DataBaseConfig {
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
}
