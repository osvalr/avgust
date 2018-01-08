/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rol_aplicacion", catalog = "bd_acme", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = "RolAplicacion.findAll", query = "SELECT r FROM RolAplicacion r")
    , @NamedQuery(name = "RolAplicacion.findByIdRol", query = "SELECT r FROM RolAplicacion r WHERE r.rolAplicacionPK.idRol = :idRol")
    , @NamedQuery(name = "RolAplicacion.findByIdAplicacion", query = "SELECT r FROM RolAplicacion r WHERE r.rolAplicacionPK.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "RolAplicacion.findByNombreRol", query = "SELECT r FROM RolAplicacion r WHERE r.nombreRol = :nombreRol")
    , @NamedQuery(name = "RolAplicacion.findByIdEstado", query = "SELECT r FROM RolAplicacion r WHERE r.idEstado = :idEstado")
    , @NamedQuery(name = "RolAplicacion.findByIdUsuarioReg", query = "SELECT r FROM RolAplicacion r WHERE r.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "RolAplicacion.findByFechaRegistro", query = "SELECT r FROM RolAplicacion r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "RolAplicacion.findByIdUsuarioMod", query = "SELECT r FROM RolAplicacion r WHERE r.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "RolAplicacion.findByFechaModificacion", query = "SELECT r FROM RolAplicacion r WHERE r.fechaModificacion = :fechaModificacion")})
public class RolAplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolAplicacionPK rolAplicacionPK;
    @Size(max = 150)
    @Column(name = "nombre_rol", length = 150)
    private String nombreRol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolAplicacion")
    private List<FuncionalidadRol> funcionalidadRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolAplicacion")
    private List<UsuarioRol> usuarioRolList;
    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;

    public RolAplicacion() {
    }

    public RolAplicacion(RolAplicacionPK rolAplicacionPK) {
        this.rolAplicacionPK = rolAplicacionPK;
    }

    public RolAplicacion(int idRol, int idAplicacion) {
        this.rolAplicacionPK = new RolAplicacionPK(idRol, idAplicacion);
    }

    public RolAplicacionPK getRolAplicacionPK() {
        return rolAplicacionPK;
    }

    public void setRolAplicacionPK(RolAplicacionPK rolAplicacionPK) {
        this.rolAplicacionPK = rolAplicacionPK;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
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

    public List<FuncionalidadRol> getFuncionalidadRolList() {
        return funcionalidadRolList;
    }

    public void setFuncionalidadRolList(List<FuncionalidadRol> funcionalidadRolList) {
        this.funcionalidadRolList = funcionalidadRolList;
    }

    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolAplicacionPK != null ? rolAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolAplicacion)) {
            return false;
        }
        RolAplicacion other = (RolAplicacion) object;
        if ((this.rolAplicacionPK == null && other.rolAplicacionPK != null) || (this.rolAplicacionPK != null && !this.rolAplicacionPK.equals(other.rolAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.RolAplicacion[ rolAplicacionPK=" + rolAplicacionPK + " ]";
    }
    
}
