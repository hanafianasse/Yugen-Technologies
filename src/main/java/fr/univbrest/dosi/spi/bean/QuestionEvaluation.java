package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the QUESTION_EVALUATION database table.
 * 
 */
@Entity
@Table(name="QUESTION_EVALUATION")
@NamedQuery(name="QuestionEvaluation.findAll", query="SELECT q FROM QuestionEvaluation q")
public class QuestionEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_qev")
	@SequenceGenerator(name = "my_seq_qev", sequenceName = "QEV_SEQ")
	@Column(name="ID_QUESTION_EVALUATION")
	private long idQuestionEvaluation;

	@Column(name="ID_QUALIFICATIF")
	private BigDecimal idQualificatif;

	@Column(name="ID_QUESTION")
	private BigDecimal idQuestion;

	@Column(name="ID_RUBRIQUE_EVALUATION")
	private BigDecimal idRubriqueEvaluation;

	private String intitule;

	private BigDecimal ordre;

	public QuestionEvaluation() {
	}

	public long getIdQuestionEvaluation() {
		return this.idQuestionEvaluation;
	}

	public void setIdQuestionEvaluation(long idQuestionEvaluation) {
		this.idQuestionEvaluation = idQuestionEvaluation;
	}

	public BigDecimal getIdQualificatif() {
		return this.idQualificatif;
	}

	public void setIdQualificatif(BigDecimal idQualificatif) {
		this.idQualificatif = idQualificatif;
	}

	public BigDecimal getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(BigDecimal idQuestion) {
		this.idQuestion = idQuestion;
	}

	public BigDecimal getIdRubriqueEvaluation() {
		return this.idRubriqueEvaluation;
	}

	public void setIdRubriqueEvaluation(BigDecimal idRubriqueEvaluation) {
		this.idRubriqueEvaluation = idRubriqueEvaluation;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

}