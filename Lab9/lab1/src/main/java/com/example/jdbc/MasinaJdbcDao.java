package com.example.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MasinaJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Masina> findAll(){
		String sql = "select * from masini";
		return (List<Masina>) jdbcTemplate.queryForObject(sql, new MasinaMapper());
	}
}
