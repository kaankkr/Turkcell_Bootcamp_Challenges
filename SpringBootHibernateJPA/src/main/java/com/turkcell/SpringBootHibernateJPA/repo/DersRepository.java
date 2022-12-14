package com.turkcell.SpringBootHibernateJPA.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootHibernateJPA.model.Ders;

public interface DersRepository extends JpaRepository<Ders,Long>
{
	public List<Ders> findAllByogretmen_ID(long id);
}