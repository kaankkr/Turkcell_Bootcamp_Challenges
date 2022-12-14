package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.DersOgrenci;
import com.turkcell.SpringBootHibernateJPA.repo.DersOgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersOgrenciService {


	
	private DersOgrenciRepository repo;
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public List<DersOgrenci> getAll()
	{
		logger.info("DersOgrenci getall yapılıyor");
		List<DersOgrenci> list = repo.findAll();
		logger.debug("DersOgrenci'ler size = " + list.size());
		return list;
	}

	public DersOgrenci getByID(long id)
	{
		return repo.findById(id).orElse(null);
	}

	public boolean delete(Long id)
	{
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public DersOgrenci save(DersOgrenci dersOgrenci)
	{
		try
		{
			return repo.save(dersOgrenci);
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
