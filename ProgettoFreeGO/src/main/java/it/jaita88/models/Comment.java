package it.jaita88.models;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"},
        allowGetters = true)
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="titolo")
    private String titolo;
    @Column(name="testo")
    private String testo;
    
   

    public Integer getId() {
        return id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",
    referencedColumnName = "username") 
    private UtenteLogin utente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ricetta",
    referencedColumnName = "id") 
    private Ricetta ricetta;

	public Comment() {
	}

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

	

	

	public UtenteLogin getUtente() {
		return utente;
	}

	public void setUtente(UtenteLogin utente) {
		this.utente = utente;
	}

	public Ricetta getRicetta() {
		return ricetta;
	}

	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
