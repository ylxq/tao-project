package com.cn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置的两种方式
 *
 * @author tao_wc
 * @date 2018/1/18
 */

@Configuration
public class DataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);


    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource primaryDataSource() {
        log.info("-------------------- primaryDataSource init ---------------------");
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring-secondary.datasource")
    public DataSource secondaryDataSource() {
        log.info("-------------------- secondaryDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }

}
