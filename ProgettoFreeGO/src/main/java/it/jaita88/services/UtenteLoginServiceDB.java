package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.UtenteLoginRepository;

@Service
public class UtenteLoginServiceDB implements UtenteLoginService{

	@Autowired UtenteLoginRepository repository;
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
		repository.save(utentelogin);
		
	}

	
}
