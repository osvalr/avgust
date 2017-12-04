/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "moneda_cambio", catalog = "bd_acme", schema = "general")
@NamedQueries({
    @NamedQuery(name = "MonedaCambio.findAll", query = "SELECT m FROM MonedaCambio m")})
public class MonedaCambio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonedaCambioPK monedaCambioPK;
    @Column(name = "id_tipo_operador")
    private Integer idTipoOperador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_cambio_moneda", precision = 10, scale = 2)
    private BigDecimal precioCambioMoneda;
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
    @JoinColumn(name = "id_moneda_foranea", referencedColumnName = "id_moneda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Moneda moneda;
    @JoinColumn(name = "id_moneda_local", referencedColumnName = "id_moneda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Moneda moneda1;

    public MonedaCambio() {
    }

    public MonedaCambio(MonedaCambioPK monedaCambioPK) {
        this.monedaCambioPK = monedaCambioPK;
    }

    public MonedaCambio(int idMonedaLocal, int idMonedaForanea) {
        this.monedaCambioPK = new MonedaCambioPK(idMonedaLocal, idMonedaForanea);
    }

    public MonedaCambioPK getMonedaCambioPK() {
        return monedaCambioPK;
    }

    public void setMonedaCambioPK(MonedaCambioPK monedaCambioPK) {
        this.monedaCambioPK = monedaCambioPK;
    }

    public Integer getIdTipoOperador() {
        return idTipoOperador;
    }

    public void setIdTipoOperador(Integer idTipoOperador) {
        this.idTipoOperador = idTipoOperador;
    }

    public BigDecimal getPrecioCambioMoneda() {
        return precioCambioMoneda;
    }

    public void setPrecioCambioMoneda(BigDecimal precioCambioMoneda) {
        this.precioCambioMoneda = precioCambioMoneda;
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

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Moneda getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(Moneda moneda1) {
        this.moneda1 = moneda1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monedaCambioPK != null ? monedaCambioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonedaCambio)) {
            return false;
        }
        MonedaCambio other = (MonedaCambio) object;
        if ((this.monedaCambioPK == null && other.monedaCambioPK != null) || (this.monedaCambioPK != null && !this.monedaCambioPK.equals(other.monedaCambioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.MonedaCambio[ monedaCambioPK=" + monedaCambioPK + " ]";
    }
    
}
