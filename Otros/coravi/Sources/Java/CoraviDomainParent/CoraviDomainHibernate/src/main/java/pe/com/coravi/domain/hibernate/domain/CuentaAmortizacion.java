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
@Table(name = "cuenta_amortizacion", catalog = "bd_acme", schema = "inavi")
@NamedQueries({
    @NamedQuery(name = "CuentaAmortizacion.findAll", query = "SELECT c FROM CuentaAmortizacion c")
    , @NamedQuery(name = "CuentaAmortizacion.findByIdCuentaAmortizacion", query = "SELECT c FROM CuentaAmortizacion c WHERE c.idCuentaAmortizacion = :idCuentaAmortizacion")
    , @NamedQuery(name = "CuentaAmortizacion.findByIdMoneda", query = "SELECT c FROM CuentaAmortizacion c WHERE c.idMoneda = :idMoneda")
    , @NamedQuery(name = "CuentaAmortizacion.findByMontoAmortizado", query = "SELECT c FROM CuentaAmortizacion c WHERE c.montoAmortizado = :montoAmortizado")
    , @NamedQuery(name = "CuentaAmortizacion.findByFechaSaldo", query = "SELECT c FROM CuentaAmortizacion c WHERE c.fechaSaldo = :fechaSaldo")
    , @NamedQuery(name = "CuentaAmortizacion.findByIdEstado", query = "SELECT c FROM CuentaAmortizacion c WHERE c.idEstado = :idEstado")
    , @NamedQuery(name = "CuentaAmortizacion.findByIdUsuarioReg", query = "SELECT c FROM CuentaAmortizacion c WHERE c.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "CuentaAmortizacion.findByFechaRegistro", query = "SELECT c FROM CuentaAmortizacion c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "CuentaAmortizacion.findByIdUsuarioMod", query = "SELECT c FROM CuentaAmortizacion c WHERE c.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "CuentaAmortizacion.findByFechaModificacion", query = "SELECT c FROM CuentaAmortizacion c WHERE c.fechaModificacion = :fechaModificacion")})
public class CuentaAmortizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_amortizacion", nullable = false)
    private Integer idCuentaAmortizacion;
    @Column(name = "id_moneda")
    private Integer idMoneda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_amortizado", precision = 10, scale = 2)
    private BigDecimal montoAmortizado;
    @Column(name = "fecha_saldo")
    @Temporal(TemporalType.DATE)
    private Date fechaSaldo;
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
    @JoinColumn(name = "id_cuenta_x_cobrar", referencedColumnName = "id_cuenta_x_cobrar", nullable = false)
    @ManyToOne(optional = false)
    private CuentaXCobrar idCuentaXCobrar;

    public CuentaAmortizacion() {
    }

    public CuentaAmortizacion(Integer idCuentaAmortizacion) {
        this.idCuentaAmortizacion = idCuentaAmortizacion;
    }

    public Integer getIdCuentaAmortizacion() {
        return idCuentaAmortizacion;
    }

    public void setIdCuentaAmortizacion(Integer idCuentaAmortizacion) {
        this.idCuentaAmortizacion = idCuentaAmortizacion;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public BigDecimal getMontoAmortizado() {
        return montoAmortizado;
    }

    public void setMontoAmortizado(BigDecimal montoAmortizado) {
        this.montoAmortizado = montoAmortizado;
    }

    public Date getFechaSaldo() {
        return fechaSaldo;
    }

    public void setFechaSaldo(Date fechaSaldo) {
        this.fechaSaldo = fechaSaldo;
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

    public CuentaXCobrar getIdCuentaXCobrar() {
        return idCuentaXCobrar;
    }

    public void setIdCuentaXCobrar(CuentaXCobrar idCuentaXCobrar) {
        this.idCuentaXCobrar = idCuentaXCobrar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaAmortizacion != null ? idCuentaAmortizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaAmortizacion)) {
            return false;
        }
        CuentaAmortizacion other = (CuentaAmortizacion) object;
        if ((this.idCuentaAmortizacion == null && other.idCuentaAmortizacion != null) || (this.idCuentaAmortizacion != null && !this.idCuentaAmortizacion.equals(other.idCuentaAmortizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.CuentaAmortizacion[ idCuentaAmortizacion=" + idCuentaAmortizacion + " ]";
    }
    
}
