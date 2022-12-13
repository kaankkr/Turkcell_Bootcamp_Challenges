package com.turkcell.SpringBootRestJDBC.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.SpringBootRestJDBC.model.Ders;

public class DersRowMapper implements RowMapper<Ders>{

	@Override
	public Ders mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Ders(rs.getLong(1), rs.getLong("ogretmen_id"), rs.getLong("konu_id"));
	}
}
