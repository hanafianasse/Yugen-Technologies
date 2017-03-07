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
public class UniteEnseignementPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE_FORMATION")
    private String codeFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE_UE")
    private String codeUe;

    public UniteEnseignementPK() {
    }

    public UniteEnseignementPK(String codeFormation, String codeUe) {
        this.codeFormation = codeFormation;
        this.codeUe = codeUe;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getCodeUe() {
        return codeUe;
    }

    public void setCodeUe(String codeUe) {
        this.codeUe = codeUe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFormation != null ? codeFormation.hashCode() : 0);
        hash += (codeUe != null ? codeUe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniteEnseignementPK)) {
            return false;
        }
        UniteEnseignementPK other = (UniteEnseignementPK) object;
        if ((this.codeFormation == null && other.codeFormation != null) || (this.codeFormation != null && !this.codeFormation.equals(other.codeFormation))) {
            return false;
        }
        if ((this.codeUe == null && other.codeUe != null) || (this.codeUe != null && !this.codeUe.equals(other.codeUe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UniteEnseignementPK[ codeFormation=" + codeFormation + ", codeUe=" + codeUe + " ]";
    }
    
}
