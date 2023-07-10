package it.jaita88.services;

import java.util.List;

import it.jaita88.models.Ruolo;

public interface RuoloService {
	List<Ruolo> findAllRuoli();
	Ruolo findRuoloById(Integer id);
	boolean deleteRuolo(Integer id);
	void updateRuolo(Ruolo ruolo, Integer id);
	void addRuolo(Ruolo ruolo);
}

