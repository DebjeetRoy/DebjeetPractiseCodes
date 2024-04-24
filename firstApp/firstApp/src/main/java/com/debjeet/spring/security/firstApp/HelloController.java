package com.debjeet.spring.security.firstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// Basic authentication jumps in as we have dependency of spring-security
	@GetMapping("/hello")
	public String hello() {
		return "Spring Security Implementation";
	}

	@GetMapping("/bye")
	public String bye() {
		return "Get Lostt !!";
	}
}
