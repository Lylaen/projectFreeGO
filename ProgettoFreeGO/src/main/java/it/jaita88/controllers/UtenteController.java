package it.jaita88.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.jaita88.dto.UtenteLoginDto;
import it.jaita88.dto.UtenteSignup;
import it.jaita88.models.Ruolo;
import it.jaita88.models.UtenteAnagrafica;
import it.jaita88.models.UtenteLogin;
import it.jaita88.security.AuthenticationService;
import it.jaita88.security.SessionUtils;
import it.jaita88.services.UtenteAnagraficaService;
import it.jaita88.services.UtenteLoginService;
@Controller
public class UtenteController {
	@Autowired
	private UtenteLoginService service;
	
	@Autowired
	private UtenteAnagraficaService serviceAnagrafica;
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		String title = "Please Login";
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		model.addAttribute("message", title);
		model.addAttribute("utenteLogin", new UtenteLoginDto());
		return "loginForm";
	}
	@PostMapping("/loginUtente")
	public String processLoginUtente(@ModelAttribute("utenteLogin") UtenteLoginDto utenteLogin, Model model) {
		// invocazione del servizio
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		boolean isAuth = authService.authenticate(utenteLogin.getUsername(), utenteLogin.getPassword());
		System.err.println(isAuth);
		if (isAuth) {	
			//ricerca ruolo da sessione
			String ruolo = SessionUtils.getUserRole();
			if (ruolo.equals("ROLE_USER")) {
				return "redirect:/home";
			} else if (ruolo.equals("ROLE_ADMIN")) {
				return "gestioneadmin";
			} else {
				return "error";
			}
		}else {
			model.addAttribute("utenteLogin", "Utente non esistente");
			return "loginForm";
		}
	}
	
	@GetMapping("/signup")
	public String showSignupForm(Model model) {
		String title = "Please Signup";
		model.addAttribute("message", title);
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		model.addAttribute("utenteSignup", new UtenteSignup());
		return "signupForm";
	}
	
	@PostMapping("/signupUtente")
	public String processSignupUtente(@ModelAttribute("utenteSignup") UtenteSignup utenteSignup, Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		UtenteLogin login = new UtenteLogin();
		UtenteAnagrafica anag = new UtenteAnagrafica();
		login.setUsername(utenteSignup.getUsername());
		login.setPassword(passwordEncoder.encode(utenteSignup.getPassword()));
		anag.setCognome(utenteSignup.getCognome());
		anag.setNome(utenteSignup.getNome());
		anag.setEmail(utenteSignup.getEmail());
		Ruolo ruolo = new Ruolo();
		ruolo.setNome("USER");
		ruolo.setId(2);
		login.addRuoli(ruolo);
		service.addUtenteLogin(login);
		serviceAnagrafica.addUtenteAnagrafica(anag);
		return "redirect:/login";
	}
	

}
