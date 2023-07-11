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
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
	@Autowired 
	IngredienteService service;
	@Autowired
	RicetteIngredientiService servicericing;

	@GetMapping("/home")
	public String home(Model model) {
		return "index";
	}
	@GetMapping("/research")
	public String research(Model model) {
		String title = "Cerca per Ingrediente";
		model.addAttribute("message", title);
		return "researchingrediente";
	}
	@PostMapping("/result")
	public String result(HttpServletRequest request, Model model) {
		String title = "Cerca Ricette";
		model.addAttribute("message", title);
		String nomeing = request.getParameter("nomeing");
		String int1 = null;
		String int2 = null;
		Integer grammi = null;
		Integer tempo = null;
		System.err.println(nomeing);
		if(request.getParameter("intolleranza1") != null && int1 == null) {
			int1 = request.getParameter("intolleranza1");
		} else if(request.getParameter("intolleranza1") != null && int1 != null) {
			int2 = request.getParameter("intolleranza1");
		}
		if(request.getParameter("intolleranza2") != null && int1 == null) {
			int1 = request.getParameter("intolleranza2");
		} else if(request.getParameter("intolleranza2") != null && int1 != null) {
			int2 = request.getParameter("intolleranza2");
		}
		if(request.getParameter("intolleranza3") != null && int1 == null) {
			int1 = request.getParameter("intolleranza3");
		} else if(request.getParameter("intolleranza3") != null && int1 != null) {
			int2 = request.getParameter("intolleranza3");
		}
		if(request.getParameter("intolleranza4") != null && int1 == null) {
			int1 = request.getParameter("intolleranza4");
		} else if(request.getParameter("intolleranza4") != null && int1 != null) {
			int2 = request.getParameter("intolleranza4");
		}
		if(request.getParameter("intolleranza5") != null && int1 == null) {
			int1 = request.getParameter("intolleranza5");
		} else if(request.getParameter("intolleranza5") != null && int1 != null) {
			int2 = request.getParameter("intolleranza5");
		}
		if(request.getParameter("intolleranza6") != null && int1 == null) {
			int1 = request.getParameter("intolleranza6");
		} else if(request.getParameter("intolleranza6") != null && int1 != null) {
			int2 = request.getParameter("intolleranza6");
		}
		if(request.getParameter("intolleranza7") != null && int1 == null) {
			int1 = request.getParameter("intolleranza7");
		} else if(request.getParameter("intolleranza7") != null && int1 != null) {
			int2 = request.getParameter("intolleranza7");
		}
		if(request.getParameter("intolleranza8") != null && int1 == null) {
			int1 = request.getParameter("intolleranza8");
		} else if(request.getParameter("intolleranza8") != null && int1 != null) {
			int2 = request.getParameter("intolleranza8");
		}
		if(request.getParameter("intolleranza9") != null && int1 == null) {
			int1 = request.getParameter("intolleranza9");
		} else if(request.getParameter("intolleranza9") != null && int1 != null) {
			int2 = request.getParameter("intolleranza9");
		}
		if(request.getParameter("intolleranza10") != null && int1 == null) {
			int1 = request.getParameter("intolleranza10");
		} else if(request.getParameter("intolleranza10") != null && int1 != null) {
			int2 = request.getParameter("intolleranza10");
		}
		if(request.getParameter("intolleranza11") != null && int1 == null) {
			int1 = request.getParameter("intolleranza11");
		} else if(request.getParameter("intolleranza11") != null && int1 != null) {
			int2 = request.getParameter("intolleranza11");
		}
		if(request.getParameter("intolleranza12") != null && int1 == null) {
			int1 = request.getParameter("intolleranza12");
		} else if(request.getParameter("intolleranza12") != null && int1 != null) {
			int2 = request.getParameter("intolleranza12");
		}
		if(request.getParameter("intolleranza13") != null && int1 == null) {
			int1 = request.getParameter("intolleranza13");
		} else if(request.getParameter("intolleranza13") != null && int1 != null) {
			int2 = request.getParameter("intolleranza13");
		}
		if(request.getParameter("intolleranza14") != null && int1 == null) {
			int1 = request.getParameter("intolleranza14");
		} else if(request.getParameter("intolleranza14") != null && int1 != null) {
			int2 = request.getParameter("intolleranza14");
		}
		//inizio checkbox tempo
		if(request.getParameter("tempo1") != null) {
			tempo = Integer.valueOf(request.getParameter("tempo1"));
		} else if (request.getParameter("tempo2") != null) {
			tempo = Integer.valueOf(request.getParameter("tempo2"));
		} else if (request.getParameter("tempo3") != null) {
			tempo = Integer.valueOf(request.getParameter("tempo3"));
		}
		//grammi
		if(request.getParameter("grammiml") != null) {
			grammi = Integer.valueOf(request.getParameter("grammiml"));
		}
		System.err.println(int1);
		System.err.println(int2);
		System.err.println(tempo);
		System.err.println(grammi);
		
		List<Ricetta> result = servicericing.findRicettaByFilter(nomeing, tempo, grammi, int1, int2);
		model.addAttribute("result", result);
		return "result";
	}
}