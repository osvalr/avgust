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
public class UsuarioRolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol", nullable = false)
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aplicacion", nullable = false)
    private int idAplicacion;

    public UsuarioRolPK() {
    }

    public UsuarioRolPK(int idUsuario, int idRol, int idAplicacion) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.idAplicacion = idAplicacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idRol;
        hash += (int) idAplicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolPK)) {
            return false;
        }
        UsuarioRolPK other = (UsuarioRolPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.UsuarioRolPK[ idUsuario=" + idUsuario + ", idRol=" + idRol + ", idAplicacion=" + idAplicacion + " ]";
    }
    
}
