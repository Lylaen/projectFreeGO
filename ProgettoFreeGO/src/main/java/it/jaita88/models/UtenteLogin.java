package it.jaita88.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "utentilogin")
public class UtenteLogin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 727618992890284724L;
	
	@Id
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "utente_login_ricetta",
	 joinColumns = { 
	@JoinColumn(name = "username", 
	referencedColumnName = "username") 
	}, 
	 inverseJoinColumns = { 
	@JoinColumn(name = "id_ricetta", 
	referencedColumnName = "id") 
	})
	private List<Ricetta> preferiti = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "utente_login_ruolo",
	 joinColumns = { 
	@JoinColumn(name = "username", 
	referencedColumnName = "username") 
	}, 
	 inverseJoinColumns = { 
	@JoinColumn(name = "id_ruolo", 
	referencedColumnName = "id") 
	})
	private Set<Ruolo> ruoli = new HashSet<>();
	
	@OneToOne(mappedBy="login", cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	private UtenteAnagrafica utenteanagrafica;
	
	public UtenteLogin() {
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ricetta> getPreferiti() {
		return preferiti;
	}

	public void setPreferiti(List<Ricetta> preferiti) {
		this.preferiti = preferiti;
	}

	public UtenteAnagrafica getUtenteanagrafica() {
		return utenteanagrafica;
	}

	public void setUtenteanagrafica(UtenteAnagrafica utenteanagrafica) {
		this.utenteanagrafica = utenteanagrafica;
	}
	
	public void addRuoli(Ruolo ruolo) {
		ruoli.add(ruolo);
	}
	
	public void addRicetta( Ricetta ricetta) {
		preferiti.add(ricetta);
	}
	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
	
	

	}
	
