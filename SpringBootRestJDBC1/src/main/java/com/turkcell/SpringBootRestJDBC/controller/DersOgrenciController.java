package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;
import com.turkcell.SpringBootRestJDBC.service.DersOgrenciService;

@RestController
@RequestMapping(path = "/dersOgrenci")
public class DersOgrenciController {

	
	
	@Autowired
	private DersOgrenciService dersOgrenciService;
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<DersOgrenci>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(dersOgrenciService.getAll());
	}
	
	
	@GetMapping(path = "/getById/{ID}")
	public ResponseEntity<DersOgrenci> getById(@PathVariable long ID)  {
	 
			
		return ResponseEntity.status(HttpStatus.OK).body(dersOgrenciService.getById(ID));
		
		
		
	}
	
	@GetMapping(path = "/getByDers/{DERS_ID}")
	public ResponseEntity<List<DersOgrenci>> getByCourse(@PathVariable long DERS_ID){
		return ResponseEntity.status(HttpStatus.OK).body(dersOgrenciService.getByCourse(DERS_ID));
	}
	
	@GetMapping(path = "/getByOgrenci/{OGRENCI_ID}")
	public ResponseEntity<List<DersOgrenci>> getByStudent(@PathVariable long OGRENCI_ID){
		return ResponseEntity.status(HttpStatus.OK).body(dersOgrenciService.getByStudent(OGRENCI_ID));
	}
	
	
	@PostMapping(path = "/save")
	public ResponseEntity<String> save(@RequestBody DersOgrenci dersOgrenci) {
		if(dersOgrenciService.save(dersOgrenci)) {
			
			return ResponseEntity.status(HttpStatus.OK).body("Başarılı");			

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Başarsoızsdı");			

		}
	}
	@DeleteMapping(path = "/delete/{ID}")
	public ResponseEntity<String> delete(@PathVariable int ID){
		
		if(dersOgrenciService.delete(ID)) {
			
			return ResponseEntity.status(HttpStatus.OK).body("Başarılı");			

		}
		
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Başarsoızsdı");			

		}
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<String> update(@RequestBody DersOgrenci dersOgrenci){
		
		
		if(dersOgrenciService.update(dersOgrenci)) {
			
			return ResponseEntity.status(HttpStatus.OK).body("update basarılı");
		}
		
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("update basarısız");			

		}
	}
}
