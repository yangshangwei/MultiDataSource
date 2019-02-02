package com.artisan.config;

/**
 *   数据源列表
 * @author yangshangwei
 *
 */
public interface DataSources {
	
	String DB1 = "db1";
    String DB2 = "db2";
    
    String DB1_JDBCTEMPLATE = "db1JdbcTemplate";
    String DB2_JDBCTEMPLATE = "db2JdbcTemplate";
    
    String DB1_TRANSACTION = "db1TransactionManager";
    String DB2_TRANSACTION = "db2TransactionManager";
}
