package it.jaita88.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ricetta;
import it.jaita88.repositories.RicettaRepository;
import it.jaita88.repositories.RicetteIngredientiRepository;

@Service
public class RicetteIngredientiServiceImpl implements RicetteIngredientiService{
	@Autowired
	RicetteIngredientiRepository repository;
	@Autowired
	RicettaService repositoryric;
	
	@Override
	public List<Ricetta> findRicettaByFilter(String nomeIngrediente, Integer tempo, Integer grammiml,
			String nomeIntolleranza, String nomeIntolleranza2) {
		List<Object> res = repository.findRicettaByFilter(nomeIngrediente, tempo, grammiml, nomeIntolleranza, nomeIntolleranza2);
		List<Ricetta> risultato = new ArrayList<>();		
		for(int j = 0; j < res.size(); j++) {
			Ricetta ricetta = repositoryric.findRicettaById((Integer) res.get(j));
			risultato.add(ricetta);
		}		
		return risultato;
	}
	
	
	
}

