package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.DersDTO;
import com.turkcell.SpringBootHibernateJPA.repo.DersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@lombok.extern.slf4j.Slf4j(topic = "DersServiceLog")
public class DersService
{
	private DersRepository repo;

	public List<Ders> getAll()
	{
		log.info("dersgetall yapılıyor");
		List<Ders> liste = repo.findAll();
		if (liste.size() > 1)
		{
			throw new NullPointerException("mesaj mesaj");
		}
		return liste;
	}

	public Ders getById(Long id)
	{
		return repo.findById(id).get();
	}


	public Ders save(Ders ders)
	{
		return repo.save(ders);
	}

	public Ders update(Ders ders)
	{
		return repo.save(ders);
	}

	public boolean delete(Long id)
	{
		try
		{
			repo.deleteById(id);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}

