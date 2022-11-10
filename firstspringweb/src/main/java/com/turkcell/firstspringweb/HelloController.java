package com.turkcell.firstspringweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@GetMapping("/helloworld")
	public String HelloWorld() {
		return "Hello World, This is Kaan. Happy to see you here!";
	}
}
