/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "ELEMENT_CONSTITUTIF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementConstitutif.findAll", query = "SELECT e FROM ElementConstitutif e"),
    @NamedQuery(name = "ElementConstitutif.findByCodeFormation", query = "SELECT e FROM ElementConstitutif e WHERE e.elementConstitutifPK.codeFormation = :codeFormation"),
    @NamedQuery(name = "ElementConstitutif.findByCodeUe", query = "SELECT e FROM ElementConstitutif e WHERE e.elementConstitutifPK.codeUe = :codeUe"),
    @NamedQuery(name = "ElementConstitutif.findByCodeEc", query = "SELECT e FROM ElementConstitutif e WHERE e.elementConstitutifPK.codeEc = :codeEc"),
    @NamedQuery(name = "ElementConstitutif.findByDesignation", query = "SELECT e FROM ElementConstitutif e WHERE e.designation = :designation"),
    @NamedQuery(name = "ElementConstitutif.findByDescription", query = "SELECT e FROM ElementConstitutif e WHERE e.description = :description"),
    @NamedQuery(name = "ElementConstitutif.findByNbhCm", query = "SELECT e FROM ElementConstitutif e WHERE e.nbhCm = :nbhCm"),
    @NamedQuery(name = "ElementConstitutif.findByNbhTd", query = "SELECT e FROM ElementConstitutif e WHERE e.nbhTd = :nbhTd"),
    @NamedQuery(name = "ElementConstitutif.findByNbhTp", query = "SELECT e FROM ElementConstitutif e WHERE e.nbhTp = :nbhTp")})
public class ElementConstitutif implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ElementConstitutifPK elementConstitutifPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DESIGNATION")
    private String designation;
    @Size(max = 240)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NBH_CM")
    private Short nbhCm;
    @Column(name = "NBH_TD")
    private Short nbhTd;
    @Column(name = "NBH_TP")
    private Short nbhTp;
    @JsonManagedReference(value="enseignant-elementConstitutif")
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne(optional = false)
    private Enseignant noEnseignant;
    @JsonManagedReference(value="ue-elemconst")
    @JoinColumns({
        @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION", insertable = false, updatable = false),
        @JoinColumn(name = "CODE_UE", referencedColumnName = "CODE_UE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private UniteEnseignement uniteEnseignement;

    public ElementConstitutif() {
    }

    public ElementConstitutif(ElementConstitutifPK elementConstitutifPK) {
        this.elementConstitutifPK = elementConstitutifPK;
    }

    public ElementConstitutif(ElementConstitutifPK elementConstitutifPK, String designation) {
        this.elementConstitutifPK = elementConstitutifPK;
        this.designation = designation;
    }

    public ElementConstitutif(String codeFormation, String codeUe, String codeEc) {
        this.elementConstitutifPK = new ElementConstitutifPK(codeFormation, codeUe, codeEc);
    }

    public ElementConstitutifPK getElementConstitutifPK() {
        return elementConstitutifPK;
    }

    public void setElementConstitutifPK(ElementConstitutifPK elementConstitutifPK) {
        this.elementConstitutifPK = elementConstitutifPK;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getNbhCm() {
        return nbhCm;
    }

    public void setNbhCm(Short nbhCm) {
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

    public UniteEnseignement getUniteEnseignement() {
        return uniteEnseignement;
    }

    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementConstitutifPK != null ? elementConstitutifPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementConstitutif)) {
            return false;
        }
        ElementConstitutif other = (ElementConstitutif) object;
        if ((this.elementConstitutifPK == null && other.elementConstitutifPK != null) || (this.elementConstitutifPK != null && !this.elementConstitutifPK.equals(other.elementConstitutifPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ElementConstitutif[ elementConstitutifPK=" + elementConstitutifPK + " ]";
    }
    
}
