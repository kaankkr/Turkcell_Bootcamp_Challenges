package com.turkcell.TeknikServis.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.SaleLOG;
import com.turkcell.TeknikServis.repo.SaleLogRepo;
import com.turkcell.TeknikServis.repo.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleLogService
{
	private SaleLogRepo saleLogRepo;
	private SaleRepo saleRepo;
	
	private EntityManager em;
	
	public SaleLOG create(SaleLOG log)
	{
		log = saleLogRepo.save(log);
		saleLogRepo.flush();
		em.clear();
		log = saleLogRepo.findById(log.getId()).get();
		log.getSALE().setISSOLD(true);
		saleRepo.save(log.getSALE());
		
		return log;
	}
}
