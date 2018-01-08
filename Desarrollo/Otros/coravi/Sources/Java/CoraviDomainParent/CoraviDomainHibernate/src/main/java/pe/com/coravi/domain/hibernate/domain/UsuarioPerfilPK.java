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
public class UsuarioPerfilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_perfil", nullable = false)
    private int idPerfil;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(int idUsuario, int idPerfil) {
        this.idUsuario = idUsuario;
        this.idPerfil = idPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (int) idUsuario;
        hash += (int) idPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfilPK)) {
            return false;
        }
        UsuarioPerfilPK other = (UsuarioPerfilPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.UsuarioPerfilPK[ idUsuario=" + idUsuario + ", idPerfil=" + idPerfil + " ]";
    }
    
}
