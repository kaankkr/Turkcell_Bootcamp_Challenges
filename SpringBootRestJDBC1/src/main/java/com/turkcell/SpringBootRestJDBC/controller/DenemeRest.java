package com.turkcell.SpringBootRestJDBC.controller;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Person;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("deneme")
@AllArgsConstructor
public class DenemeRest
{
	private ApplicationContext applicationContext;

	@GetMapping("hello")
	public String hello()
	{
		// int k = 7 / 0;
		// localhost:8080/deneme/hello
		// localhost:8080/SpringBootRestJDBC/deneme/hello değil
		return "Hello spring boot rest jdbc";
	}
	
	@GetMapping(path = "person", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person person()
	{
		// localhost:8080/deneme/person
		return new Person("my person");
	}

	@GetMapping(path = "beans")
	public ResponseEntity<String> beans()
	{
		// localhost:8080/beans
		String[] names = applicationContext.getBeanDefinitionNames();
		Arrays.sort(names);
		StringBuilder builder = new StringBuilder();
		builder.append("---- " + names.length + " ----").append("<br>");
		for (String name : names)
		{
			builder.append(" ---> " + applicationContext.getBean(name).getClass().getName()).append("<br>");
		}
		return ResponseEntity.ok(builder.toString());
	}
}
