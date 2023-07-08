package it.jaita88.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.jaita88.models.Ricetta;
import it.jaita88.services.RicettaService;

@Controller
@RequestMapping("/admin")
public class RicettaController {
	@Autowired
	RicettaService service;
	
	@GetMapping("/addricettainizio")
	public String addRicettaForm(Model model) {
		String title = "Aggiungi Ricetta al Database";
		model.addAttribute("message", title);
		model.addAttribute("ricetta", new Ricetta());
		return "formaddricette";
	}
	@PostMapping("/addRicetta")
	public String addRicetta(@ModelAttribute("ricetta") Ricetta ricetta, Model model) {
		service.addRicetta(ricetta);
		return "gestioneadmin";
	}
	@GetMapping("/updatericettainizio")
	public String showUpdateRicettaForm(Model model) {
		String title = "Aggiorna Ricetta";
		model.addAttribute("message", title);
		return "formupdatericetta";
	}
	@GetMapping("/showRicettaById")
	public String showRicettaById(@RequestParam("id") Integer id, Model model) {
		Ricetta r = service.findRicettaById(id);
		String title = "Aggiorna Ricetta";
		model.addAttribute("message", title);
		model.addAttribute("ricetta", r);
		return "formupdatericetta2";
	}
	@PostMapping("/updateRicetta")
	public String updateRicetta(@ModelAttribute("ricetta") Ricetta ricetta, Model model) {
		service.updateRicetta(ricetta, Integer.valueOf(ricetta.getId()));
		return "gestioneadmin";
	}
	@GetMapping("/deletericettainizio")
	public String showDeleteRicettaForm(Model model) {
		String title = "Cancella Ricetta";
		model.addAttribute("message", title);
		return "formdeletericetta";
	}
	@PostMapping("/deleteRicetta")
	public String deleteRicetta(@ModelAttribute("id") Integer id, Model model) {				
		service.deleteRicettaById(id);		
		return "gestioneadmin";
	}
	
	
}
