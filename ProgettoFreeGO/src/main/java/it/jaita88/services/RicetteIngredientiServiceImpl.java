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
	public List<Ricetta> findRicettaByIngrediente(String nomeIngrediente) {		
		List<Object> res = repository.findRicettaByIngrediente(nomeIngrediente);	
		List<Ricetta> risultato = new ArrayList<>();		
		for(int j = 0; j < res.size(); j++) {
			Ricetta ricetta = repositoryric.findRicettaById((Integer) res.get(j));
			risultato.add(ricetta);
		}		
		return risultato;
	}
	@Override
	public List<Ricetta> findRicettaByIngredienteGrammi(String nomeIngrediente, Integer grammiml) {
		List<Object> res = repository.findRicettaByIngredienteGrammi(nomeIngrediente, grammiml);
		List<Ricetta> risultato = new ArrayList<>();
		for(int i = 0; i < res.size(); i++) {
			Ricetta ricetta = repositoryric.findRicettaById((Integer) res.get(i));
			risultato.add(ricetta);			
		}
		return risultato;
	}
	
	
}
