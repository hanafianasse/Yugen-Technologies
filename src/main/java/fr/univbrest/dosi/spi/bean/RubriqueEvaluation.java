package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the RUBRIQUE_EVALUATION database table.
 * 
 */
@Entity
@Table(name="RUBRIQUE_EVALUATION")
@NamedQuery(name="RubriqueEvaluation.findAll", query="SELECT r FROM RubriqueEvaluation r")
public class RubriqueEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@GeneratedValue(generator="REV_SEQ",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="REV_SEQ",sequenceName="REV_SEQ", allocationSize=1)
	@Id
	@Column(name="ID_RUBRIQUE_EVALUATION")
	private long idRubriqueEvaluation;

	private String designation;

	@Column(name="ID_EVALUATION")
	private BigDecimal idEvaluation;

	@Column(name="ID_RUBRIQUE")
	private BigDecimal idRubrique;

	private BigDecimal ordre;

	public RubriqueEvaluation() {
	}

	public long getIdRubriqueEvaluation() {
		return this.idRubriqueEvaluation;
	}

	public void setIdRubriqueEvaluation(long idRubriqueEvaluation) {
		this.idRubriqueEvaluation = idRubriqueEvaluation;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(BigDecimal idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public BigDecimal getIdRubrique() {
		return this.idRubrique;
	}

	public void setIdRubrique(BigDecimal idRubrique) {
		this.idRubrique = idRubrique;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

}