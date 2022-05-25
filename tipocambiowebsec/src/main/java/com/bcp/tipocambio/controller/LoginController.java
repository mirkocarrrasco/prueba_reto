package com.bcp.tipocambio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String loginMostrar() {
		return "miLogin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "miLogin";
	}
	
	
}

