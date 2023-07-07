package it.jaita88.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ingrediente;
import it.jaita88.repositories.IngredienteRepository;
@Service
public class IngredienteServiceDB implements IngredienteService{
	@Autowired
	IngredienteRepository repository;
	@Override
	public List<Ingrediente> findAllIngredienti() {
		return (List<Ingrediente>) repository.findAll();
	}

	@Override
	public Ingrediente findIngredienteById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteIngredienteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public void updateIngrediente(Ingrediente ingrediente, Integer id) {
		if(repository.existsById(id)) {
			Ingrediente i = repository.findById(id).get();
			i.setNome(ingrediente.getNome());
			repository.save(i);
		}
	}

	@Override
	public void addIngrediente(Ingrediente ingrediente) {
		repository.save(ingrediente);		
	}

}
