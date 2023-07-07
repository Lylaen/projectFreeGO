package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Intolleranza;
import it.jaita88.repositories.IntolleranzaRepository;
@Service
public class IntolleranzaServiceDB implements IntolleranzaService{
	@Autowired
	IntolleranzaRepository repository;
	@Override
	public List<Intolleranza> findAllIntolleranze() {
		return(List<Intolleranza>)repository.findAll();
	}

	@Override
	public Intolleranza findIntolleranzaById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteIntolleranzaById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateIntolleranza(Intolleranza intolleranza, Integer id) {
		if(repository.existsById(id)) {
			Intolleranza i = repository.findById(id).get();
			i.setNome(intolleranza.getNome());
			repository.save(i);
		}
	}

	@Override
	public void addIntolleranza(Intolleranza intolleranza) {
		repository.save(intolleranza);
	}

}
