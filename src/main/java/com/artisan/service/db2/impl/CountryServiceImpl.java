package com.artisan.service.db2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artisan.dao.db2.CountryMapper;
import com.artisan.domain.db2.Country;
import com.artisan.service.db2.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryMapper countryMapper;
	
	@Override
	public Country getCountryById(long id) {
		return countryMapper.selectCountryById(id);
	}

}
