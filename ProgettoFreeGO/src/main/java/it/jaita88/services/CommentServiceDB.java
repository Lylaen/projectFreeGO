package it.jaita88.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.models.Comment;
import it.jaita88.repositories.CommentRepository;
@Service
public class CommentServiceDB implements CommentService{
	@Autowired
	CommentRepository repository;
	@Override
	public List<Comment> findAllCommenti() {
		return (List<Comment>)repository.findAll();
	}

	@Override
	public Comment findCommentById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteCommentById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public void updateComment(Comment commento, Integer id) {
		if(repository.existsById(id)) {
			Comment c = repository.findById(id).get();
			c.setTitolo(commento.getTitolo());
			c.setTesto(commento.getTesto());
			repository.save(c);
		}
		
	}

	@Override
	public void addComment(Comment commento) {
		repository.save(commento);
		
	}

	@Override
	public List<Comment> commentiByRicetta(Integer idRicetta) {
		List<Object> res = repository.commentiByRicetta(idRicetta);
		List<Comment> commenti = new ArrayList<>();
		for(int j = 0; j < res.size(); j++) {
			Comment commento = findCommentById((Integer) res.get(j));
			commenti.add(commento);
		}
		
		return commenti;
	}

}
