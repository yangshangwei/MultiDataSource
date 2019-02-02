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
//  db1的接口类的包名
@MapperScan(basePackages = { "com.artisan.dao.db1" }, sqlSessionFactoryRef = "db1SqlSessionFactoryBean")
public class MybatisDB1Config {

	@Autowired
	// 必须指定注入哪个数据源，否则找到多个会注入失败
	@Qualifier(DataSources.DB1)
	private DataSource db1;
	

	@Bean(name = "db1SqlSessionFactoryBean")
	@ConfigurationProperties(prefix = "mybatis-db1") // 和 配置文件中的前缀保持一致
	public SqlSessionFactoryBean db1SqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 配置数据源
		sqlSessionFactoryBean.setDataSource(db1);
		// 如下的两行代码仅仅用于*.xml文件，如果整个持久层操作没用到xml文件的话，比如使用注解的方式，则无需加
		// 解决配置到配置文件中通过*配置找不到mapper文件的问题。 如果不设置这一行，在配置文件中，只能使用数组的方式一个个的罗列出来，并且要指定具体的文件名
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper_db1/*.xml"));
		// 也可以通过在application.yml中配置
		//sqlSessionFactoryBean.setTypeAliasesPackage("com.artisan.domain.db1");
		return sqlSessionFactoryBean;
	}
	
	// 可选，如果需要通过SqlSessionTemplate来操作持久层就通过@Bean实例化,我们这个例子中没用到，随手写出来了
	@Bean(name="db1SqlSessionTemplate")
	public SqlSessionTemplate db1SqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(db1SqlSessionFactoryBean().getObject());
		return template;
	}

}
