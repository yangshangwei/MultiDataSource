package com.artisan.config;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = { "com.artisan.dao.db2" },sqlSessionFactoryRef="db2SqlSessionFactoryBean" ) // 扫描的mybatis接口类的包名
public class MybatisDB2Config {

	@Autowired
	// 必须指定注入哪个数据源，否则找到多个会注入失败
	@Qualifier(DataSources.DB2)
	private DataSource db2;

	@Bean(name="db2SqlSessionFactoryBean")
	@ConfigurationProperties(prefix = "mybatis-db2") // 和 配置文件中的前缀保持一致
	public SqlSessionFactoryBean db2SqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 配置数据源
		sqlSessionFactoryBean.setDataSource(db2);
		// 解决配置到配置文件中通过*配置找不到mapper文件的问题。 如果不设置这一行，在配置文件中，只能使用数组的方式一个个的罗列出来，并且要指定具体的文件名
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper_db2/*.xml"));
		return sqlSessionFactoryBean;
	}
	
	
	// 可选，如果需要通过SqlSessionTemplate来操作持久层就通过@Bean实例化,我们这个例子中没用到，随手写出来了
	@Bean(name = "db2SqlSessionTemplate")
	public SqlSessionTemplate db2SqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(db2SqlSessionFactoryBean().getObject());
		return template;
	}

}
