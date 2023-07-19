package it.jaita88.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.jaita88.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query(value="SELECT id FROM comment WHERE id_ricetta=?1", nativeQuery=true)
	List<Object> commentiByRicetta(Integer idRicetta);
}
