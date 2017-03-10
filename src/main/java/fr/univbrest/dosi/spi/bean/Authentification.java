package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AUTHENTIFICATION database table.
 * 
 */
@Entity
@NamedQuery(name="Authentification.findAll", query="SELECT a FROM Authentification a")
public class Authentification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CONNECTION")
	private long idConnection;

	@Column(name="LOGIN_CONNECTION")
	private String loginConnection;

	@Column(name="MOT_PASSE")
	private String motPasse;

	@Column(name="NO_ENSEIGNANT")
	private java.math.BigDecimal noEnseignant;

	@Column(name="NO_ETUDIANT")
	private String noEtudiant;

	@Column(name="PSEUDO_CONNECTION")
	private String pseudoConnection;

	@Column(name="ROLE")
	private String role;

	public Authentification() {
	}

	public long getIdConnection() {
		return this.idConnection;
	}

	public void setIdConnection(long idConnection) {
		this.idConnection = idConnection;
	}

	public String getLoginConnection() {
		return this.loginConnection;
	}

	public void setLoginConnection(String loginConnection) {
		this.loginConnection = loginConnection;
	}

	public String getMotPasse() {
		return this.motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public java.math.BigDecimal getNoEnseignant() {
		return this.noEnseignant;
	}

	public void setNoEnseignant(java.math.BigDecimal noEnseignant) {
		this.noEnseignant = noEnseignant;
	}

	public String getNoEtudiant() {
		return this.noEtudiant;
	}

	public void setNoEtudiant(String noEtudiant) {
		this.noEtudiant = noEtudiant;
	}

	public String getPseudoConnection() {
		return this.pseudoConnection;
	}

	public void setPseudoConnection(String pseudoConnection) {
		this.pseudoConnection = pseudoConnection;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}