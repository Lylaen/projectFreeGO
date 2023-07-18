package it.jaita88.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.jaita88.dto.IngredienteDto;
import it.jaita88.dto.RicettaDto;
import it.jaita88.models.Ingrediente;
import it.jaita88.models.Ricetta;
import it.jaita88.repositories.RicettaRepository;
import it.jaita88.repositories.RicetteIngredientiRepository;
import it.jaita88.services.IngredienteService;
import it.jaita88.services.RicettaService;

@Controller
@RequestMapping("/admin")
public class RicettaController {
	@Autowired
	RicettaRepository repository;
	@Autowired
	RicettaService service;
	@Autowired
	IngredienteService serviceing;
	@Autowired
	RicetteIngredientiRepository repositorycompl;

	@GetMapping("/addricettainizio")
	public String addRicettaForm(Model model) {
		String title = "Aggiungi Ricetta al Database";
		model.addAttribute("message", title);
		model.addAttribute("ricettadto", new RicettaDto());
		List<Ingrediente> ingredienti = serviceing.findAllIngredienti();
		model.addAttribute("ingredienti", ingredienti);
		
		return "formaddricette";
	}
	@PostMapping("/addRicetta")
	public String addRicetta(@ModelAttribute("ricetta") RicettaDto ricettadto, Model model) {
		List<Ingrediente> ingredientiRicetta = new ArrayList<>();
		for (Integer id : ricettadto.getIngredientiId()) {
			Ingrediente ingrediente = serviceing.findIngredienteById(id);
			ingredientiRicetta.add(ingrediente);
		}
		Ricetta ricetta = new Ricetta();
		ricetta.setNome(ricettadto.getNome());
		ricetta.setTempo(ricettadto.getTempo());
		ricetta.setZimmagine(ricettadto.getZimmagine());
		ricetta.setIngredientilist(ingredientiRicetta);
		service.addRicetta(ricetta);
		Integer idRicetta = ricetta.getId();
		
		return "redirect:/admin/formgrammi?id=" + idRicetta;
	}
	@GetMapping("/formgrammi")
	public String showFormGrammi(@RequestParam("id") Integer idRicetta, Model model ) {
		Ricetta ricetta = service.findRicettaById(idRicetta);
		List<Ingrediente> listIngredienteRicetta = ricetta.getIngredientilist();
		List<Integer> ids = new ArrayList<>();
		for (Ingrediente ing : listIngredienteRicetta) {			
			Integer iding = ing.getId();
			ids.add(iding);
		}
		model.addAttribute("listIngredienteRicetta", listIngredienteRicetta);
		model.addAttribute("ids", ids);
		IngredienteDto ingredienteDto = new IngredienteDto();
		model.addAttribute("idRicetta", idRicetta);
		model.addAttribute("ingredienteDto", ingredienteDto);
		return "formaddgrammi";
	}
	
	@PostMapping("/addGrammi")
	public String addGrammi(@ModelAttribute("ingredienteDto") IngredienteDto ingredienteDto, @RequestParam("idRicetta") Integer idRicetta) {
		System.err.println(ingredienteDto.getIdIngrediente());
		System.err.println(ingredienteDto.getGrammiml());
		int i = 0;
		int j = 0;
		while(i < ingredienteDto.getIdIngrediente().size()) {
			while(j < ingredienteDto.getGrammiml().size()) {
				repository.updateIngredienti(ingredienteDto.getGrammiml().get(j), ingredienteDto.getIdIngrediente().get(i), idRicetta);
				i++;
				j++;
			}
		}
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
