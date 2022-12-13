package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;
import com.turkcell.SpringBootRestJDBC.repo.OgrenciRepository;

@Service
public class OgrenciService {

	
	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	

	
	public List<Ogrenci> getAll() {
		
		List<Ogrenci> list = ogrenciRepository.getAll();
	
		return list;
	}

	
	public Ogrenci getById(long ID) {
		
		Ogrenci ogrenci = ogrenciRepository.getById(ID);

		return ogrenci;
	}

	
	public Ogrenci getByStudentNumber(long OGRNUMBER) {
		
		Ogrenci ogrenci = ogrenciRepository.getByStudentNumber(OGRNUMBER);		

	
		return ogrenci;
	}	
	
	
	public boolean save(Ogrenci ogrenci) {
		if (isExistByStudentNumber(ogrenci.getOGRNUMBER())) {
			return false;
		}
		else if (ogrenciRepository.save(ogrenci)) {
			return true;
		} else {
			return false;
		}

	}


	
	public boolean delete(long ID) {
		
		if (ogrenciRepository.delete(ID)) {
			return true;
		} else {
			return false;
		}
	}

	

	
	private boolean isExistById(long ID) {

		return ogrenciRepository.getById(ID) != null;
	}


	private boolean isExistByStudentNumber(long OGRNUMBER) {

		return ogrenciRepository.getByStudentNumber(OGRNUMBER) != null;
	}

	

}
