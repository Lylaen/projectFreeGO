package it.jaita88.services;

import java.util.List;


import it.jaita88.models.Ricetta;

public interface RicetteIngredientiService {
	List<Ricetta> findRicettaByFilter(String nomeIngrediente, Integer tempo, Integer grammiml, String nomeIntolleranza, String nomeIntolleranza2);
}
