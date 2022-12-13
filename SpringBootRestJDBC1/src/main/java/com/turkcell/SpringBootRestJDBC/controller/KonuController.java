package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Konu;
import com.turkcell.SpringBootRestJDBC.service.KonuService;

@RestController
@RequestMapping("/konu")
public class KonuController {

	
	@Autowired
	private KonuService konuService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Konu>> getAll(){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(konuService.getAll());
	}
	
	@GetMapping("/getById/{ID}" )
	public ResponseEntity<Konu> getById(@PathVariable long ID) {
		
		return ResponseEntity.status(HttpStatus.OK).body(konuService.getById(ID));
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Konu konu) {
		
		if (konuService.save(konu)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Subject "+konu.getNAME()+" is saved in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Subject could not be saved.");
		}
	}
	
//	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<String> delete(@PathVariable int ID){
		
		if(konuService.delete(ID)) {
			return ResponseEntity.ok("Subject is deleted.");
		}else {
			return ResponseEntity.internalServerError().body("Could not delete the subject.");
		}
		
	}
	


}
