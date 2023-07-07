package it.jaita88.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.jaita88.models.Ingrediente;

public interface IngredienteService {
	List<Ingrediente> findAllIngredienti();
	Ingrediente findIngredienteById(Integer id);
	void deleteIngredienteById(Integer id);
	void updateIngrediente(Ingrediente ingrediente, Integer id);
	void addIngrediente(Ingrediente ingrediente);
}
