package com.artisan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artisan.domain.db1.Artisan;
import com.artisan.domain.db2.Country;
import com.artisan.service.db1.ArtisanService;
import com.artisan.service.db2.CountryService;

@RestController
public class MultiDataSourceController {
	
	@Autowired
	ArtisanService artisanService;
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/db1")
	public Artisan getArtisanById(long id ) {
		return artisanService.getArtisanById(id);
	}
	
	@GetMapping("/db2")
	public Country getCountryById(long id ) {
		return countryService.getCountryById(id);
	}
	
	@GetMapping("/db1/jdbcTemplateTest")
	public void testJdbcTemplateTest() {
		artisanService.jdbcTemplateTest();
	}
	
	@GetMapping("/db1/transTest")
	public void testTrans() {
		artisanService.transTest();
	}

}
