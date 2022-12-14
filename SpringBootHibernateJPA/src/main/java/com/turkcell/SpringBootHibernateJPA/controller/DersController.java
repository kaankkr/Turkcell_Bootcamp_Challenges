package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.DersDTO;
import com.turkcell.SpringBootHibernateJPA.service.DersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "ders")
// sadece dersservice ile ilgili hatalar yakalanacak
// Controller advice içerisnde compopnent olduğpu için gereksiz yere ayağa kalkabiliyor
// mvc test yazarken
//@RestControllerAdvice(basePackageClasses = DersService.class)
@Slf4j
public class DersController
{
	@Autowired
	public DersService service;
	
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseStatus(value = HttpStatus.IM_USED)
	public String nullPointerExceptionHandler(Exception ex)
	{
		log.error("Nullpointerexception yakalandı " + ex.getMessage());
		return "{\"message\" = \"bişeyler yanlış gitti\"}";
	}

	// produces yazmazsam 406 hatası alabiliyorum
	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ders> getAll()
	{
		// localhost:8080/ders/getAll
		ArrayList<Ders> liste = (ArrayList<Ders>) service.getAll();
		System.err.println("Liste getall yapıldı");
		return liste;
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ders> getByIdEntity(@PathVariable Long id)
	{
		// localhost:8080/ders/getById/1
		return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
	}

	// @PutMapping, @PatchMapping update için kullanılabilir
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ders ders)
	{
		// localhost:8080/ders/save
		//  { "ogretmen": { "id": 2 }, "konu": {"id": 2 } }
		ders = service.save(ders);
		return ResponseEntity.status(HttpStatus.CREATED).body(ders.getID() + " id'li ders başarıyla eklendi");
	}
}