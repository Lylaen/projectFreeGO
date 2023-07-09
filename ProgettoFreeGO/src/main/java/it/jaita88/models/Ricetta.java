package it.jaita88.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ricette")
public class Ricetta{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tempo")
	private String tempo;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "ricette_ingredienti", 
		joinColumns = {
				@JoinColumn(name = "id_ricetta", 
						referencedColumnName = "id")
		}, inverseJoinColumns = {
				@JoinColumn(name = "id_ingrediente",
						referencedColumnName = "id")
		})
	private List<Ingrediente> ingredientilist = new ArrayList<>();
	
	public Ricetta() {
	}
	
	public Ricetta(Integer id, String nome, String tempo) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
	}

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
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public List<Ingrediente> getIngredientilist() {
		return ingredientilist;
	}
	public void setIngredientilist(List<Ingrediente> ingredientilist) {
		this.ingredientilist = ingredientilist;
	}
	@Override
	public String toString() {
		return "Ricetta [id=" + id + ", nome=" + nome + ", tempo=" + tempo + ", ingredientilist=" + ingredientilist
				+ "]";
	}
	public void addIngrediente(Ingrediente ingrediente) {
		ingredientilist.add(ingrediente);
	}
	
	
	
	
}
