package it.jaita88.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.jaita88.models.Intolleranza;
import it.jaita88.services.IntolleranzaService;

@Controller
@RequestMapping("/admin")
public class IntolleranzaController {
	@Autowired
	IntolleranzaService service;

	@GetMapping("/addintolleranzainizio")
	public String addIntolleranzaForm(Model model) {
		String title = "Aggiungi Intolleranza al Database";
		model.addAttribute("message", title);
		model.addAttribute("intolleranza", new Intolleranza());
		return "formaddintolleranza";
	}

	@PostMapping("/addIntolleranza")
	public String addIntolleranza(@ModelAttribute("intolleranza") Intolleranza intolleranza, Model model) {
		service.addIntolleranza(intolleranza);
		return "gestioneadmin";
	}

	@GetMapping("/updateintolleranzainizio")
	public String showUpdateIntolleranzaForm(Model model) {
		String title = "Aggiorna Intolleranza";
		model.addAttribute("message", title);
		return "formupdateintolleranza";
	}

	@GetMapping("/showIntolleranzaById")
	public String showIntolleranzaById(@RequestParam("id") Integer id, Model model) {
		Intolleranza i = service.findIntolleranzaById(id);
		String title = "Aggiorna Intolleranza";
		model.addAttribute("message", title);
		model.addAttribute("intolleranza", i);
		return "formupdateintolleranza2";
	}

	@PostMapping("/updateIntolleranza")
	public String updateIntolleranza(@ModelAttribute("ricetta") Intolleranza intolleranza, Model model) {
		service.updateIntolleranza(intolleranza, Integer.valueOf(intolleranza.getId()));
		return "gestioneadmin";
	}

	@GetMapping("/deleteintolleranzainizio")
	public String showDeleteIntolleranzaForm(Model model) {
		String title = "Cancella Intolleranza";
		model.addAttribute("message", title);
		return "formdeleteintolleranza";
	}

	@PostMapping("/deleteIntolleranza")
	public String deleteIntolleranza(@ModelAttribute("id") Integer id, Model model) {
		service.deleteIntolleranzaById(id);
		return "gestioneadmin";
	}
}
