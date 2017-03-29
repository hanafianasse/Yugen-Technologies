package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REPONSE_QUESTION database table.
 * 
 */
@Embeddable
public class ReponseQuestionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_REPONSE_EVALUATION", insertable=false, updatable=false)
	private long idReponseEvaluation;

	@Column(name="ID_QUESTION_EVALUATION", insertable=false, updatable=false)
	private long idQuestionEvaluation;

	public ReponseQuestionPK(long idReponseEvaluation, long idQuestionEvaluation) {
		super();
		this.idReponseEvaluation = idReponseEvaluation;
		this.idQuestionEvaluation = idQuestionEvaluation;
	}
	public ReponseQuestionPK() {
	}
	public long getIdReponseEvaluation() {
		return this.idReponseEvaluation;
	}
	public void setIdReponseEvaluation(long idReponseEvaluation) {
		this.idReponseEvaluation = idReponseEvaluation;
	}
	public long getIdQuestionEvaluation() {
		return this.idQuestionEvaluation;
	}
	public void setIdQuestionEvaluation(long idQuestionEvaluation) {
		this.idQuestionEvaluation = idQuestionEvaluation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReponseQuestionPK)) {
			return false;
		}
		ReponseQuestionPK castOther = (ReponseQuestionPK)other;
		return 
			(this.idReponseEvaluation == castOther.idReponseEvaluation)
			&& (this.idQuestionEvaluation == castOther.idQuestionEvaluation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idReponseEvaluation ^ (this.idReponseEvaluation >>> 32)));
		hash = hash * prime + ((int) (this.idQuestionEvaluation ^ (this.idQuestionEvaluation >>> 32)));
		
		return hash;
	}
}