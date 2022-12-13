package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;
import com.turkcell.SpringBootRestJDBC.repo.DersOgrenciRepository;

@Service
public class DersOgrenciService {

	
	@Autowired
	private DersOgrenciRepository dersOgrenciRepository;

	
	public List<DersOgrenci> getAll() {
		List<DersOgrenci> list = dersOgrenciRepository.getAll();
	
		return list;
	}


	public boolean save(DersOgrenci dersOgrenci)  {
		
		if (dersOgrenciRepository.save(dersOgrenci)) {
			return true;
		} 
		else {
			return false;
		}

	}
	
	
	public boolean update(DersOgrenci dersOgrenci) {
		
		/*
		if(!isExistById(dersOgrenci.getID())) 
		{
			throw new Exception("Bu id ile DersOgrenci yok : " + dersOgrenci.getID());			
		}
		
		else if(!isExistedCourse(dersOgrenci.getDers_id())) {
			throw new Exception("Bu id ile bir ders yok : " + dersOgrenci.getDers_id());
		}
		else if(!isExistedStudent(dersOgrenci.getOgrenci_id())) 
		{
			throw new Exception("Bu id ile öğrenci yok : " + dersOgrenci.getOgrenci_id());
		}
		*/
		if(dersOgrenciRepository.update(dersOgrenci)) 
		{
			return true;
		}
		else 
		{
			return false;
		}

	}

	
	public boolean delete(long ID)  {
		
		if(dersOgrenciRepository.delete(ID)) {
			return true;
		}else {
			return false;
		}
	}

	
	public DersOgrenci getById(long ID)  {
		
		DersOgrenci list = dersOgrenciRepository.getById(ID);
	
		return list;

	}
	
	
	public List<DersOgrenci> getByCourse(long DERS_ID)  {
		
		
		List<DersOgrenci> list = dersOgrenciRepository.getByCourse(DERS_ID);
		
	
		return list;
	}

	
	public List<DersOgrenci> getByStudent(long OGRENCI_ID) {
		
		List<DersOgrenci> list = dersOgrenciRepository.getByStudent(OGRENCI_ID);
	
		return list;
	}
/*
	private boolean isExistById(long ID) {
		if(dersOgrenciRepository.getById(ID) != null) {
			return true;
		}
		else {
			return false;
		}

	}

	private boolean isExistedStudent(long OGRENCI_ID) {

		return ogrenciService.getById(OGRENCI_ID) != null;
	}

	private boolean isExistedCourse(long DERS_ID) {

		return dersService.getByID(DERS_ID) != null;
	}
*/

}
