package it.jaita88.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "anagrafica")
public class UtenteAnagrafica implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = -4462440981323031993L;
	@Id
	@Column(name="username_utente")
	private String username;
	
	@Column(name = "nome")
		private String nome;
	@Column(name = "cognome")
		private String cognome;
	@Column(name = "email")
		private String email;
		
		@OneToOne
		@MapsId
		@JoinColumn(name="username_utente")
		private UtenteLogin login;
		
		public UtenteAnagrafica() {
		}
		
		public UtenteAnagrafica(String username, String nome, String cognome, String email, UtenteLogin login) {
			this.username = username;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.login = login;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public UtenteLogin getUtentelogin() {
			return login;
		}

		public void setUtentelogin(UtenteLogin utentelogin) {
			this.login = utentelogin;
		}

		@Override
		public String toString() {
			return "UtenteAnagrafica [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", email="
					+ email + ", login=" + login + "]";
		}
		
		
}
