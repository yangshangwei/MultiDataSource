package com.artisan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DatasourceConfig {
	
	//destroy-method="close"：当数据库连接不使用的时候,将该连接重新放到数据池中
    @Bean(name=DataSources.DB1,destroyMethod="close")
    @ConfigurationProperties(prefix = "spring.datasource-db1")
    public DataSource dataSourceDB1() {
    	// 创建数据源
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name=DataSources.DB2,destroyMethod="close")
    @ConfigurationProperties(prefix = "spring.datasource-db2")
    public DataSource dataSourceDB2() {
    	// 创建数据源
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
    
    // 支持JdbcTemplate （可选）
    @Bean(DataSources.DB1_JDBCTEMPLATE)
    public JdbcTemplate db1JdbcTemplate(
            @Qualifier(DataSources.DB1) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(DataSources.DB2_JDBCTEMPLATE)
    public JdbcTemplate db2JdbcTemplate(
            @Qualifier(DataSources.DB2) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    // 支持事务（可选）
    @Bean(DataSources.DB1_TRANSACTION)
    public DataSourceTransactionManager db1TransactionManager(
            @Qualifier(DataSources.DB1) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(DataSources.DB2_TRANSACTION)
    public DataSourceTransactionManager db2TransactionManager(
            @Qualifier(DataSources.DB2) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    

}
