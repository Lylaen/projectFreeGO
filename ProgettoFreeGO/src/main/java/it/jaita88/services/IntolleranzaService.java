package it.jaita88.services;

import java.util.List;

import it.jaita88.models.Intolleranza;

public interface IntolleranzaService {
	List<Intolleranza> findAllIntolleranze();
	Intolleranza findIntolleranzaById(Integer id);
	void deleteIntolleranzaById(Integer id);
	void updateIntolleranza(Intolleranza intolleranza, Integer id);
	void addIntolleranza(Intolleranza intolleranza);
}
