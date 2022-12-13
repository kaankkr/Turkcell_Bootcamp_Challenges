package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;
import com.turkcell.SpringBootRestJDBC.service.OgrenciService;

@RestController
@RequestMapping(path = "/ogrenci")
public class OgrenciController {


	@Autowired
	private OgrenciService ogrenciService;

	@GetMapping(path = "/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogrenci> getAll() {
		
		return ogrenciService.getAll();
	}

	@GetMapping(path = "/getById/{ID}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getById(@PathVariable long ID) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ogrenciService.getById(ID));
	}
	
	@GetMapping(path = "/getByStudentNumber/{Ogrenci_NO}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByStudentNumber(@PathVariable long Ogrenci_NO) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ogrenciService.getByStudentNumber(Ogrenci_NO));
	}

	

	@PostMapping(path = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogrenci ogrenci) {
		
		if(ogrenciService.save(ogrenci)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Ogrenci basarıyla kaydedildi");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ogrenci kaydedilemedi");

		}

	}

	@DeleteMapping(path = "/delete/{ID}")
	public ResponseEntity<String> delete(@PathVariable int ID) {
		
		if(ogrenciService.delete(ID)) {
			return ResponseEntity.status(HttpStatus.OK).body("Ogrenci basarıyla silindi");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ogrenci silinemedi");

		}

	}

}
