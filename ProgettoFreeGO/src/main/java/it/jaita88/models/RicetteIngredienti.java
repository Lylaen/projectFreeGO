package it.jaita88.models;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ricette_ingredienti")
public class RicetteIngredienti implements Serializable{
	
	private static final long serialVersionUID = 153916224183021022L;


	@EmbeddedId
	private RicetteIngredientiKey id = new RicetteIngredientiKey();
	
	
	@Column(name = "grammiml")
	private Integer grammiml;


	public RicetteIngredientiKey getId() {
		return id;
	}
	public void setId(RicetteIngredientiKey id) {
		this.id = id;
	}
	public Integer getGrammiml() {
		return grammiml;
	}
	public void setGrammiml(Integer grammiml) {
		this.grammiml = grammiml;
	}
}
