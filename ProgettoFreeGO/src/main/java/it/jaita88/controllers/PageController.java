package it.jaita88.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.jaita88.models.Ricetta;
import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.RicettaRepository;
import it.jaita88.repositories.UtenteLoginRepository;
import it.jaita88.security.SessionUtils;
import it.jaita88.services.IngredienteService;
import it.jaita88.services.RicettaService;
import it.jaita88.services.RicetteIngredientiService;
import it.jaita88.services.UtenteLoginService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
	@Autowired
	RicettaRepository repository;
	@Autowired
	RicettaService serviceric;
	@Autowired 
	UtenteLoginRepository userRepository;
	@Autowired
	UtenteLoginService serviceutente;
	@Autowired 
	IngredienteService service;
	@Autowired
	RicetteIngredientiService servicericing;
	@GetMapping("/chisiamo")
	public String chisiamo(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "chisiamo";
	}
	@GetMapping("/antipasti") 
	public String antipasti(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "antipasti";
	}
	@GetMapping("/primi") 
	public String primi(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "primi";
	}
	@GetMapping("/secondi") 
	public String secondi(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "secondi";
	}
	@GetMapping("/dessert") 
	public String dessert(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "dessert";
	}
	@GetMapping("/admin/gestioneadmin")
	public String gestioneAdmin(Model model) {
		if(SessionUtils.isAdmin()) {
			return "gestioneadmin";
		}
		return "error";
	}
	@GetMapping("/Pasta-con-patate-alla-napoletana")
	public String ricetta1(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		UtenteLogin utenteLoggato = userRepository.findByUsername(SessionUtils.getUserUsername());
		//utenteLoggato.addRicetta(null)
		return "PastaPatate";
	}
	@GetMapping("/Frittata-farcita-con-prosciutto-e-mozzarella")
	public String ricetta2(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Frittata-farcita-con-prosciutto-e-mozzarella";		
	}
	@GetMapping("/Carbonara")
	public String ricetta3(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Carbonara";
	}
	@GetMapping("/Hummus-di-avocado-e-ceci")
	public String ricetta4(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Hummus-di-avocado-e-ceci";
	}
	@GetMapping("/Insalata-di-polpo")
	public String ricetta5(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Insalata-di-polpo";
	}
	@GetMapping("/Muffin") 
	public String ricetta6(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Muffin";
	}
	@GetMapping("/Nasello-in-umido")
	public String ricetta7(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Nasello-in-umido";
	}
	@GetMapping("/Pancakes-alla-banana")
	public String ricetta8(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Pancakes-alla-banana";
	}
	@GetMapping("/Pasta-con-crema-di-peperoni-e-salsiccia")
	public String ricetta9(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Pasta-con-crema-di-peperoni-e-salsiccia";
	}
	@GetMapping("/Pollo-con-spremuta-di-arancia")
	public String ricetta10(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Pollo-con-spremuta-di-arancia";
	}
	@GetMapping("/Vellutata-di-fave-e-piselli")
	public String ricetta11(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Vellutata-di-fave-e-piselli";
	}
	@GetMapping("/Pasta-con-zucca-e-salsiccia")
	public String ricetta12(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Pasta-con-zucca-e-salsiccia";
	}
	@GetMapping("/Pasta-al-burro-e-limone")
	public String ricetta13(Model model) {
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "Pasta-al-burro-e-limone";
	}
	@GetMapping("/home")
	public String home(Model model) { 
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "index";
	}
	
	@PostMapping("/result")
	public String result(HttpServletRequest request, Model model) {
		String title = "Cerca Ricette";
		model.addAttribute("message", title);
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
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
		if(request.getParameter("grammiml") != "" && request.getParameter("grammiml") != null && request.getParameter("grammiml") != " " ) {
			grammi = Integer.valueOf(request.getParameter("grammiml"));
		}
		System.err.println(int1);
		System.err.println(int2);
		System.err.println(tempo);
		System.err.println(grammi);
		
		List<Ricetta> result = servicericing.findRicettaByFilter(nomeing, tempo, grammi, int1, int2);
		for(Ricetta ric : result) {
			System.err.println(ric.toString());
		}
		model.addAttribute("result", result);
		return "result";
	}
	@GetMapping("/preferiti")
	public String showPreferiti(String username, Model model) {
		username = SessionUtils.getUserUsername();
		List<Ricetta> preferiti = serviceutente.findPreferiti(username);
		model.addAttribute("preferiti", preferiti);
		boolean condizione1 = SessionUtils.isAdmin();
		boolean condizione2 = SessionUtils.isUser();
		model.addAttribute("condizione1", condizione1);
		model.addAttribute("condizione2", condizione2);
		return "preferiti";
	}
	}