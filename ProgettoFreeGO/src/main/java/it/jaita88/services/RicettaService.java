package it.jaita88.services;

import java.util.List;

import it.jaita88.models.Ricetta;

public interface RicettaService {
	List<Ricetta> findAllRicette();
	Ricetta findRicettaById(Integer id);
	void deleteRicettaById(Integer id);
	void updateRicetta(Ricetta ricetta, Integer id);
	void addRicetta(Ricetta ricetta);
}
