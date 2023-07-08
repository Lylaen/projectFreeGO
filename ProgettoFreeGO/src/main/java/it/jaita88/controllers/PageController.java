package it.jaita88.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.jaita88.models.Ingrediente;
import it.jaita88.models.Ricetta;
import it.jaita88.services.IngredienteService;
import it.jaita88.services.RicetteIngredientiService;

@Controller
public class PageController {
	@Autowired 
	IngredienteService service;
	@Autowired
	RicetteIngredientiService servicericing;

	@GetMapping("/home")
	public String home(Model model) {
		List<Ingrediente> ingredienti = service.findAllIngredienti();
		model.addAttribute("ingredienti", ingredienti);
		return "home";
	}
	@GetMapping("/research")
	public String research(Model model) {
		String title = "Cerca per Ingrediente";
		model.addAttribute("message", title);
		return "researchingrediente";
	}
	@PostMapping("/result")
	public String result(@ModelAttribute("nome") String nome, Model model) {
		String title = "Cerca per Ingrediente";
		model.addAttribute("message", title);
		List<Ricetta> result = servicericing.findRicettaByIngrediente(nome);
		model.addAttribute("result", result);
		return "result";
	}
}
