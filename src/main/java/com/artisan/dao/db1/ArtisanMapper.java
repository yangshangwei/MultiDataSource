package com.artisan.dao.db1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.artisan.domain.db1.Artisan;


@Mapper
public interface ArtisanMapper {
	
	Artisan selectArtisanById(long id);
	
	int insertArtisan(Artisan artisan);
	
	// 故意写错字段名，测试事务回滚
	@Update({"update db1_artisan set name1 = #{name} where id = #{id}"})
	int updateArtisan(Artisan artisan);
}
