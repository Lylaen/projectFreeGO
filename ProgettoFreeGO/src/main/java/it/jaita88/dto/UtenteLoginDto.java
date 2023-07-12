package it.jaita88.dto;

public class UtenteLoginDto {
	
	private String username;
	private String password;
	public UtenteLoginDto() {
	}
	public UtenteLoginDto(String username, String password) {
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "UtenteDto [username=" + username + ", password=" + password + "]";
	}
	
}
