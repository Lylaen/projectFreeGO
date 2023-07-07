package it.jaita88.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.jaita88.models.Ingrediente;
import it.jaita88.services.IngredienteService;

@Controller
public class PageController {
	@Autowired 
	IngredienteService service;

	@GetMapping("/home")
	public String home(Model model) {
		List<Ingrediente> ingredienti = service.findAllIngredienti();
		model.addAttribute("ingredienti", ingredienti);
		return "home";
	}
}
