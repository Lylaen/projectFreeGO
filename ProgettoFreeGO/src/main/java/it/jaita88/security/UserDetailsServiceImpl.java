package it.jaita88.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.jaita88.models.Ruolo;
import it.jaita88.models.UtenteLogin;
import it.jaita88.repositories.UtenteLoginRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UtenteLoginRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtenteLogin utente = repository.findByUsername(username);
		System.err.println("utente dal DB= " + utente);
		if(utente == null) {
			throw new UsernameNotFoundException("Utente non trovato.");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Ruolo ruolo : utente.getRuoli()) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + ruolo.getNome()));
		}
		User user = new User(utente.getUsername(), utente.getPassword(), grantedAuthorities);
		System.err.println("user" + user);
		SessionUtils.setUsernameAndRoles(user);
		return user;
	}
	
	
}
