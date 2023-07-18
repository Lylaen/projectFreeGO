package it.jaita88.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.jaita88.models.UtenteLogin;

public interface UtenteLoginRepository extends JpaRepository <UtenteLogin, String> {
	UtenteLogin findByUsername(String username);
	@Query(value="SELECT id_ricetta FROM utente_login_ricetta WHERE username=?1", nativeQuery = true)
	List<Object> findPreferiti(String username);
}
