package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.dto.OgretmenDTO;
import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.DersRepository;
import com.turkcell.SpringBootHibernateJPA.repo.OgretmenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgretmenDTOService // extends OgretmenService
{
	private OgretmenRepository repo;
	private DersRepository dersRepo;
	
	public OgretmenDTO getByID(long id)
	{
		Ogretmen ogr = repo.findById(id).get();
		List<Ders> dersler = dersRepo.findAllByogretmen_ID(id);
		OgretmenDTO ogretmenDTO = new OgretmenDTO(ogr.getNAME(), ogr.isISGICIK(), dersler);
		return ogretmenDTO;
	}
}