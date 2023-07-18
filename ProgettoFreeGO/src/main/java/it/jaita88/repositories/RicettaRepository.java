package it.jaita88.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.jaita88.models.Ricetta;
import jakarta.transaction.Transactional;

public interface RicettaRepository extends CrudRepository<Ricetta, Integer>{
	@Modifying
	@Transactional
	@Query(value="UPDATE ricette_ingredienti SET grammiml =?1 WHERE id_ingrediente=?2 AND id_ricetta=?3", nativeQuery = true)
	void updateIngredienti(Integer grammiml, Integer idIngrediente, Integer idRicetta);
}
