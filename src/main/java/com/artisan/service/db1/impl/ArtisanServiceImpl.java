package com.artisan.service.db1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artisan.config.DataSources;
import com.artisan.dao.db1.ArtisanDaoByJdbcTemplate;
import com.artisan.dao.db1.ArtisanMapper;
import com.artisan.domain.db1.Artisan;
import com.artisan.service.db1.ArtisanService;

@Service
public class ArtisanServiceImpl implements ArtisanService {
	
	
	@Autowired
	ArtisanMapper artisanMapper;
	
	@Autowired
	ArtisanDaoByJdbcTemplate artisanDaoByJdbcTemplate;
	
	@Override
	public Artisan getArtisanById(long id) {
		return artisanMapper.selectArtisanById(id);
	}

	@Override
	public void jdbcTemplateTest() {
		artisanDaoByJdbcTemplate.addArtisan("小铁匠");
	}
	
	/**
	 * 不加@Transactional(DataSources.DB1_TRANSACTION) ,回滚失败
	 */
	@Override
	@Transactional(DataSources.DB1_TRANSACTION)
	public void transTest() {
		
		// jdbcTemplate作为持久层
//		artisanDaoByJdbcTemplate.addArtisan("粉刷匠");
//		artisanDaoByJdbcTemplate.updateArtisan("小铜匠", 1);
		
		
		
		// mybatis作为持久层
		Artisan artisan = new Artisan();
		artisan.setName("MB-Name");
		
		artisanMapper.insertArtisan(artisan);
		
		artisan = new Artisan();
		artisan.setName("修改后的名字");
		artisan.setId(1L);
		
		artisanMapper.updateArtisan(artisan);
	}
	
	
	
	
	

}
