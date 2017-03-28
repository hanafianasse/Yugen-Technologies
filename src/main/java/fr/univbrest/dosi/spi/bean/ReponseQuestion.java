package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REPONSE_QUESTION database table.
 * 
 */
@Entity
@Table(name="REPONSE_QUESTION")
@NamedQuery(name="ReponseQuestion.findAll", query="SELECT r FROM ReponseQuestion r")
public class ReponseQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReponseQuestionPK id;

	private BigDecimal positionnement;

	public ReponseQuestion() {
	}

	public ReponseQuestionPK getId() {
		return this.id;
	}

	public void setId(ReponseQuestionPK id) {
		this.id = id;
	}

	public BigDecimal getPositionnement() {
		return this.positionnement;
	}

	public void setPositionnement(BigDecimal positionnement) {
		this.positionnement = positionnement;
	}

}