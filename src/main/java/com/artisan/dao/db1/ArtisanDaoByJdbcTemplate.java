package com.artisan.dao.db1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.artisan.config.DataSources;

@Repository
public class ArtisanDaoByJdbcTemplate {
	
	@Autowired
	// 多个数据源，必须指定注入哪个，否则注入失败
	@Qualifier(DataSources.DB1_JDBCTEMPLATE)
	JdbcTemplate jdbcTemplate;
	
	
	public void addArtisan(String name) {
		String sql = "insert into db1_artisan(name) values(?)" ;
		jdbcTemplate.update(sql,new Object[] {name});
	}
	
	
	// 故意写错字段名，测试事务回滚
	public void updateArtisan(String name ,int id) {
		String sql = "update db1_artisan set name1 = ? where id = ?" ;
		jdbcTemplate.update(sql,new Object[] {name,id});
	}
}
