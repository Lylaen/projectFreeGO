package it.jaita88.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.dto.CommentDto;
import it.jaita88.dto.RicettaDto;
import it.jaita88.models.Comment;
import it.jaita88.models.Ricetta;
import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.UtenteLoginRepository;
import it.jaita88.security.SessionUtils;
import it.jaita88.services.CommentService;
import it.jaita88.services.RicettaService;

@RestController
public class RestPageController {
	@Autowired
	CommentService servicecommento;
	@Autowired
	UtenteLoginRepository userRepository;
	@Autowired
	RicettaService service;
	
	@PostMapping("/Pasta-con-patate-alla-napoletanap")
	public String ricetta1(@RequestBody RicettaDto data,  Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
				
			Ricetta ricetta = service.findRicettaById(data.getGrammiml());		
			//List<Ricetta> preferiti = new ArrayList<>();
			//preferiti.add(ricetta);
			utenteLoggato.addRicetta(ricetta);
			userRepository.save(utenteLoggato); 		
		return "PastaPatate";
	}
	@PostMapping("/Pasta-con-patate-alla-napoletanac")
	public String ricetta1(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(3);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "PastaPatate";
	}
	@PostMapping("/Pasta-al-burro-e-limonep")
	public String ricetta13(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Pasta-al-burro-e-limone";
	}
	@PostMapping("/Pasta-al-burro-e-limonec")
	public String ricetta13(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(1);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Pasta-al-burro-e-limone";
	}
	@PostMapping("/Pasta-con-zucca-e-salsicciap")
	public String ricetta12(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Pasta-con-zucca-e-salsiccia";
	}
	@PostMapping("/Pasta-con-zucca-e-salsicciac")
	public String ricetta12(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(2);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Pasta-con-zucca-e-salsiccia";
	}
	@PostMapping("/Pasta-con-crema-di-peperoni-e-salsicciap")
	public String ricetta9(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Pasta-con-crema-di-peperoni-e-salsiccia";
	}
	@PostMapping("/Pasta-con-crema-di-peperoni-e-salsicciac")
	public String ricetta9(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(4);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Pasta-con-crema-di-peperoni-e-salsiccia";
	}
	@PostMapping("/Carbonarap")
	public String ricetta3(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Carbonara";
	}
	@PostMapping("/Carbonarac")
	public String ricetta3(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(5);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Carbonara";
	}
	@PostMapping("/Vellutata-di-fave-e-pisellip")
	public String ricetta11(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Vellutata-di-fave-e-piselli";
	}
	@PostMapping("/Vellutata-di-fave-e-pisellic")
	public String ricetta11(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(6);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Vellutata-di-fave-e-piselli";
	}
	@PostMapping("/Frittata-farcita-con-prosciutto-e-mozzarellap")
	public String ricetta2(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Frittata-farcita-con-prosciutto-e-mozzarella";
	}
	@PostMapping("/Frittata-farcita-con-prosciutto-e-mozzarellac")
	public String ricetta2(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(7);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Frittata-farcita-con-prosciutto-e-mozzarella";
	}
	@PostMapping("/Pollo-con-spremuta-di-aranciap")
	public String ricetta10(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Pollo-con-spremuta-di-arancia";
	}
	@PostMapping("/Pollo-con-spremuta-di-aranciac")
	public String ricetta10(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(8);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Pollo-con-spremuta-di-arancia";
	}
	@PostMapping("/Nasello-in-umidop")
	public String ricetta7(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Nasello-in-umido";
	}
	@PostMapping("/Nasello-in-umidoc")
	public String ricetta7(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(9);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Nasello-in-umido";
	}
	@PostMapping("/Hummus-di-avocado-e-cecip")
	public String ricetta4(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Hummus-di-avocado-e-ceci";
	}
	@PostMapping("/Hummus-di-avocado-e-cecic")
	public String ricetta4(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(10);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Hummus-di-avocado-e-ceci";
	}
	@PostMapping("/Insalata-di-polpop")
	public String ricetta5(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Insalata-di-polpo";
	}
	@PostMapping("/Insalata-di-polpoc")
	public String ricetta5(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(11);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Insalata-di-polpo";
	}
	@PostMapping("/Pancakes-alla-bananap")
	public String ricetta8(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Pancakes-alla-banana";
	}
	@PostMapping("/Pancakes-alla-bananac")
	public String ricetta8(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(12);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Pancakes-alla-banana";
	}
	@PostMapping("/Muffinp")
	public String ricetta6(@RequestBody RicettaDto data, Model model) {		
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		
		Ricetta ricetta = service.findRicettaById(data.getGrammiml());
		
		utenteLoggato.addRicetta(ricetta);
		userRepository.save(utenteLoggato);
		return "Muffin";
	}
	@PostMapping("/Muffinc")
	public String ricetta6(@RequestBody CommentDto jsonData,  Model model) {
		System.err.println(jsonData);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());		
		Ricetta ricetta = service.findRicettaById(13);
		Comment commento = new Comment();
		commento.setTitolo(jsonData.getTitolo());
		commento.setTesto(jsonData.getTesto());
		commento.setUtente(utenteLoggato);
		commento.setRicetta(ricetta);
		servicecommento.addComment(commento);
		return "Muffin";
	}
	
}
