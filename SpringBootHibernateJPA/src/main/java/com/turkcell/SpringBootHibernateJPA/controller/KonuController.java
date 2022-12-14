package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ResourceBundleMessageSource;
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

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.service.KonuService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/konu")
public class KonuController {

	
	
	@NonNull
	private KonuService service;
	//@NonNull
	//private KonuDTOService dtoService;
	@NonNull
	private ResourceBundleMessageSource messageSource;

	//@Value("${logging.pattern.console}")
	public String logPatternConsole;
	
	@PostConstruct
	public void postConstruct()
	{
	}

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> getAll()
	{
		// localhost:8080/konu/getAll
		return service.getAll();
	}

	/*

	@GetMapping(path = "searchByNameHeader", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> searchByNameHeader(@RequestHeader(name = "name") String exp)
	{
		// localhost:8080/konu/searchByName
		return service.findNameLike(exp);
	}
	
	@GetMapping(path = "searchByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> searchByName(@RequestParam(name = "name") String exp)
	{
		// localhost:8080/konu/searchByName?name=man
		return service.findNameLike(exp);
	}
	*/
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getByIdEntity(@PathVariable Long id)
	{
		// localhost:8080/ogretmen/getById/1
		Konu konu = service.getByID(id);
		if (konu != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(konu);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	/*
	@GetMapping(path = "getByIdDTO/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OgretmenDTO> getByIdDTO(@PathVariable Long id)
	{
		// localhost:8080/konu/getByIdDTO/1
		OgretmenDTO konu = dtoService.getByID(id);
		if (konu != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(konu);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	*/

	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		// localhost:8080/ogretmen/deleteById/1
		try
		{
			if (service.delete(id))
			{
				return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!!");
			}
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!! (" + e.getMessage() + ")");
		}
	}

	// @PutMapping, @PatchMapping update için kullanılabilir
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu, Locale locale)
	{
		// locale değişkeni otomatik olarak accept-language header 'ından inject edildi
		// localhost:8080/konu/save
		konu = service.save(konu);
		//Locale locale = Locale.forLanguageTag("tr");
		String mesaj = messageSource.getMessage("ogretmen.save.succes", null, locale);
		return ResponseEntity.status(HttpStatus.CREATED).body(konu.toString() + " " + mesaj + " http://localhost:8080/ogretmen/getById/" + konu.getID());
	}
}
