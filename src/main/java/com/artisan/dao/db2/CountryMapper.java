package com.artisan.dao.db2;

import org.apache.ibatis.annotations.Mapper;

import com.artisan.domain.db2.Country;

@Mapper
public interface CountryMapper {
	
	Country selectCountryById(long id);
}
