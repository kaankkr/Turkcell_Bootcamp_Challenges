package com.turkcell.SpringBootRestJDBC.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;

public class OgrenciRowMapper implements RowMapper<Ogrenci> {

	@Override
	public Ogrenci mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Ogrenci(rs.getLong(1) , rs.getString("name") , rs.getLong("ogrnumber") , rs.getLong("year"));
	}

}
