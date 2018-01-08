/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "guia_peso", catalog = "bd_acme", schema = "inavi")
@NamedQueries({
    @NamedQuery(name = "GuiaPeso.findAll", query = "SELECT g FROM GuiaPeso g")
    , @NamedQuery(name = "GuiaPeso.findByIdGuiaPeso", query = "SELECT g FROM GuiaPeso g WHERE g.idGuiaPeso = :idGuiaPeso")
    , @NamedQuery(name = "GuiaPeso.findByIdTipoPeso", query = "SELECT g FROM GuiaPeso g WHERE g.idTipoPeso = :idTipoPeso")
    , @NamedQuery(name = "GuiaPeso.findByNumJabas", query = "SELECT g FROM GuiaPeso g WHERE g.numJabas = :numJabas")
    , @NamedQuery(name = "GuiaPeso.findByNumAves", query = "SELECT g FROM GuiaPeso g WHERE g.numAves = :numAves")
    , @NamedQuery(name = "GuiaPeso.findByPesoObtenido", query = "SELECT g FROM GuiaPeso g WHERE g.pesoObtenido = :pesoObtenido")
    , @NamedQuery(name = "GuiaPeso.findByIdEstado", query = "SELECT g FROM GuiaPeso g WHERE g.idEstado = :idEstado")
    , @NamedQuery(name = "GuiaPeso.findByIdUsuarioReg", query = "SELECT g FROM GuiaPeso g WHERE g.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "GuiaPeso.findByFechaRegistro", query = "SELECT g FROM GuiaPeso g WHERE g.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "GuiaPeso.findByIdUsuarioMod", query = "SELECT g FROM GuiaPeso g WHERE g.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "GuiaPeso.findByFechaModificacion", query = "SELECT g FROM GuiaPeso g WHERE g.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "GuiaPeso.findByFlagDevolucion", query = "SELECT g FROM GuiaPeso g WHERE g.flagDevolucion = :flagDevolucion")})
public class GuiaPeso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_peso", nullable = false)
    private Integer idGuiaPeso;
    @Column(name = "id_tipo_peso")
    private Integer idTipoPeso;
    @Column(name = "num_jabas")
    private Integer numJabas;
    @Column(name = "num_aves")
    private Integer numAves;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_obtenido", precision = 10, scale = 2)
    private BigDecimal pesoObtenido;
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
    @Column(name = "flag_devolucion")
    private Integer flagDevolucion;
    @JoinColumn(name = "id_guia", referencedColumnName = "id_guia", nullable = false)
    @ManyToOne(optional = false)
    private Guia idGuia;

    public GuiaPeso() {
    }

    public GuiaPeso(Integer idGuiaPeso) {
        this.idGuiaPeso = idGuiaPeso;
    }

    public Integer getIdGuiaPeso() {
        return idGuiaPeso;
    }

    public void setIdGuiaPeso(Integer idGuiaPeso) {
        this.idGuiaPeso = idGuiaPeso;
    }

    public Integer getIdTipoPeso() {
        return idTipoPeso;
    }

    public void setIdTipoPeso(Integer idTipoPeso) {
        this.idTipoPeso = idTipoPeso;
    }

    public Integer getNumJabas() {
        return numJabas;
    }

    public void setNumJabas(Integer numJabas) {
        this.numJabas = numJabas;
    }

    public Integer getNumAves() {
        return numAves;
    }

    public void setNumAves(Integer numAves) {
        this.numAves = numAves;
    }

    public BigDecimal getPesoObtenido() {
        return pesoObtenido;
    }

    public void setPesoObtenido(BigDecimal pesoObtenido) {
        this.pesoObtenido = pesoObtenido;
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

    public Integer getFlagDevolucion() {
        return flagDevolucion;
    }

    public void setFlagDevolucion(Integer flagDevolucion) {
        this.flagDevolucion = flagDevolucion;
    }

    public Guia getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Guia idGuia) {
        this.idGuia = idGuia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaPeso != null ? idGuiaPeso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaPeso)) {
            return false;
        }
        GuiaPeso other = (GuiaPeso) object;
        if ((this.idGuiaPeso == null && other.idGuiaPeso != null) || (this.idGuiaPeso != null && !this.idGuiaPeso.equals(other.idGuiaPeso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.GuiaPeso[ idGuiaPeso=" + idGuiaPeso + " ]";
    }
    
}
