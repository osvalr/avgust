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
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f")
    , @NamedQuery(name = "Funcionalidad.findByIdFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.idFuncionalidad = :idFuncionalidad")
    , @NamedQuery(name = "Funcionalidad.findByNombreFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.nombreFuncionalidad = :nombreFuncionalidad")
    , @NamedQuery(name = "Funcionalidad.findByRecursoFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.recursoFuncionalidad = :recursoFuncionalidad")
    , @NamedQuery(name = "Funcionalidad.findByIconCls", query = "SELECT f FROM Funcionalidad f WHERE f.iconCls = :iconCls")
    , @NamedQuery(name = "Funcionalidad.findByAliasComponent", query = "SELECT f FROM Funcionalidad f WHERE f.aliasComponent = :aliasComponent")
    , @NamedQuery(name = "Funcionalidad.findByComponentControllers", query = "SELECT f FROM Funcionalidad f WHERE f.componentControllers = :componentControllers")
    , @NamedQuery(name = "Funcionalidad.findByIdEstado", query = "SELECT f FROM Funcionalidad f WHERE f.idEstado = :idEstado")
    , @NamedQuery(name = "Funcionalidad.findByIdUsuarioReg", query = "SELECT f FROM Funcionalidad f WHERE f.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "Funcionalidad.findByFechaRegistro", query = "SELECT f FROM Funcionalidad f WHERE f.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Funcionalidad.findByIdUsuarioMod", query = "SELECT f FROM Funcionalidad f WHERE f.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "Funcionalidad.findByFechaModificacion", query = "SELECT f FROM Funcionalidad f WHERE f.fechaModificacion = :fechaModificacion")})
public class Funcionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionalidad", nullable = false)
    private Integer idFuncionalidad;
    @Size(max = 150)
    @Column(name = "nombre_funcionalidad", length = 150)
    private String nombreFuncionalidad;
    @Size(max = 1000)
    @Column(name = "recurso_funcionalidad", length = 1000)
    private String recursoFuncionalidad;
    @Size(max = 500)
    @Column(name = "icon_cls", length = 500)
    private String iconCls;
    @Size(max = 500)
    @Column(name = "alias_component", length = 500)
    private String aliasComponent;
    @Size(max = 5000)
    @Column(name = "component_controllers", length = 5000)
    private String componentControllers;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionalidad")
    private List<FuncionalidadRol> funcionalidadRolList;

    public Funcionalidad() {
    }

    public Funcionalidad(Integer idFuncionalidad) {
        this.idFuncionalidad = idFuncionalidad;
    }

    public Integer getIdFuncionalidad() {
        return idFuncionalidad;
    }

    public void setIdFuncionalidad(Integer idFuncionalidad) {
        this.idFuncionalidad = idFuncionalidad;
    }

    public String getNombreFuncionalidad() {
        return nombreFuncionalidad;
    }

    public void setNombreFuncionalidad(String nombreFuncionalidad) {
        this.nombreFuncionalidad = nombreFuncionalidad;
    }

    public String getRecursoFuncionalidad() {
        return recursoFuncionalidad;
    }

    public void setRecursoFuncionalidad(String recursoFuncionalidad) {
        this.recursoFuncionalidad = recursoFuncionalidad;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getAliasComponent() {
        return aliasComponent;
    }

    public void setAliasComponent(String aliasComponent) {
        this.aliasComponent = aliasComponent;
    }

    public String getComponentControllers() {
        return componentControllers;
    }

    public void setComponentControllers(String componentControllers) {
        this.componentControllers = componentControllers;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionalidad != null ? idFuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.idFuncionalidad == null && other.idFuncionalidad != null) || (this.idFuncionalidad != null && !this.idFuncionalidad.equals(other.idFuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.Funcionalidad[ idFuncionalidad=" + idFuncionalidad + " ]";
    }
    
}
