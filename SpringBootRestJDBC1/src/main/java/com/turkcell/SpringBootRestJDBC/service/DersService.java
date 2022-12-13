package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Ders;
import com.turkcell.SpringBootRestJDBC.repo.DersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersService
{
	@Autowired
	private DersRepository dersRepository;

	public List<Ders> getAll()
	{
		return dersRepository.getAll();
	}

	/*
	 * public List<DersDTO> getAllDTO() { return repo.getAllDTO(); }
	 */
	
	public Ders getByID(long id)
	{
		return dersRepository.getById(id);
	}

	public boolean save(Ders ders)
	{
		try
		{
			return dersRepository.save(ders);
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
