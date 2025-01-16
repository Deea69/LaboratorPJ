package com.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class MasinaMapper implements RowMapper<Masina> {

	@Override
	public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Masina(rs.getString("nr_inm"), rs.getString("marca")
				, rs.getString("culoare"), rs.getInt("anul_fab"), rs.getInt("nr_km"));
	}

	
}
