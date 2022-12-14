package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.repo.KonuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KonuService {


	
	private KonuRepository repo;
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public List<Konu> getAll()
	{
		logger.info("Konu getall yapılıyor");
		List<Konu> list = repo.findAll();
		logger.debug("Konular size = " + list.size());
		return list;
	}

	public Konu getByID(long id)
	{
		return repo.findById(id).orElse(null);
	}

	public boolean delete(Long id)
	{
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Konu save(Konu konu)
	{
		try
		{
			return repo.save(konu);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}
	/*
	public List<Konu> findNameLike(String expression)
	{
		// select * from obsh.ogretmen where NAME like '%an%'
		// 1 tane bulmak içinm findByNAME olabilirdi
		// return repo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
		// return repo.findAllByNAMELikeOrderByNAMEAsc("%" + expression + "%");
		// return repo.findByNAMELike("%" + expression + "%");
		return repo.searchByName(expression);
	}	*/
}
