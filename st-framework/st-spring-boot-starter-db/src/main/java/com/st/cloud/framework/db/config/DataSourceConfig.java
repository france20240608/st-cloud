package com.st.cloud.framework.db.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.st.cloud.framework.db.config.DataSourceContextHolder.DataSourceType.MASTER;
import static com.st.cloud.framework.db.config.DataSourceContextHolder.DataSourceType.SLAVE;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.master.driver-class-name}")
    private String masterDriverClassName;
    @Value("${spring.datasource.master.jdbc-url}")
    private String masterJdbcUrl;
    @Value("${spring.datasource.master.username}")
    private String masterUsername;
    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.slave.driver-class-name}")
    private String slaveDriverClassName;
    @Value("${spring.datasource.slave.jdbc-url}")
    private String slaveJdbcUrl;
    @Value("${spring.datasource.slave.username}")
    private String slaveUsername;
    @Value("${spring.datasource.slave.password}")
    private String slavePassword;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master.hikari")
    public HikariDataSource masterDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(masterJdbcUrl);
        dataSource.setUsername(masterUsername);
        dataSource.setPassword(masterPassword);
        dataSource.setDriverClassName(masterDriverClassName);
        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave.hikari")
    public HikariDataSource slaveDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(slaveJdbcUrl);
        dataSource.setUsername(slaveUsername);
        dataSource.setPassword(slavePassword);
        dataSource.setDriverClassName(slaveDriverClassName);
        return dataSource;
    }

    @Bean
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(MASTER, masterDataSource);
        targetDataSources.put(SLAVE, slaveDataSource);

        AbstractRoutingDataSource routingDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceContextHolder.getDataSourceType();
            }
        };
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);

        return routingDataSource;
    }

    @Primary
    @Bean
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}