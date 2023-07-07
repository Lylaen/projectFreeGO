package it.jaita88.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "intolleranze")
public class Intolleranza {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@ManyToMany(mappedBy = "intolleranze")
	private List<Ingrediente> ingredienti = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	public void addIngrediente(Ingrediente ingrediente) {
		ingredienti.add(ingrediente);
	}
	@Override
	public String toString() {
		return "Intolleranza [id=" + id + ", nome=" + nome + ", ingredienti=" + ingredienti + "]";
	}
	
}
