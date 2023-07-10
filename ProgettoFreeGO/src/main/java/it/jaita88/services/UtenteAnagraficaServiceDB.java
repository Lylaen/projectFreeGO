package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.UtenteAnagrafica;
import it.jaita88.repositories.UtenteAnagraficaRepository;

@Service
public class UtenteAnagraficaServiceDB implements UtenteAnagraficaService{

	@Autowired UtenteAnagraficaRepository repository;
	@Override
	public List<UtenteAnagrafica> findAllUtenteAnagrafica() {
		return (List<UtenteAnagrafica>) repository.findAll();
	}

	@Override
	public UtenteAnagrafica findUtenteAnagraficaById(String username) {
		return repository.findById(username).get();
			}

	@Override
	public void deleteUtenteAnagraficaById(String username) {
		repository.deleteById(username);
		
	}

	@Override
	public void updateUtenteAnagrafica(UtenteAnagrafica utenteanagrafica, String username) {
		if(repository.existsById(username)) {
			UtenteAnagrafica u = repository.findById(username).get();
			u.setNome(utenteanagrafica.getNome());
			u.setCognome(utenteanagrafica.getCognome());
			u.setEmail(utenteanagrafica.getEmail());
			repository.save(u);
		}
	}

	@Override
	public void addUtenteAnagrafica(UtenteAnagrafica utenteanagrafica) {
		repository.save(utenteanagrafica);
	}

	

	

}
