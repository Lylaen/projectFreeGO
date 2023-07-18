package it.jaita88.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.dto.RicettaDto;
import it.jaita88.models.Ricetta;
import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.UtenteLoginRepository;
import it.jaita88.security.SessionUtils;
import it.jaita88.services.RicettaService;

@RestController
public class RestPageController {
	@Autowired
	UtenteLoginRepository userRepository;
	@Autowired
	RicettaService service;
	
	@PostMapping("/Pasta-con-patate-alla-napoletana")
	public String ricetta1(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "PastaPatate";
	}
	@PostMapping("/Pasta-al-burro-e-limone")
	public String ricetta13(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Pasta-al-burro-e-limone";
	}
	@PostMapping("/Pasta-con-zucca-e-salsiccia")
	public String ricetta12(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Pasta-con-zucca-e-salsiccia";
	}
	@PostMapping("/Pasta-con-crema-di-peperoni-e-salsiccia")
	public String ricetta9(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Pasta-con-crema-di-peperoni-e-salsiccia";
	}
	@PostMapping("/Carbonara")
	public String ricetta3(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Carbonara";
	}
	@PostMapping("/Vellutata-di-fave-e-piselli")
	public String ricetta11(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Vellutata-di-fave-e-piselli";
	}
	@PostMapping("/Frittata-farcita-con-prosciutto-e-mozzarella")
	public String ricetta2(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Frittata-farcita-con-prosciutto-e-mozzarella";
	}
	@PostMapping("/Pollo-con-spremuta-di-arancia")
	public String ricetta10(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Pollo-con-spremuta-di-arancia";
	}
	@PostMapping("/Nasello-in-umido")
	public String ricetta7(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Nasello-in-umido";
	}
	@PostMapping("/Hummus-di-avocado-e-ceci")
	public String ricetta4(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Hummus-di-avocado-e-ceci";
	}
	@PostMapping("/Insalata-di-polpo")
	public String ricetta5(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Insalata-di-polpo";
	}
	@PostMapping("/Pancakes-alla-banana")
	public String ricetta8(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Pancakes-alla-banana";
	}
	@PostMapping("/Muffin")
	public String ricetta6(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		List<Ricetta> preferiti = new ArrayList<>();
		preferiti.add(ricetta);
		utenteLoggato.setPreferiti(preferiti);
		userRepository.save(utenteLoggato);
		return "Muffin";
	}
	
}
