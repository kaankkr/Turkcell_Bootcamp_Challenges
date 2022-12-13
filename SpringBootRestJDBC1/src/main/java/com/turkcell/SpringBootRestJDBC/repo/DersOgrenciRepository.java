package com.turkcell.SpringBootRestJDBC.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;
import com.turkcell.SpringBootRestJDBC.rowmapper.DersOgrenciRowMapper;

@Repository
public class DersOgrenciRepository  {

	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	
	public List<DersOgrenci> getAll() {
		
		List<DersOgrenci> list;
		
		String sql = "select * from obsh.ders_ogrenci";
		
		list = namedParameterJdbcTemplate.query(sql, new DersOgrenciRowMapper());
		
		return list;
		
	}
	
	  public List<DersOgrenci> getByCourse(long DERS_ID) { 
		  
		  List<DersOgrenci> list;
		  
		  String sql = "select * from obsh.ders_ogrenci where (ders_id)=:ders_id";
		  
		  Map<String, Object> paramMap = new HashMap<>(); paramMap.put("ders_id", DERS_ID);
	  
		  list = namedParameterJdbcTemplate.query(sql,paramMap, new DersOgrenciRowMapper());
	  
		  return list; 
		  
	  }
	  
	  
	  public List<DersOgrenci> getByStudent(long OGRENCI_ID) { 
		  
		  List<DersOgrenci> list;
		 
		  String sql = "select * from obsh.ders_ogrenci where (ogrenci_id)=:ogrenci_id";
		 
		  Map<String,Object> paramMap = new HashMap<>(); paramMap.put("ogrenci_id", OGRENCI_ID);
		  
		  list =  namedParameterJdbcTemplate.query(sql,paramMap, new DersOgrenciRowMapper());
		  
		  return list;
	  
	  }
	  
	
	public boolean save(DersOgrenci dersOgrenci) {
		String sql = "insert into obsh.ders_ogrenci (devamsizlik,note,ders_id,ogrenci_id) values (:devamsizlik,:note,:ders_id,:ogrenci_id)";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("devamsizlik", dersOgrenci.getDEVAMSIZLIK());
		paramMap.put("note", dersOgrenci.getNOTE());
		paramMap.put("ders_id", dersOgrenci.getDers_id());
		paramMap.put("ogrenci_id", dersOgrenci.getOgrenci_id());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	
	public boolean update(DersOgrenci dersOgrenci) {
		String sql = "update obsh.ders_ogrenci set (devamsizlik,note,ders_id,ogrenci_id) = (:devamsizlik,:note,:ders_id,:ogrenci_id) where id = :id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", dersOgrenci.getID());
		paramMap.put("devamsizlik", dersOgrenci.getDEVAMSIZLIK());
		paramMap.put("note", dersOgrenci.getNOTE());
		paramMap.put("ders_id", dersOgrenci.getDers_id());
		paramMap.put("ogrenci_id", dersOgrenci.getOgrenci_id());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
		
	}

	
	public boolean delete(long ID) {
		String sql = "delete from obsh.ders_ogrenci where id = :id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	
	  public DersOgrenci getById(long ID) {
		  String sql = "select * from obsh.ders_ogrenci where (id)=:id"; 
		 
		  Map<String, Object> paramMap = new HashMap<>(); 
		  
		  paramMap.put("id", ID); 

		  DersOgrenci dersOgrenci =  namedParameterJdbcTemplate.queryForObject(sql, paramMap, new DersOgrenciRowMapper()); 
	  
	  
		  return dersOgrenci; 

	  }
	  
	  

  public boolean isExists(DersOgrenci dersOgrenci) 
  { 
	  String sql = "select * from obsh.ders_ogrenci where (ders_id,ogrenci_id)=(:ders_id,:ogrenci_id)";
	  Map<String, Object> paramMap = new HashMap<>(); paramMap.put("ders_id", dersOgrenci.getDers_id());
	  
	  paramMap.put("ogrenci_id", dersOgrenci.getOgrenci_id());
  
  
	  if(!namedParameterJdbcTemplate.query(sql, paramMap,new DersOgrenciRowMapper()).isEmpty())
	  { 
		  return true;
	  }
	  else 
	  { 
		  return false; 
	  }
	  
  }
 
 
	

	  
	 
}

