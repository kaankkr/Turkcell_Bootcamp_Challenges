package com.turkcell.SpringBootRestJDBC.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.SpringBootRestJDBC.model.Konu;

public class KonuRowMapper implements RowMapper<Konu> {

	@Override
	public Konu mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Konu(rs.getLong("id"),rs.getString("name"));
	}

}
