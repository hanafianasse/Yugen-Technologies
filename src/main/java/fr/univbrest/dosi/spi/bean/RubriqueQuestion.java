package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the RUBRIQUE_QUESTION database table.
 * 
 */
@Entity
@Table(name="RUBRIQUE_QUESTION")
@NamedQuery(name="RubriqueQuestion.findAll", query="SELECT r FROM RubriqueQuestion r")
public class RubriqueQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RubriqueQuestionPK id;

	private BigDecimal ordre;

	public RubriqueQuestion() {
	}

	public RubriqueQuestionPK getId() {
		return this.id;
	}

	public void setId(RubriqueQuestionPK id) {
		this.id = id;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

}