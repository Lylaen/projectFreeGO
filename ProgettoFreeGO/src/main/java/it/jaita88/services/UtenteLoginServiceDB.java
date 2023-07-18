package it.jaita88.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ricetta;
import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.UtenteLoginRepository;
import it.jaita88.security.SessionUtils;

@Service
public class UtenteLoginServiceDB implements UtenteLoginService{

	@Autowired 
	UtenteLoginRepository repository;
	@Autowired
	RicettaService service;
	@Override
	public List<UtenteLogin> findAllUtenteLogin() {
		return (List<UtenteLogin>) repository.findAll();
	}

	@Override
	public UtenteLogin findUtenteLoginById(String username) {
		return repository.findById(username).get();
	}

	@Override
	public void deleteUtenteLoginById(String username) {
		repository.deleteById(username);
		
	}

	@Override
	public void updateUtenteLogin(UtenteLogin utentelogin, String username) {
		if(repository.existsById(username)) {
			UtenteLogin u = repository.findById(username).get();
			u.setPassword(utentelogin.getPassword());;
			repository.save(u);
		}
	}

	@Override
	public void addUtenteLogin(UtenteLogin utentelogin) {
		repository.saveAndFlush(utentelogin);	
	}

	@Override
	public List<Ricetta> findPreferiti(String username) {
		
		List<Object> res = repository.findPreferiti(username);
		List<Ricetta> preferiti = new ArrayList<>();
		for(int j = 0; j < res.size(); j++) {
			Ricetta ricetta = service.findRicettaById((Integer) res.get(j));
			preferiti.add(ricetta);
		}	
		return preferiti;
	}

	
}
