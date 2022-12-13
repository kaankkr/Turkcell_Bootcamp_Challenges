package com.turkcell.SpringWebwithJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringWebwithJDBC.model.Person;
import com.turkcell.SpringWebwithJDBC.repository.PersonRepository;




@RestController
@RequestMapping(path = "person")
public class PersonController {

	@Autowired
	public PersonRepository personRepository;

	// http://localhost:8080/challenge9SpringJDBCwPostGre/person/getAll
	@GetMapping(path = "getAll")
	public List<Person> getAll() {
		return personRepository.getAll();
	}

	//	 http://localhost:8080/challenge9SpringJDBCwPostGre/person/getById?personId={personId}

	@SuppressWarnings("unchecked")
	@GetMapping(path = "getById")
	public ResponseEntity<Person> getById(@RequestParam int personId) {
		if (personRepository.getById(personId) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(personRepository.getById(personId));
		} else {
			return (ResponseEntity<Person>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// http://localhost:8080/challenge9SpringJDBCwPostGre/person/save 

	@PostMapping(path = "save")
	public ResponseEntity<String> save(@RequestBody Person person) {
		if (personRepository.save(person)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(person.getPersonName() + " database'e kaydedildi");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Kisi database'e kaydedilemedi ");
		}
	}

	//http://localhost:8080/challenge9SpringJDBCwPostGre/person/update
	
	@PostMapping(path = "update")
	public ResponseEntity<String> update(@RequestBody Person person) {
		if (personRepository.update(person)) {
			return ResponseEntity.status(HttpStatus.OK).body("Database'de update edildi.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Kisi database'de bulunamadı. ");
		}

	}

	//http://localhost:8080/challenge9SpringJDBCwPostGre/person/delete?id={id}
	@DeleteMapping(path = "delete")
	public ResponseEntity<String> deleteById(@RequestParam int id) {
		if (personRepository.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Kisi database'den silindi.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Kisi database'den silinemedi ");
		}
	}

}