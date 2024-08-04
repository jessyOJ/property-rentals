package com.flexisaf.property_rentals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	// handler method to handle login request
		@GetMapping("/")
		public String index() {
			return "login";
		}

	// handler method to handle login request
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// handler method to handle login request
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	// handler method to handle login request
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	// handler method to handle login request
	@GetMapping("/owner")
	public String owner() {
		return "owner";
	}
}
