package it.jaita88.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.jaita88.security.SessionUtils;

@Controller
public class UtenteLoginController {
	
	@GetMapping("/logout")
	public String processLogout() {
		SessionUtils.invalidateSession();
		return "index";
	}
}
