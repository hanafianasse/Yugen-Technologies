/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DOSI
 */
@Embeddable
public class PromotionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE_FORMATION")
    private String codeFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    public PromotionPK() {
    }

    public PromotionPK(String codeFormation, String anneeUniversitaire) {
        this.codeFormation = codeFormation;
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFormation != null ? codeFormation.hashCode() : 0);
        hash += (anneeUniversitaire != null ? anneeUniversitaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotionPK)) {
            return false;
        }
        PromotionPK other = (PromotionPK) object;
        if ((this.codeFormation == null && other.codeFormation != null) || (this.codeFormation != null && !this.codeFormation.equals(other.codeFormation))) {
            return false;
        }
        if ((this.anneeUniversitaire == null && other.anneeUniversitaire != null) || (this.anneeUniversitaire != null && !this.anneeUniversitaire.equals(other.anneeUniversitaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromotionPK[ codeFormation=" + codeFormation + ", anneeUniversitaire=" + anneeUniversitaire + " ]";
    }
    
}
