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
@Table(name = "ETUDIANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByNoEtudiant", query = "SELECT e FROM Etudiant e WHERE e.noEtudiant = :noEtudiant"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByPrenom", query = "SELECT e FROM Etudiant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findBySexe", query = "SELECT e FROM Etudiant e WHERE e.sexe = :sexe"),
    @NamedQuery(name = "Etudiant.findByDateNaissance", query = "SELECT e FROM Etudiant e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Etudiant.findByLieuNaissance", query = "SELECT e FROM Etudiant e WHERE e.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Etudiant.findByNationalite", query = "SELECT e FROM Etudiant e WHERE e.nationalite = :nationalite"),
    @NamedQuery(name = "Etudiant.findByTelephone", query = "SELECT e FROM Etudiant e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Etudiant.findByMobile", query = "SELECT e FROM Etudiant e WHERE e.mobile = :mobile"),
    @NamedQuery(name = "Etudiant.findByEmail", query = "SELECT e FROM Etudiant e WHERE e.email = :email"),
    @NamedQuery(name = "Etudiant.findByEmailUbo", query = "SELECT e FROM Etudiant e WHERE e.emailUbo = :emailUbo"),
    @NamedQuery(name = "Etudiant.findByAdresse", query = "SELECT e FROM Etudiant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Etudiant.findByCodePostal", query = "SELECT e FROM Etudiant e WHERE e.codePostal = :codePostal"),
    @NamedQuery(name = "Etudiant.findByVille", query = "SELECT e FROM Etudiant e WHERE e.ville = :ville"),
    @NamedQuery(name = "Etudiant.findByPaysOrigine", query = "SELECT e FROM Etudiant e WHERE e.paysOrigine = :paysOrigine"),
    @NamedQuery(name = "Etudiant.findByUniversiteOrigine", query = "SELECT e FROM Etudiant e WHERE e.universiteOrigine = :universiteOrigine"),
    @NamedQuery(name = "Etudiant.findByGroupeTp", query = "SELECT e FROM Etudiant e WHERE e.groupeTp = :groupeTp"),
    @NamedQuery(name = "Etudiant.findByGroupeAnglais", query = "SELECT e FROM Etudiant e WHERE e.groupeAnglais = :groupeAnglais")})
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NO_ETUDIANT")
    private String noEtudiant;
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
    @Size(max = 255)
    @Column(name = "EMAIL_UBO")
    private String emailUbo;
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
    @Column(name = "GROUPE_TP")
    private BigInteger groupeTp;
    @Column(name = "GROUPE_ANGLAIS")
    private BigInteger groupeAnglais;
    @JsonManagedReference(value="promotion-etudiant")
    @JoinColumns({
        @JoinColumn(name = "ANNEE_UNIVERSITAIRE", referencedColumnName = "ANNEE_UNIVERSITAIRE"),
        @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")})
    @ManyToOne(optional = false)
    private Promotion promotion;

    public Etudiant() {
    }

    public Etudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public Etudiant(String noEtudiant, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, String email, String adresse, String ville, String paysOrigine, String universiteOrigine) {
        this.noEtudiant = noEtudiant;
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

    public String getNoEtudiant() {
        return noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
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

    public String getEmailUbo() {
        return emailUbo;
    }

    public void setEmailUbo(String emailUbo) {
        this.emailUbo = emailUbo;
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

    public BigInteger getGroupeTp() {
        return groupeTp;
    }

    public void setGroupeTp(BigInteger groupeTp) {
        this.groupeTp = groupeTp;
    }

    public BigInteger getGroupeAnglais() {
        return groupeAnglais;
    }

    public void setGroupeAnglais(BigInteger groupeAnglais) {
        this.groupeAnglais = groupeAnglais;
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
        hash += (noEtudiant != null ? noEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.noEtudiant == null && other.noEtudiant != null) || (this.noEtudiant != null && !this.noEtudiant.equals(other.noEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Etudiant[ noEtudiant=" + noEtudiant + " ]";
    }
    
}
