package com.turkcell.SpringBootRestJDBC.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.Ogretmen;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class OgretmenRepository
{
	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Ogretmen> getAll()
	{
		List<Ogretmen> liste;
		String sql = "SELECT * FROM \"obsh\".\"ogretmen\"";
		RowMapper<Ogretmen> row_mapper = new RowMapper<Ogretmen>()
		{
			@Override
			public Ogretmen mapRow(ResultSet result, int rowNum) throws SQLException
			{
				// spring framework olmayan jdbc kodlarında olurdu
				//while (result.next())
				//{
				// result.getLong(1) .... gibi
				//}
				return new Ogretmen(result.getLong(1), result.getString("NAME"), result.getBoolean("isgicik"));
			}
		};
		liste = jdbcTemplate.query(sql, row_mapper);
		// return jdbcTemplate.queryForList("SELECT * FROM \"OBS\".\"OGRETMEN\"");
		return liste;
	}

	public Ogretmen getById(long id)
	{
		// :ID bir parametredir
		String sql = "SELECT * FROM \"obsh\".\"ogretmen\" WHERE \"id\" = :ID";
		RowMapper<Ogretmen> row_mapper = new RowMapper<Ogretmen>()
		{
			@Override
			public Ogretmen mapRow(ResultSet result, int rowNum) throws SQLException
			{
				return new Ogretmen(result.getLong(1), result.getString("name"), result.getBoolean("isgicik"));
			}
		};
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// :ID  olan yere id parametresini koyabilmek için bir map olusturduk
		//ve bu parametrik çalışmayı sağlayabilmek için 
		//namedparameterJdbcTemplate.queryForObject methodunu kullandık.
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, row_mapper);
		
	}

	public boolean save(Ogretmen ogretmen)
	{
		String sql = "INSERT INTO \"obsh\".\"ogretmen\"(\"name\", \"isgicik\") VALUES (:NAME, :IS_GICIK)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("NAME", ogretmen.getNAME());
		paramMap.put("IS_GICIK", ogretmen.isIS_GICIK());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
}