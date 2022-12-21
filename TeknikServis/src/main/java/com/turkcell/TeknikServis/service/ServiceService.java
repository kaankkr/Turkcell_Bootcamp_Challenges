package com.turkcell.TeknikServis.service;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.repo.ServiceRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceService
{
	private ServiceRepo serviceRepo;

	public com.turkcell.TeknikServis.model.Service findById(Long id)
	{
		return serviceRepo.findById(id).get();
	}
}
