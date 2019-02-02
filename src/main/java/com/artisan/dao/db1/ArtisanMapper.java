package com.artisan.dao.db1;

import org.apache.ibatis.annotations.Mapper;

import com.artisan.domain.db1.Artisan;


@Mapper
public interface ArtisanMapper {
	
	Artisan selectArtisanById(long id);
}
