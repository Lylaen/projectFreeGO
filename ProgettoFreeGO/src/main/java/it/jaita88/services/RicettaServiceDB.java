package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.jaita88.models.Ricetta;
import it.jaita88.repositories.RicettaRepository;

public class RicettaServiceDB implements RicettaService{
	@Autowired
	RicettaRepository repository;
	@Override
	public List<Ricetta> findAllRicette() {
		return (List<Ricetta>)repository.findAll();
	}

	@Override
	public Ricetta findRicettaById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteRicettaById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateRicetta(Ricetta ricetta, Integer id) {
		if(repository.existsById(id)) {
			Ricetta r = repository.findById(id).get();
			r.setNome(ricetta.getNome());
			r.setTempo(ricetta.getTempo());
			repository.save(r);
		}
	}

	@Override
	public void addRicetta(Ricetta ricetta) {
		repository.save(ricetta);
	}

}
