package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;
import com.turkcell.SpringBootHibernateJPA.repo.OgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgrenciService {

	
	private OgrenciRepository repo;
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public List<Ogrenci> getAll()
	{
		logger.info("Ogrenci getall yapılıyor");
		List<Ogrenci> list = repo.findAll();
		logger.debug("Ogrenciler size = " + list.size());
		return list;
	}

	public Ogrenci getByID(long id)
	{
		return repo.findById(id).orElse(null);
	}

	public boolean delete(Long id)
	{
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Ogrenci save(Ogrenci ogrenci)
	{
		try
		{
			return repo.save(ogrenci);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}
/*
	public List<Ogretmen> findNameLike(String expression)
	{
		// select * from obsh.ogretmen where NAME like '%an%'
		// 1 tane bulmak içinm findByNAME olabilirdi
		// return repo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
		// return repo.findAllByNAMELikeOrderByNAMEAsc("%" + expression + "%");
		// return repo.findByNAMELike("%" + expression + "%");
		return repo.searchByName(expression);
	}	*/
}
