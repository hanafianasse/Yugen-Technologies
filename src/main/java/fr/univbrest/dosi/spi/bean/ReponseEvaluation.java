package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REPONSE_EVALUATION database table.
 * 
 */
@Entity
@Table(name="REPONSE_EVALUATION")
@NamedQuery(name="ReponseEvaluation.findAll", query="SELECT r FROM ReponseEvaluation r")
public class ReponseEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="RPE_SEQ",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="RPE_SEQ",sequenceName="RPE_SEQ", allocationSize=1)
	@Column(name="ID_REPONSE_EVALUATION")
	private long idReponseEvaluation;

	private String commentaire;

	@Column(name="ID_EVALUATION")
	private java.math.BigDecimal idEvaluation;

	@Column(name="NO_ETUDIANT")
	private String noEtudiant;

	private String nom;

	private String prenom;

	public ReponseEvaluation() {
	}

	public long getIdReponseEvaluation() {
		return this.idReponseEvaluation;
	}

	public void setIdReponseEvaluation(long idReponseEvaluation) {
		this.idReponseEvaluation = idReponseEvaluation;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public java.math.BigDecimal getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(java.math.BigDecimal idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getNoEtudiant() {
		return this.noEtudiant;
	}

	public void setNoEtudiant(String noEtudiant) {
		this.noEtudiant = noEtudiant;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}