package it.jaita88.services;

import java.util.List;

import it.jaita88.models.Ricetta;
import it.jaita88.models.UtenteLogin;

public interface UtenteLoginService {
	List<UtenteLogin> findAllUtenteLogin();
	UtenteLogin findUtenteLoginById(String username);
	void deleteUtenteLoginById(String username);
	void updateUtenteLogin(UtenteLogin utentelogin, String username);
	void addUtenteLogin(UtenteLogin utentelogin);
	List<Ricetta> findPreferiti(String username);
}

