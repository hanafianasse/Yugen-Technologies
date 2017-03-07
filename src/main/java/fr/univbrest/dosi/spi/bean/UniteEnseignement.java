/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "UNITE_ENSEIGNEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniteEnseignement.findAll", query = "SELECT u FROM UniteEnseignement u"),
    @NamedQuery(name = "UniteEnseignement.findByCodeFormation", query = "SELECT u FROM UniteEnseignement u WHERE u.uniteEnseignementPK.codeFormation = :codeFormation"),
    @NamedQuery(name = "UniteEnseignement.findByCodeUe", query = "SELECT u FROM UniteEnseignement u WHERE u.uniteEnseignementPK.codeUe = :codeUe"),
    @NamedQuery(name = "UniteEnseignement.findByDesignation", query = "SELECT u FROM UniteEnseignement u WHERE u.designation = :designation"),
    @NamedQuery(name = "UniteEnseignement.findBySemestre", query = "SELECT u FROM UniteEnseignement u WHERE u.semestre = :semestre"),
    @NamedQuery(name = "UniteEnseignement.findByDescription", query = "SELECT u FROM UniteEnseignement u WHERE u.description = :description"),
    @NamedQuery(name = "UniteEnseignement.findByNbhCm", query = "SELECT u FROM UniteEnseignement u WHERE u.nbhCm = :nbhCm"),
    @NamedQuery(name = "UniteEnseignement.findByNbhTd", query = "SELECT u FROM UniteEnseignement u WHERE u.nbhTd = :nbhTd"),
    @NamedQuery(name = "UniteEnseignement.findByNbhTp", query = "SELECT u FROM UniteEnseignement u WHERE u.nbhTp = :nbhTp"),
    @NamedQuery(name = "UniteEnseignement.findByNoEnseignant" , query = "SELECT u FROM UniteEnseignement u WHERE u.noEnseignant.noEnseignant = :noEnseignant")
    })
public class UniteEnseignement implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UniteEnseignementPK uniteEnseignementPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DESIGNATION")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SEMESTRE")
    private String semestre;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NBH_CM")
    private BigInteger nbhCm;
    @Column(name = "NBH_TD")
    private Short nbhTd;
    @Column(name = "NBH_TP")
    private Short nbhTp;
    @JsonManagedReference(value="enseignant-uniteEnseignement")
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne(optional = false)
    private Enseignant noEnseignant;
    @JsonManagedReference(value="ue-formation")
    @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Formation formation;
    @JsonBackReference(value="ue-elemconst")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uniteEnseignement",fetch=FetchType.LAZY)
    private Collection<ElementConstitutif> elementConstitutifCollection;

    public UniteEnseignement() {
    }

    public UniteEnseignement(UniteEnseignementPK uniteEnseignementPK) {
        this.uniteEnseignementPK = uniteEnseignementPK;
    }

    public UniteEnseignement(UniteEnseignementPK uniteEnseignementPK, String designation, String semestre) {
        this.uniteEnseignementPK = uniteEnseignementPK;
        this.designation = designation;
        this.semestre = semestre;
    }

    public UniteEnseignement(String codeFormation, String codeUe) {
        this.uniteEnseignementPK = new UniteEnseignementPK(codeFormation, codeUe);
    }

    public UniteEnseignementPK getUniteEnseignementPK() {
        return uniteEnseignementPK;
    }

    public void setUniteEnseignementPK(UniteEnseignementPK uniteEnseignementPK) {
        this.uniteEnseignementPK = uniteEnseignementPK;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getNbhCm() {
        return nbhCm;
    }

    public void setNbhCm(BigInteger nbhCm) {
        this.nbhCm = nbhCm;
    }

    public Short getNbhTd() {
        return nbhTd;
    }

    public void setNbhTd(Short nbhTd) {
        this.nbhTd = nbhTd;
    }

    public Short getNbhTp() {
        return nbhTp;
    }

    public void setNbhTp(Short nbhTp) {
        this.nbhTp = nbhTp;
    }

    public Enseignant getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Enseignant noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @XmlTransient
    public Collection<ElementConstitutif> getElementConstitutifCollection() {
        return elementConstitutifCollection;
    }

    public void setElementConstitutifCollection(Collection<ElementConstitutif> elementConstitutifCollection) {
        this.elementConstitutifCollection = elementConstitutifCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniteEnseignementPK != null ? uniteEnseignementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniteEnseignement)) {
            return false;
        }
        UniteEnseignement other = (UniteEnseignement) object;
        if ((this.uniteEnseignementPK == null && other.uniteEnseignementPK != null) || (this.uniteEnseignementPK != null && !this.uniteEnseignementPK.equals(other.uniteEnseignementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UniteEnseignement[ uniteEnseignementPK=" + uniteEnseignementPK + " ]";
    }
    
}
