package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ingrediente;
import it.jaita88.models.Ricetta;
import it.jaita88.repositories.RicetteIngredientiRepository;

@Service
public class RicetteIngredientiServiceImpl implements RicetteIngredientiService{
	@Autowired
	RicetteIngredientiRepository repository;

	@Override
	public List<Ricetta> findRicettaByIngrediente(String nomeIngrediente) {
		List<Ricetta> risultato = repository.findRicettaByIngrediente(nomeIngrediente);
		return risultato;
	}
	
	
}
