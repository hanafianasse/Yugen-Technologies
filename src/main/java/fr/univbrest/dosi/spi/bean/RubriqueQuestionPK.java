package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the RUBRIQUE_QUESTION database table.
 * 
 */
@Embeddable
public class RubriqueQuestionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_RUBRIQUE", insertable=false, updatable=false)
	private long idRubrique;

	@Column(name="ID_QUESTION", insertable=false, updatable=false)
	private long idQuestion;

	public RubriqueQuestionPK() {
	}
	
	  public RubriqueQuestionPK(long idRubrique, long idQuestion) {
	        this.idRubrique = idRubrique;
	        this.idQuestion = idQuestion;
	    }

	public long getIdRubrique() {
		return this.idRubrique;
	}
	public void setIdRubrique(long idRubrique) {
		this.idRubrique = idRubrique;
	}
	public long getIdQuestion() {
		return this.idQuestion;
	}
	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RubriqueQuestionPK)) {
			return false;
		}
		RubriqueQuestionPK castOther = (RubriqueQuestionPK)other;
		return 
			(this.idRubrique == castOther.idRubrique)
			&& (this.idQuestion == castOther.idQuestion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idRubrique ^ (this.idRubrique >>> 32)));
		hash = hash * prime + ((int) (this.idQuestion ^ (this.idQuestion >>> 32)));
		
		return hash;
	}
}