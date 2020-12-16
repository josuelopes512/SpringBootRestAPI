package com.vagas.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class StatusController {
	
	
	@GetMapping(path = "/api/status")
	public String check() {
		return "online";
	}

}
