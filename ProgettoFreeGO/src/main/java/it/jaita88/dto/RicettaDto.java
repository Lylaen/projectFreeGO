package it.jaita88.dto;

import java.util.List;
import java.util.Map;

public class RicettaDto {

	private String nome;
	private String tempo;
	private String zimmagine;
	private Integer grammiml;
	private List<Integer> ingredientiId;
	private List<Integer> ingrammi;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getGrammiml() {
		return grammiml;
	}
	public void setGrammiml(Integer grammiml) {
		this.grammiml = grammiml;
	}
	public String getZimmagine() {
		return zimmagine;
	}
	public void setZimmagine(String zimmagine) {
		this.zimmagine = zimmagine;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public List<Integer> getIngredientiId() {
		return ingredientiId;
	}
	public void setIngredientiId(List<Integer> ingredientiId) {
		this.ingredientiId = ingredientiId;
	}
	public List<Integer> getIngrammi() {
		return ingrammi;
	}
	public void setIngrammi(List<Integer> ingrammi) {
		this.ingrammi = ingrammi;
	}
	public RicettaDto(String nome, String tempo, List<Integer> ingredientiId) {
		
		this.nome = nome;
		this.tempo = tempo;
		this.ingredientiId = ingredientiId;
	}
	public RicettaDto() {
	}
	
	
}
