package it.jaita88.models;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RicetteIngredientiKey implements Serializable{
	
	
	private static final long serialVersionUID = 8975341127847174798L;
	
	private Integer id_ingrediente;
	
	private Integer id_ricetta;
	
	
	public Integer getId_ricetta() {
		return id_ricetta;
	}
	public void setId_ricetta(Integer id_ricetta) {
		this.id_ricetta = id_ricetta;
	}
	public Integer getId_ingrediente() {
		return id_ingrediente;
	}
	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_ingrediente, id_ricetta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RicetteIngredientiKey other = (RicetteIngredientiKey) obj;
		return Objects.equals(id_ingrediente, other.id_ingrediente) && Objects.equals(id_ricetta, other.id_ricetta);
	}
	
	
	
}
