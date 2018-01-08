/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JRaffo
 */
@Embeddable
public class PersonaTipoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_persona", nullable = false)
    private int idTipoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sub_tipo_persona", nullable = false)
    private int idSubTipoPersona;

    public PersonaTipoPK() {
    }

    public PersonaTipoPK(int idPersona, int idTipoPersona, int idSubTipoPersona) {
        this.idPersona = idPersona;
        this.idTipoPersona = idTipoPersona;
        this.idSubTipoPersona = idSubTipoPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public int getIdSubTipoPersona() {
        return idSubTipoPersona;
    }

    public void setIdSubTipoPersona(int idSubTipoPersona) {
        this.idSubTipoPersona = idSubTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) idTipoPersona;
        hash += (int) idSubTipoPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaTipoPK)) {
            return false;
        }
        PersonaTipoPK other = (PersonaTipoPK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.idTipoPersona != other.idTipoPersona) {
            return false;
        }
        if (this.idSubTipoPersona != other.idSubTipoPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.PersonaTipoPK[ idPersona=" + idPersona + ", idTipoPersona=" + idTipoPersona + ", idSubTipoPersona=" + idSubTipoPersona + " ]";
    }
    
}
