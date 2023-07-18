package it.jaita88.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "ingredienti")
public class Ingrediente{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@ManyToMany(mappedBy = "ingredientilist")
	@JsonIgnore
	private List<Ricetta> ricette = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "ingredienti_intolleranze", 
			joinColumns = {
					@JoinColumn(name = "id_ingrediente", referencedColumnName = "id")
			}, inverseJoinColumns = {
					@JoinColumn(name = "id_intolleranza", referencedColumnName = "id")
			})
	private List<Intolleranza> intolleranze = new ArrayList<>();

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

	public List<Ricetta> getRicette() {
		return ricette;
	}

	public void setRicette(List<Ricetta> ricette) {
		this.ricette = ricette;
	}

	public List<Intolleranza> getIntolleranze() {
		return intolleranze;
	}

	public void setIntolleranze(List<Intolleranza> intolleranze) {
		this.intolleranze = intolleranze;
	}
	public void addRicetta(Ricetta ricetta) {
		ricette.add(ricetta);
	}
	public void addIntolleranza(Intolleranza intolleranza) {
		intolleranze.add(intolleranza);
	}
	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", ricette=" + ricette + ", intolleranze=" + intolleranze
				+ "]";
	}
	
	
	
}
