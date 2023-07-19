package it.jaita88.dto;

public class CommentDto {
	private String titolo;
	private String testo;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	@Override
	public String toString() {
		return "CommentDto [titolo=" + titolo + ", testo=" + testo + "]";
	}
	
	
}
