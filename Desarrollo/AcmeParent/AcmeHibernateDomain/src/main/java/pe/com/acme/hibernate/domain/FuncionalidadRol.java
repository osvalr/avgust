/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "funcionalidad_rol", catalog = "bd_acme", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = "FuncionalidadRol.findAll", query = "SELECT f FROM FuncionalidadRol f")})
public class FuncionalidadRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionalidadRolPK funcionalidadRolPK;
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
    @JoinColumn(name = "id_funcionalidad", referencedColumnName = "id_funcionalidad", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionalidad funcionalidad;
    @JoinColumns({
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private RolAplicacion rolAplicacion;

    public FuncionalidadRol() {
    }

    public FuncionalidadRol(FuncionalidadRolPK funcionalidadRolPK) {
        this.funcionalidadRolPK = funcionalidadRolPK;
    }

    public FuncionalidadRol(int idFuncionalidad, int idRol, int idAplicacion) {
        this.funcionalidadRolPK = new FuncionalidadRolPK(idFuncionalidad, idRol, idAplicacion);
    }

    public FuncionalidadRolPK getFuncionalidadRolPK() {
        return funcionalidadRolPK;
    }

    public void setFuncionalidadRolPK(FuncionalidadRolPK funcionalidadRolPK) {
        this.funcionalidadRolPK = funcionalidadRolPK;
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

    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public RolAplicacion getRolAplicacion() {
        return rolAplicacion;
    }

    public void setRolAplicacion(RolAplicacion rolAplicacion) {
        this.rolAplicacion = rolAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionalidadRolPK != null ? funcionalidadRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalidadRol)) {
            return false;
        }
        FuncionalidadRol other = (FuncionalidadRol) object;
        if ((this.funcionalidadRolPK == null && other.funcionalidadRolPK != null) || (this.funcionalidadRolPK != null && !this.funcionalidadRolPK.equals(other.funcionalidadRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.FuncionalidadRol[ funcionalidadRolPK=" + funcionalidadRolPK + " ]";
    }
    
}
