package it.jaita88.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.jaita88.models.Ingrediente;

import it.jaita88.services.IngredienteService;

@Controller
@RequestMapping("/admin")
public class IngredienteController {
	@Autowired
	IngredienteService service;
	@GetMapping("/addingredienteinizio")
	public String addIngredienteForm(Model model) {
		String title = "Aggiungi Ingrediente al Database";
		model.addAttribute("message", title);
		model.addAttribute("ingrediente", new Ingrediente());
		return "formaddingrediente";
	}
	@PostMapping("/addIngrediente")
	public String addIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, Model model) {
		service.addIngrediente(ingrediente);
		return "gestioneadmin";
	}
	@GetMapping("/updateingredienteinizio")
	public String showUpdateIngredienteForm(Model model) {
		String title = "Aggiorna Ingrediente";
		model.addAttribute("message", title);
		return "formupdateingrediente";
	}
	@GetMapping("/showIngredienteById")
	public String showIngredienteById(@RequestParam("id") Integer id, Model model) {
		Ingrediente i = service.findIngredienteById(id);
		String title = "Aggiorna Ingrediente";
		model.addAttribute("message", title);
		model.addAttribute("ingrediente", i);
		return "formupdateingrediente2";
	}
	@PostMapping("/updateIngrediente")
	public String updateIngrediente(@ModelAttribute("ricetta") Ingrediente ingrediente, Model model) {
		service.updateIngrediente(ingrediente, Integer.valueOf(ingrediente.getId()));
		return "gestioneadmin";
	}
	@GetMapping("/deleteingredienteinizio")
	public String showDeleteIngredienteForm(Model model) {
		String title = "Cancella Ingrediente";
		model.addAttribute("message", title);
		return "formdeleteingrediente";
	}
	@PostMapping("/deleteIngrediente")
	public String deleteIngrediente(@ModelAttribute("id") Integer id, Model model) {				
		service.deleteIngredienteById(id);		
		return "gestioneadmin";
	}
}
