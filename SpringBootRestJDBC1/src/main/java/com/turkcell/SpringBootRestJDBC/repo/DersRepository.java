package com.turkcell.SpringBootRestJDBC.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.Ders;
import com.turkcell.SpringBootRestJDBC.rowmapper.DersRowMapper;

import lombok.AllArgsConstructor;


@Repository
@AllArgsConstructor
public class DersRepository
{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Ders> getAll()
	{
		List<Ders> liste;
		String sql = "select * from obsh.ders";
		
		liste = namedParameterJdbcTemplate.query(sql, new DersRowMapper());
		return liste;
	}

	public Ders getById(long ID)
	{
		String sql = "select * from obsh.ders where (id)=:id";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", ID);
		
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new DersRowMapper());
	}


	
	public List<Ders> getByTeacherId(long ID) {
		String sql = "select * from obsh.ders where (ogretmen_id)=:ogretmen_id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ogretmen_id", ID);
		
		List<Ders> list = namedParameterJdbcTemplate.query(sql,paramMap, new DersRowMapper());
		return list;
	}

	public boolean save(Ders ders)
	{
		String sql = "insert into obsh.ders (konu_id,ogretmen_id) values (:konu_id,:ogretmen_id)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("OGR_ID", ders.getOGR_ID());
		paramMap.put("KONU_ID", ders.getKONU_ID());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean delete(long ID) {
		String sql = "delete from obsh.ders where id = :id";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", ID);
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	/*
	 * public List<DersDTO> getAllDTO() { List<DersDTO> liste; String sql =
	 * "SELECT DRS.\"id\", OGR.\"name\" AS OGRETMEN_ADI, KN.\"name\" AS DERS_KONUSU "
	 * + "FROM obsh.ders AS DRS " +
	 * "INNER JOIN obsh.OGRETMEN AS OGR ON OGR.\"id\" = DRS.\"ogretmen_id\" " +
	 * "INNER JOIN obsh.KONU AS KN ON KN.\"id\" = DRS.\"konu_id\"";
	 * RowMapper<DersDTO> row_mapper = new RowMapper<DersDTO>() {
	 * 
	 * @Override public DersDTO mapRow(ResultSet result, int rowNum) throws
	 * SQLException { // Ogretmen o; // Konu k; return new
	 * DersDTO(result.getLong("id"), result.getString("OGRETMEN_ADI"),
	 * result.getString("DERS_KONUSU")); } }; liste = jdbcTemplate.query(sql,
	 * row_mapper); return liste; }
	 * 
	 */
}