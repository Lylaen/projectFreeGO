package it.jaita88.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jaita88.models.Ricetta;
import it.jaita88.models.RicetteIngredienti;
@Repository
public interface RicetteIngredientiRepository extends CrudRepository<RicetteIngredienti, Integer> {
	
	@Query(value="SELECT ricette.id FROM ricette JOIN ricette_ingredienti ON ricette.id=ricette_ingredienti.id_ricetta JOIN ingredienti ON ricette_ingredienti.id_ingrediente=ingredienti.id WHERE ingredienti.nome=?1", nativeQuery = true)
	List<Object> findRicettaByIngrediente(String nomeIngrediente);
}
