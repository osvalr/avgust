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
@Table(catalog = "bd_acme", schema = "general")
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m")
    , @NamedQuery(name = "Moneda.findByIdMoneda", query = "SELECT m FROM Moneda m WHERE m.idMoneda = :idMoneda")
    , @NamedQuery(name = "Moneda.findByDescripcion", query = "SELECT m FROM Moneda m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Moneda.findBySimbolo", query = "SELECT m FROM Moneda m WHERE m.simbolo = :simbolo")
    , @NamedQuery(name = "Moneda.findByIdTipoOrigen", query = "SELECT m FROM Moneda m WHERE m.idTipoOrigen = :idTipoOrigen")
    , @NamedQuery(name = "Moneda.findByIdEstado", query = "SELECT m FROM Moneda m WHERE m.idEstado = :idEstado")
    , @NamedQuery(name = "Moneda.findByIdUsuarioReg", query = "SELECT m FROM Moneda m WHERE m.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "Moneda.findByFechaRegistro", query = "SELECT m FROM Moneda m WHERE m.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Moneda.findByIdUsuarioMod", query = "SELECT m FROM Moneda m WHERE m.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "Moneda.findByFechaModificacion", query = "SELECT m FROM Moneda m WHERE m.fechaModificacion = :fechaModificacion")})
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moneda", nullable = false)
    private Integer idMoneda;
    @Size(max = 150)
    @Column(length = 150)
    private String descripcion;
    @Size(max = 10)
    @Column(length = 10)
    private String simbolo;
    @Column(name = "id_tipo_origen")
    private Integer idTipoOrigen;
    @Column(name = "id_estado")
    private Integer idEstado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moneda")
    private List<MonedaCambio> monedaCambioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moneda1")
    private List<MonedaCambio> monedaCambioList1;

    public Moneda() {
    }

    public Moneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Integer getIdTipoOrigen() {
        return idTipoOrigen;
    }

    public void setIdTipoOrigen(Integer idTipoOrigen) {
        this.idTipoOrigen = idTipoOrigen;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
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

    public List<MonedaCambio> getMonedaCambioList() {
        return monedaCambioList;
    }

    public void setMonedaCambioList(List<MonedaCambio> monedaCambioList) {
        this.monedaCambioList = monedaCambioList;
    }

    public List<MonedaCambio> getMonedaCambioList1() {
        return monedaCambioList1;
    }

    public void setMonedaCambioList1(List<MonedaCambio> monedaCambioList1) {
        this.monedaCambioList1 = monedaCambioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoneda != null ? idMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.idMoneda == null && other.idMoneda != null) || (this.idMoneda != null && !this.idMoneda.equals(other.idMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.Moneda[ idMoneda=" + idMoneda + " ]";
    }
    
}
