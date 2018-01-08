/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(catalog = "bd_acme", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfil.findByNombrePerfil", query = "SELECT p FROM Perfil p WHERE p.nombrePerfil = :nombrePerfil")
    , @NamedQuery(name = "Perfil.findByIdEstado", query = "SELECT p FROM Perfil p WHERE p.idEstado = :idEstado")
    , @NamedQuery(name = "Perfil.findByIdUsuarioReg", query = "SELECT p FROM Perfil p WHERE p.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "Perfil.findByFechaRegistro", query = "SELECT p FROM Perfil p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Perfil.findByIdUsuarioMod", query = "SELECT p FROM Perfil p WHERE p.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "Perfil.findByFechaModificacion", query = "SELECT p FROM Perfil p WHERE p.fechaModificacion = :fechaModificacion")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private Integer idPerfil;
    @Size(max = 500)
    @Column(name = "nombre_perfil", length = 500)
    private String nombrePerfil;
    @Column(name = "id_estado")
    private Short idEstado;
    @Column(name = "id_usuario_reg")
    private Integer idUsuarioReg;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "id_usuario_mod")
    private Integer idUsuarioMod;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilAplicacion> perfilAplicacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfilList;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public Short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Short idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdUsuarioReg() {
        return idUsuarioReg;
    }

    public void setIdUsuarioReg(Integer idUsuarioReg) {
        this.idUsuarioReg = idUsuarioReg;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUsuarioMod() {
        return idUsuarioMod;
    }

    public void setIdUsuarioMod(Integer idUsuarioMod) {
        this.idUsuarioMod = idUsuarioMod;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<PerfilAplicacion> getPerfilAplicacionList() {
        return perfilAplicacionList;
    }

    public void setPerfilAplicacionList(List<PerfilAplicacion> perfilAplicacionList) {
        this.perfilAplicacionList = perfilAplicacionList;
    }

    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
