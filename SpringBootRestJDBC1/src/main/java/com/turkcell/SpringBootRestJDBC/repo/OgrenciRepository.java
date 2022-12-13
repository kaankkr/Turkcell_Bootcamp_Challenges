package com.turkcell.SpringBootRestJDBC.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;
import com.turkcell.SpringBootRestJDBC.rowmapper.OgrenciRowMapper;

@Repository
public class OgrenciRepository {

	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	

	
	public List<Ogrenci> getAll() {
		String sql = "select * from obsh.ogrenci";
		List<Ogrenci> list = namedParameterJdbcTemplate.query(sql, new OgrenciRowMapper());
		return list;
	}

	public Ogrenci getById(long ID) {
		String sql = "select * from obsh.ogrenci where (id)=:id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		Ogrenci ogrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new OgrenciRowMapper());
		return ogrenci;
		
		/*
		try {
			Ogrenci ogrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new OgrenciRowMapper());
			return ogrenci;
		} catch (Exception e) {
			return null;
		}
		*/
	}

	
	public Ogrenci getByStudentNumber(long Ogrenci_NO) {
		String sql = "select * from obsh.ogrenci where (ogrnumber)=:ogrnumber";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ogrnumber", Ogrenci_NO);
		
		Ogrenci ogrenci =  namedParameterJdbcTemplate.queryForObject(sql, paramMap, new OgrenciRowMapper());
		return ogrenci;
		/*
		try {
			Ogrenci ogrenci =  namedParameterJdbcTemplate.queryForObject(sql, paramMap, new OgrenciRowMapper());
			return ogrenci;
		} 
		catch (Exception e) {
			return null;
		}
		*/
	}



	
	public boolean save(Ogrenci ogrenci) {
		String sql = "insert into obsh.ogrenci (name,ogrnumber,year) values (:name,:ogrnumber,:year)";
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("name", ogrenci.getNAME());
		paramMap.put("ogrnumber", ogrenci.getOGRNUMBER());
		paramMap.put("year", ogrenci.getYEAR());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}


	
	public boolean delete(long ID) {
		String sql = "delete from obsh.ogrenci where id = :id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	
}
