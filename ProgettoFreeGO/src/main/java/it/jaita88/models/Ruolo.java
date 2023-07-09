package it.jaita88.models;

import java.io.Serializable;
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
@Table(name = "ruoli")
public class Ruolo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6614029386470280841L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "ruoli")
	private List<UtenteLogin> utenti = new ArrayList<>();
	
	public Ruolo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}


	public Ruolo() {
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


	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
