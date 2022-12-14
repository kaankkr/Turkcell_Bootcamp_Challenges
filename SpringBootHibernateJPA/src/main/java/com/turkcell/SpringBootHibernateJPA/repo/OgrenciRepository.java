package com.turkcell.SpringBootHibernateJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci , Long> {

}
