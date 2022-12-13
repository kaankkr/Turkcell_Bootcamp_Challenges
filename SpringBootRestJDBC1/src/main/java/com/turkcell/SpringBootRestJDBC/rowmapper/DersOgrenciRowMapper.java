package com.turkcell.SpringBootRestJDBC.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;

public class DersOgrenciRowMapper implements RowMapper<DersOgrenci>{

	@Override
	public DersOgrenci mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new DersOgrenci(rs.getLong(1), rs.getInt("devamsizlik"), rs.getLong("note"), rs.getLong("ders_id"), rs.getLong("ogrenci_id"));
	}

}
