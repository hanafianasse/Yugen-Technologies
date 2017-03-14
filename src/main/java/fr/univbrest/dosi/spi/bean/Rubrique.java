package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.istack.NotNull;

import java.math.BigDecimal;



/**
 * The persistent class for the RUBRIQUE database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Rubrique.findAll", query = "SELECT r FROM Rubrique r"),
	 })

public class Rubrique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RUBRIQUE")
	private long idRubrique;

	private String designation;

	@Column(name="NO_ENSEIGNANT")
	private BigDecimal noEnseignant;

	private BigDecimal ordre;

	@Column(name="TYPE")
	private String type;

	public Rubrique() {
	}

	public long getIdRubrique() {
		return this.idRubrique;
	}

	public void setIdRubrique(long idRubrique) {
		this.idRubrique = idRubrique;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getNoEnseignant() {
		return this.noEnseignant;
	}

	public void setNoEnseignant(BigDecimal noEnseignant) {
		this.noEnseignant = noEnseignant;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	

}