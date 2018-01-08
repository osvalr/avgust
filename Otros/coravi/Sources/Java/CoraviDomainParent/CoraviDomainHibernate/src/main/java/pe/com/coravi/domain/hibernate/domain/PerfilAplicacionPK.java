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
public class PerfilAplicacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aplicacion", nullable = false)
    private int idAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_perfil", nullable = false)
    private int idPerfil;

    public PerfilAplicacionPK() {
    }

    public PerfilAplicacionPK(int idAplicacion, int idPerfil) {
        this.idAplicacion = idAplicacion;
        this.idPerfil = idPerfil;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion;
        hash += (int) idPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAplicacionPK)) {
            return false;
        }
        PerfilAplicacionPK other = (PerfilAplicacionPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.PerfilAplicacionPK[ idAplicacion=" + idAplicacion + ", idPerfil=" + idPerfil + " ]";
    }
    
}
