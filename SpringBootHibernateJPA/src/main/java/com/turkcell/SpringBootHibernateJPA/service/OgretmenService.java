package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.OgretmenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgretmenService
{
	private OgretmenRepository repo;
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public List<Ogretmen> getAll()
	{
		logger.info("Ogretmen getall yapılıyor");
		List<Ogretmen> ogretmenler = repo.findAll();
		logger.debug("ogretmenler size = " + ogretmenler.size());
		return ogretmenler;
	}

	public Ogretmen getByID(long id)
	{
		// optional özellikleri kullanılabilir
		return repo.findById(id).orElse(null);
	}

	public boolean delete(Long id)
	{
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Ogretmen save(Ogretmen ogretmen)
	{
		try
		{
			return repo.save(ogretmen);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}

	public List<Ogretmen> findNameLike(String expression)
	{
		// select * from obsh.ogretmen where NAME like '%an%'
		// 1 tane bulmak içinm findByNAME olabilirdi
		// return repo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
		// return repo.findAllByNAMELikeOrderByNAMEAsc("%" + expression + "%");
		// return repo.findByNAMELike("%" + expression + "%");
		return repo.searchByName(expression);
	}
}
