package com.artisan.service.db1;

import com.artisan.domain.db1.Artisan;

public interface ArtisanService {
	
	Artisan getArtisanById(long id);

	void jdbcTemplateTest();

	void transTest();

}
