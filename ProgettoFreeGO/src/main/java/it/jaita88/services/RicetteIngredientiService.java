package it.jaita88.services;

import java.util.List;


import it.jaita88.models.Ricetta;

public interface RicetteIngredientiService {
	List<Ricetta> findRicettaByIngrediente(String nomeIngrediente);
}
