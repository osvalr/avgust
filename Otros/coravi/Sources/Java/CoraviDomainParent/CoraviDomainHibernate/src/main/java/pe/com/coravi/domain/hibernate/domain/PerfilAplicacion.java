/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "perfil_aplicacion", catalog = "bd_acme", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = "PerfilAplicacion.findAll", query = "SELECT p FROM PerfilAplicacion p")
    , @NamedQuery(name = "PerfilAplicacion.findByIdAplicacion", query = "SELECT p FROM PerfilAplicacion p WHERE p.perfilAplicacionPK.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "PerfilAplicacion.findByIdPerfil", query = "SELECT p FROM PerfilAplicacion p WHERE p.perfilAplicacionPK.idPerfil = :idPerfil")
    , @NamedQuery(name = "PerfilAplicacion.findByIdEstado", query = "SELECT p FROM PerfilAplicacion p WHERE p.idEstado = :idEstado")
    , @NamedQuery(name = "PerfilAplicacion.findByIdUsuarioReg", query = "SELECT p FROM PerfilAplicacion p WHERE p.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "PerfilAplicacion.findByFechaRegistro", query = "SELECT p FROM PerfilAplicacion p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "PerfilAplicacion.findByIdUsuarioMod", query = "SELECT p FROM PerfilAplicacion p WHERE p.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "PerfilAplicacion.findByFechaModificacion", query = "SELECT p FROM PerfilAplicacion p WHERE p.fechaModificacion = :fechaModificacion")})
public class PerfilAplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilAplicacionPK perfilAplicacionPK;
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
    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public PerfilAplicacion() {
    }

    public PerfilAplicacion(PerfilAplicacionPK perfilAplicacionPK) {
        this.perfilAplicacionPK = perfilAplicacionPK;
    }

    public PerfilAplicacion(int idAplicacion, int idPerfil) {
        this.perfilAplicacionPK = new PerfilAplicacionPK(idAplicacion, idPerfil);
    }

    public PerfilAplicacionPK getPerfilAplicacionPK() {
        return perfilAplicacionPK;
    }

    public void setPerfilAplicacionPK(PerfilAplicacionPK perfilAplicacionPK) {
        this.perfilAplicacionPK = perfilAplicacionPK;
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

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilAplicacionPK != null ? perfilAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAplicacion)) {
            return false;
        }
        PerfilAplicacion other = (PerfilAplicacion) object;
        if ((this.perfilAplicacionPK == null && other.perfilAplicacionPK != null) || (this.perfilAplicacionPK != null && !this.perfilAplicacionPK.equals(other.perfilAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.PerfilAplicacion[ perfilAplicacionPK=" + perfilAplicacionPK + " ]";
    }
    
}
