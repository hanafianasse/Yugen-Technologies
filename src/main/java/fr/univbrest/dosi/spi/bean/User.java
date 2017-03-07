package fr.univbrest.dosi.spi.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class User {
	/*
	 * public enum Role { ADMIN, AUCUN, ETUDIANT, PROF }
	 * 
	 * private final Role role = Role.AUCUN;
	 */
	private String username;
	private String pwd;
	private final List<String> roles;

	public User() {
		roles = new ArrayList<String>();
	}

	public List<String> getRoles() {
		return roles;
	}

	public User(final String username, final String pwd, final List<String> roles) {
		this.username = username;
		this.pwd = pwd;
		this.roles = roles;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return this.pwd;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(final String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

}
