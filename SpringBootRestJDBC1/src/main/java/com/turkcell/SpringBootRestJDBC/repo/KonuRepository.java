package com.turkcell.SpringBootRestJDBC.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.Konu;
import com.turkcell.SpringBootRestJDBC.rowmapper.KonuRowMapper;

import lombok.AllArgsConstructor;



@Repository
@AllArgsConstructor
public class KonuRepository {

	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	public List<Konu> getAll() {
		String sql = "select * from obsh.konu";
		List<Konu> list;
		
		list = namedParameterJdbcTemplate.query(sql, new KonuRowMapper());
		
		return list;
	}

	
	public Konu getById(long ID) {
		String sql = "select * from obsh.konu where (id)=:id";
		Konu konu;
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		konu = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new KonuRowMapper());
		
		return konu;
		
	}
	
	
	
	public boolean save(Konu Konu) {
		String sql = "insert into obsh.konu (name) values (:name)";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", Konu.getNAME());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}


	
	public boolean delete(long ID) {
		String sql = "delete from obsh.konu where id = :id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

}