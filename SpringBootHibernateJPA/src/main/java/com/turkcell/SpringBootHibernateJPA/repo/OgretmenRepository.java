package com.turkcell.SpringBootHibernateJPA.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;

public interface OgretmenRepository extends JpaRepository<Ogretmen, Long>
{
	// derived query
	
	public List<Ogretmen> findAllByNAMELike(String name, Sort sort);

	public List<Ogretmen> findAllByNAMELikeOrderByNAMEAsc(String name);

	public List<Ogretmen> findByNAMELike(String name);
	
	// yanlış query yazarak strack trace 'e bakılabilir
	@Query(name = "findByOgretmenName", value = "SELECT * FROM obsh.ogretmen WHERE NAME LIKE %:NAME% order by NAME asc", nativeQuery = true)
	public List<Ogretmen> searchByName(@Param("NAME") String name);
} 