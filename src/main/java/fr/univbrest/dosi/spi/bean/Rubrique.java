package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;



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
	@GeneratedValue(generator="MY_SEQ",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="MY_SEQ",sequenceName="RUB_SEQ", allocationSize=1)
	@Column(name="ID_RUBRIQUE")
	private long idRubrique;

	private String designation;
	
	@JsonIgnore
	@Column(name="NO_ENSEIGNANT")
	private BigDecimal noEnseignant;

	private BigInteger ordre;

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

	public BigInteger getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigInteger i) {
		this.ordre =  i;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	

}