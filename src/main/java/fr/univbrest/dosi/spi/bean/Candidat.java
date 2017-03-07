/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "CANDIDAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c"),
    @NamedQuery(name = "Candidat.findByNoCandidat", query = "SELECT c FROM Candidat c WHERE c.noCandidat = :noCandidat"),
    @NamedQuery(name = "Candidat.findByNom", query = "SELECT c FROM Candidat c WHERE c.nom = :nom"),
    @NamedQuery(name = "Candidat.findByPrenom", query = "SELECT c FROM Candidat c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Candidat.findBySexe", query = "SELECT c FROM Candidat c WHERE c.sexe = :sexe"),
    @NamedQuery(name = "Candidat.findByDateNaissance", query = "SELECT c FROM Candidat c WHERE c.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Candidat.findByLieuNaissance", query = "SELECT c FROM Candidat c WHERE c.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Candidat.findByNationalite", query = "SELECT c FROM Candidat c WHERE c.nationalite = :nationalite"),
    @NamedQuery(name = "Candidat.findByTelephone", query = "SELECT c FROM Candidat c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Candidat.findByMobile", query = "SELECT c FROM Candidat c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "Candidat.findByEmail", query = "SELECT c FROM Candidat c WHERE c.email = :email"),
    @NamedQuery(name = "Candidat.findByAdresse", query = "SELECT c FROM Candidat c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Candidat.findByCodePostal", query = "SELECT c FROM Candidat c WHERE c.codePostal = :codePostal"),
    @NamedQuery(name = "Candidat.findByVille", query = "SELECT c FROM Candidat c WHERE c.ville = :ville"),
    @NamedQuery(name = "Candidat.findByPaysOrigine", query = "SELECT c FROM Candidat c WHERE c.paysOrigine = :paysOrigine"),
    @NamedQuery(name = "Candidat.findByUniversiteOrigine", query = "SELECT c FROM Candidat c WHERE c.universiteOrigine = :universiteOrigine"),
    @NamedQuery(name = "Candidat.findByListeSelection", query = "SELECT c FROM Candidat c WHERE c.listeSelection = :listeSelection"),
    @NamedQuery(name = "Candidat.findBySelectionNoOrdre", query = "SELECT c FROM Candidat c WHERE c.selectionNoOrdre = :selectionNoOrdre"),
    @NamedQuery(name = "Candidat.findByConfirmationCandidat", query = "SELECT c FROM Candidat c WHERE c.confirmationCandidat = :confirmationCandidat"),
    @NamedQuery(name = "Candidat.findByDateReponseCandidat", query = "SELECT c FROM Candidat c WHERE c.dateReponseCandidat = :dateReponseCandidat")})
public class Candidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NO_CANDIDAT")
    private String noCandidat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXE")
    private String sexe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NATIONALITE")
    private String nationalite;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 10)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "VILLE")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PAYS_ORIGINE")
    private String paysOrigine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "UNIVERSITE_ORIGINE")
    private String universiteOrigine;
    @Size(max = 6)
    @Column(name = "LISTE_SELECTION")
    private String listeSelection;
    @Column(name = "SELECTION_NO_ORDRE")
    private BigInteger selectionNoOrdre;
    @Column(name = "CONFIRMATION_CANDIDAT")
    private Character confirmationCandidat;
    @Column(name = "DATE_REPONSE_CANDIDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseCandidat;
    @JsonManagedReference(value="promotion-candidat")
    @JoinColumns({
        @JoinColumn(name = "ANNEE_UNIVERSITAIRE", referencedColumnName = "ANNEE_UNIVERSITAIRE"),
        @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")})
    @ManyToOne(optional = false)
    private Promotion promotion;

    public Candidat() {
    }

    public Candidat(String noCandidat) {
        this.noCandidat = noCandidat;
    }

    public Candidat(String noCandidat, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, String email, String adresse, String ville, String paysOrigine, String universiteOrigine) {
        this.noCandidat = noCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.paysOrigine = paysOrigine;
        this.universiteOrigine = universiteOrigine;
    }

    public String getNoCandidat() {
        return noCandidat;
    }

    public void setNoCandidat(String noCandidat) {
        this.noCandidat = noCandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public String getUniversiteOrigine() {
        return universiteOrigine;
    }

    public void setUniversiteOrigine(String universiteOrigine) {
        this.universiteOrigine = universiteOrigine;
    }

    public String getListeSelection() {
        return listeSelection;
    }

    public void setListeSelection(String listeSelection) {
        this.listeSelection = listeSelection;
    }

    public BigInteger getSelectionNoOrdre() {
        return selectionNoOrdre;
    }

    public void setSelectionNoOrdre(BigInteger selectionNoOrdre) {
        this.selectionNoOrdre = selectionNoOrdre;
    }

    public Character getConfirmationCandidat() {
        return confirmationCandidat;
    }

    public void setConfirmationCandidat(Character confirmationCandidat) {
        this.confirmationCandidat = confirmationCandidat;
    }

    public Date getDateReponseCandidat() {
        return dateReponseCandidat;
    }

    public void setDateReponseCandidat(Date dateReponseCandidat) {
        this.dateReponseCandidat = dateReponseCandidat;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCandidat != null ? noCandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.noCandidat == null && other.noCandidat != null) || (this.noCandidat != null && !this.noCandidat.equals(other.noCandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Candidat[ noCandidat=" + noCandidat + " ]";
    }
    
}
