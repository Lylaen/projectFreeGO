package it.jaita88.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import it.jaita88.models.RicetteIngredienti;
@Repository
public interface RicetteIngredientiRepository extends CrudRepository<RicetteIngredienti, Integer> {
	
	@Query(value="SELECT ricette.id FROM ricette JOIN ricette_ingredienti ON ricette.id=ricette_ingredienti.id_ricetta JOIN ingredienti ON ricette_ingredienti.id_ingrediente=ingredienti.id JOIN ingredienti_intolleranze ON ingredienti.id=ingredienti_intolleranze.id_ingrediente JOIN intolleranze ON ingredienti_intolleranze.id_intolleranza=intolleranze.id WHERE (?1 IS NULL OR ingredienti.nome=?1) AND (?2 IS NULL OR ricette.tempo <= ?2) AND (?3 IS NULL OR ricette_ingredienti.grammiml <= ?3) AND (?4 IS NULL OR intolleranze.nome!=?4) AND (?5 IS NULL OR intolleranze.nome!=?5)", nativeQuery = true)
	List<Object> findRicettaByFilter(String nomeIngrediente, Integer tempo, Integer grammiml, String nomeIntolleranza, String nomeIntolleranza2);
}
