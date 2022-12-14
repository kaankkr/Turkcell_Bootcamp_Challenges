package com.turkcell.SpringBootHibernateJPA.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.OgretmenRepository;

import lombok.AllArgsConstructor;

//@Component
@AllArgsConstructor
public class TestComponent
{
	private OgretmenRepository ogretmenRepo;
	
//	private KonuRepo konuRepo;
//	
//	private DersRepo dersRepo;

	@javax.annotation.PostConstruct
	public void test()
	{
		// ogretmenRepo.deleteAll();
		Ogretmen ogretmen = new Ogretmen("numan", false);
		ogretmenRepo.save(ogretmen);
		Ogretmen ogretmen2 = new Ogretmen("tuba", true);
		ogretmenRepo.save(ogretmen2);
		
//		Konu konu = new Konu("Java");
//		konuRepo.save(konu);
//		
//		Konu konu2 = new Konu("C++");
//		konuRepo.save(konu2);
//		
//		Konu konu3 = new Konu("C#");
//		konuRepo.save(konu3);
//		
//		Ders ders = new Ders(ogretmen,konu);
//		dersRepo.save(ders);
//		
//		Ders ders2 = new Ders(ogretmen,konu3);
//		dersRepo.save(ders2);
//		
//		Ders ders3 = new Ders(ogretmen2,konu);
//		dersRepo.save(ders3);
//		
//		Ders ders4 = new Ders(ogretmen2,konu2);
//		dersRepo.save(ders4);
	}
}