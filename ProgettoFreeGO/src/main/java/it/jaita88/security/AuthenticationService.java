package it.jaita88.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationService {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	
    public boolean authenticate(String username, String password) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        System.err.println("authenticationToken=" + authenticationToken); //debug
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        System.err.println("authentication=" + authentication); //debug
        return authentication.isAuthenticated();
    }
    
}
