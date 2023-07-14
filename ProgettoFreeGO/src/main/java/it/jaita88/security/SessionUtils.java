package it.jaita88.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {
	
	public static String getUserRole() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession();
		Set<GrantedAuthority> grantedAuthorities = (Set<GrantedAuthority>) session.getAttribute("ruoli");
		List<GrantedAuthority> ruoli = new ArrayList<>(grantedAuthorities);
		String ruolo = ruoli.get(0).toString();	
		return ruolo;
	}
	public static List<String> getUserRoles() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession();
		Set<GrantedAuthority> grantedAuthorities = (Set<GrantedAuthority>) session.getAttribute("ruoli");
		List<String> nomiRuoli = new ArrayList<>();
		if(grantedAuthorities != null) {
			List<GrantedAuthority> ruoli = new ArrayList<>(grantedAuthorities);			
			for (int i = 0; i < ruoli.size(); i++) {
				nomiRuoli.add(ruoli.get(i).toString());
			}	
		}		
		return nomiRuoli;
	}
	public static String getUserUsername() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		return username;
	}
	public static void setUsernameAndRoles(User user) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession();
		session.setAttribute("username", user.getUsername());
		session.setAttribute("ruoli", user.getAuthorities());
	}
	public static boolean isAdmin() {
		if(getUserRoles()!= null) {
			for (String r: getUserRoles()) {
				if (r.equals("ROLE_ADMIN")) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public static boolean isUser() {
		if(getUserRoles()!= null) {
		for (String r: getUserRoles()) {
			if (r.equals("ROLE_USER")) {
				return true;
			}
		}
		return false;	
	}
		return false;
	}
	public static void invalidateSession() {
		// Invalida la sessione
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession();
	    session.invalidate();

	    // Rimuove il cookie di sessione
	    Cookie[] cookies = attr.getRequest().getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("JSESSIONID")) {
	                cookie.setValue("");
	                cookie.setPath("/");
	                cookie.setMaxAge(0);
	                attr.getResponse().addCookie(cookie);
	                break;
	            }
	        }
	    }
	}
}
