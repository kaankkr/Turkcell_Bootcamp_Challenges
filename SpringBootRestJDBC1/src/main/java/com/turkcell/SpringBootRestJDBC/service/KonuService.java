package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Konu;
import com.turkcell.SpringBootRestJDBC.repo.KonuRepository;

@Service
public class KonuService  {

	@Autowired
	private KonuRepository konuRepository;

	
	public List<Konu> getAll() {

		List<Konu> list = konuRepository.getAll();
		
		return list;
	}

	
	public Konu getById(long ID) {
		
		Konu konu = konuRepository.getById(ID);
	
		return konu;
	}

	public boolean save(Konu konu) {
		
		try
		{
			return konuRepository.save(konu);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}


	
	public boolean delete(long ID) {
		
		try
		{
			return konuRepository.delete(ID);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}

	
	

}