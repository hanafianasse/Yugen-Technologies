/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "FORMATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByCodeFormation", query = "SELECT f FROM Formation f WHERE f.codeFormation = :codeFormation"),
    @NamedQuery(name = "Formation.findByDiplome", query = "SELECT f FROM Formation f WHERE f.diplome = :diplome"),
    @NamedQuery(name = "Formation.findByN0Annee", query = "SELECT f FROM Formation f WHERE f.n0Annee = :n0Annee"),
    @NamedQuery(name = "Formation.findByNomFormation", query = "SELECT f FROM Formation f WHERE f.nomFormation = :nomFormation"),
    @NamedQuery(name = "Formation.findByDoubleDiplome", query = "SELECT f FROM Formation f WHERE f.doubleDiplome = :doubleDiplome"),
    @NamedQuery(name = "Formation.findByDebutAccreditation", query = "SELECT f FROM Formation f WHERE f.debutAccreditation = :debutAccreditation"),
    @NamedQuery(name = "Formation.findByFinAccreditation", query = "SELECT f FROM Formation f WHERE f.finAccreditation = :finAccreditation")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE_FORMATION")
    private String codeFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DIPLOME")
    private String diplome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "N0_ANNEE")
    private short n0Annee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NOM_FORMATION")
    private String nomFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOUBLE_DIPLOME")
    private Character doubleDiplome;
    @Column(name = "DEBUT_ACCREDITATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutAccreditation;
    @Column(name = "FIN_ACCREDITATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finAccreditation;
    @JsonBackReference(value="formation-promotion")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formation",fetch=FetchType.LAZY)
    private Collection<Promotion> promotionCollection;
    @JsonBackReference(value="ue-formation")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formation",fetch=FetchType.LAZY)
    private Collection<UniteEnseignement> uniteEnseignementCollection;

    public Formation() {
    }

    public Formation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public Formation(String codeFormation, String diplome, short n0Annee, String nomFormation, Character doubleDiplome) {
        this.codeFormation = codeFormation;
        this.diplome = diplome;
        this.n0Annee = n0Annee;
        this.nomFormation = nomFormation;
        this.doubleDiplome = doubleDiplome;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public short getN0Annee() {
        return n0Annee;
    }

    public void setN0Annee(short n0Annee) {
        this.n0Annee = n0Annee;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Character getDoubleDiplome() {
        return doubleDiplome;
    }

    public void setDoubleDiplome(Character doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    public Date getDebutAccreditation() {
        return debutAccreditation;
    }

    public void setDebutAccreditation(Date debutAccreditation) {
        this.debutAccreditation = debutAccreditation;
    }

    public Date getFinAccreditation() {
        return finAccreditation;
    }

    public void setFinAccreditation(Date finAccreditation) {
        this.finAccreditation = finAccreditation;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @XmlTransient
    public Collection<UniteEnseignement> getUniteEnseignementCollection() {
        return uniteEnseignementCollection;
    }

    public void setUniteEnseignementCollection(Collection<UniteEnseignement> uniteEnseignementCollection) {
        this.uniteEnseignementCollection = uniteEnseignementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFormation != null ? codeFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.codeFormation == null && other.codeFormation != null) || (this.codeFormation != null && !this.codeFormation.equals(other.codeFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Formation[ codeFormation=" + codeFormation + " ]";
    }
    
}
