package it.jaita88.dto;

import java.util.List;

public class IngredienteDto {
	private List<Integer> idIngrediente;
	private List<Integer> grammiml;
	public List<Integer> getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(List<Integer> idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public List<Integer> getGrammiml() {
		return grammiml;
	}
	public void setGrammiml(List<Integer> grammiml) {
		this.grammiml = grammiml;
	}
	public IngredienteDto() {
	}
	public IngredienteDto(List<Integer> idIngrediente, List<Integer> grammiml) {
		this.idIngrediente = idIngrediente;
		this.grammiml = grammiml;
	}
	@Override
	public String toString() {
		return "IngredienteDto [idIngrediente=" + idIngrediente + ", grammiml=" + grammiml + "]";
	}
	
	
}
