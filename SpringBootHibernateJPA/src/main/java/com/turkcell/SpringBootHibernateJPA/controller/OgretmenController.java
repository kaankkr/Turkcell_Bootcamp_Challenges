package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootHibernateJPA.dto.OgretmenDTO;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.service.OgretmenDTOService;
import com.turkcell.SpringBootHibernateJPA.service.OgretmenService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "ogretmen")
public class OgretmenController
{
	@NonNull
	private OgretmenService service;
	@NonNull
	private OgretmenDTOService dtoService;
	@NonNull
	private ResourceBundleMessageSource messageSource;

	//@Value("${logging.pattern.console}")
	public String logPatternConsole;
	
	@PostConstruct
	public void postConstruct()
	{
	}

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogretmen> getAll()
	{
		// localhost:8080/ogretmen/getAll
		return service.getAll();
	}


	@GetMapping(path = "searchByNameHeader", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogretmen> searchByNameHeader(@RequestHeader(name = "name") String exp)
	{
		// localhost:8080/ogretmen/searchByName
		return service.findNameLike(exp);
	}
	
	@GetMapping(path = "searchByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogretmen> searchByName(@RequestParam(name = "name") String exp)
	{
		// localhost:8080/ogretmen/searchByName?name=man
		return service.findNameLike(exp);
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> getByIdEntity(@PathVariable Long id)
	{
		// localhost:8080/ogretmen/getById/1
		Ogretmen ogr = service.getByID(id);
		if (ogr != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(ogr);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping(path = "getByIdDTO/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OgretmenDTO> getByIdDTO(@PathVariable Long id)
	{
		// localhost:8080/ogretmen/getByIdDTO/1
		OgretmenDTO ogr = dtoService.getByID(id);
		if (ogr != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(ogr);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

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
	public ResponseEntity<String> save(@RequestBody Ogretmen ogretmen, Locale locale)
	{
		// locale değişkeni otomatik olarak accept-language header 'ından inject edildi
		// localhost:8080/ogretmen/save
		// {"name" : "kerem"}
		ogretmen = service.save(ogretmen);
		//Locale locale = Locale.forLanguageTag("tr");
		String mesaj = messageSource.getMessage("ogretmen.save.succes", null, locale);
		return ResponseEntity.status(HttpStatus.CREATED).body(ogretmen.toString() + " " + mesaj + " http://localhost:8080/ogretmen/getById/" + ogretmen.getID());
	}
}