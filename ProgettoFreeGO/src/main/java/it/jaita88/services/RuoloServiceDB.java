package it.jaita88.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ruolo;
import it.jaita88.repositories.RuoloRepository;
@Service
public class RuoloServiceDB implements RuoloService{
	@Autowired RuoloRepository repository;

	@Override
	public List<Ruolo> findAllRuoli() {
		return (List<Ruolo>) repository.findAll();
	}

	@Override
	public Ruolo findRuoloById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean deleteRuolo(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
		
	}

	@Override
	public void updateRuolo(Ruolo ruolo, Integer id) {
		if (repository.existsById(id)) {
			Ruolo a = repository.findById(id).get(); 
			a.setNome(ruolo.getNome());
			repository.save(a);
		}
		
	}

	@Override
	public void addRuolo(Ruolo ruolo) {
		repository.save(ruolo);
	}

}
