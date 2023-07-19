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
import jakarta.persistence.OneToMany;
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
	@Column(name="zimmagine")
	private String zimmagine;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "ricette_ingredienti", 
		joinColumns = {
				@JoinColumn(name = "id_ricetta", 
						referencedColumnName = "id")
		}, inverseJoinColumns = {
				@JoinColumn(name = "id_ingrediente",
						referencedColumnName = "id")
		})
	@JsonIgnore
	private List<Ingrediente> ingredientilist = new ArrayList<>();
	@ManyToMany(mappedBy="preferiti")
	private List<UtenteLogin> utenti = new ArrayList<>();
	@OneToMany(mappedBy = "ricetta",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> commenti = new ArrayList<>();
	
	public Ricetta() {
	}
	
	public Ricetta(Integer id, String nome, String tempo) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
	}

	public Ricetta(Integer id, String nome, String tempo, String zimmagine) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
		this.zimmagine = zimmagine;
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
	
	public String getZimmagine() {
		return zimmagine;
	}

	public void setZimmagine(String zimmagine) {
		this.zimmagine = zimmagine;
	}

	public List<UtenteLogin> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<UtenteLogin> utenti) {
		this.utenti = utenti;
	}

	public List<Ingrediente> getIngredientilist() {
		return ingredientilist;
	}
	public void setIngredientilist(List<Ingrediente> ingredientilist) {
		this.ingredientilist = ingredientilist;
	}
	public void addIngredienti(Ingrediente ingrediente) {
		ingredientilist.add(ingrediente);
	}
	@Override
	public String toString() {
		return "Ricetta [id=" + id + ", nome=" + nome + ", tempo=" + tempo + ", zimmagine=" + zimmagine + "]";
	}

	public void addIngrediente(Ingrediente ingrediente) {
		ingredientilist.add(ingrediente);
	}
	
	
	
	
}
