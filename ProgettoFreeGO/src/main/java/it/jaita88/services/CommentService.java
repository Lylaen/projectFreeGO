package it.jaita88.services;

import java.util.List;

import it.jaita88.models.Comment;

public interface CommentService {
	List<Comment> findAllCommenti();
	Comment findCommentById(Integer id);
	void deleteCommentById(Integer id);
	void updateComment(Comment commento, Integer id);
	void addComment(Comment commento);
	List<Comment> commentiByRicetta(Integer idRicetta);
}
