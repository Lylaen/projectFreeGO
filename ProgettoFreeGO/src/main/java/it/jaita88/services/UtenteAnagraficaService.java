package it.jaita88.services;

import java.util.List;

import it.jaita88.models.UtenteAnagrafica;

public interface UtenteAnagraficaService {

	List<UtenteAnagrafica> findAllUtenteAnagrafica();
	UtenteAnagrafica findUtenteAnagraficaById(String username);
	void deleteUtenteAnagraficaById(String username);
	void updateUtenteAnagrafica(UtenteAnagrafica utenteanagrafica, String username);
	void addUtenteAnagrafica(UtenteAnagrafica utenteanagrafica);

}

