/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "cuenta_x_cobrar", catalog = "bd_acme", schema = "inavi")
@NamedQueries({
    @NamedQuery(name = "CuentaXCobrar.findAll", query = "SELECT c FROM CuentaXCobrar c")
    , @NamedQuery(name = "CuentaXCobrar.findByIdCuentaXCobrar", query = "SELECT c FROM CuentaXCobrar c WHERE c.idCuentaXCobrar = :idCuentaXCobrar")
    , @NamedQuery(name = "CuentaXCobrar.findByIdCliente", query = "SELECT c FROM CuentaXCobrar c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "CuentaXCobrar.findByDescripGlosa", query = "SELECT c FROM CuentaXCobrar c WHERE c.descripGlosa = :descripGlosa")
    , @NamedQuery(name = "CuentaXCobrar.findByIdEstado", query = "SELECT c FROM CuentaXCobrar c WHERE c.idEstado = :idEstado")
    , @NamedQuery(name = "CuentaXCobrar.findByIdUsuarioReg", query = "SELECT c FROM CuentaXCobrar c WHERE c.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "CuentaXCobrar.findByFechaRegistro", query = "SELECT c FROM CuentaXCobrar c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "CuentaXCobrar.findByIdUsuarioMod", query = "SELECT c FROM CuentaXCobrar c WHERE c.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "CuentaXCobrar.findByFechaModificacion", query = "SELECT c FROM CuentaXCobrar c WHERE c.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "CuentaXCobrar.findByMontoDeuda", query = "SELECT c FROM CuentaXCobrar c WHERE c.montoDeuda = :montoDeuda")
    , @NamedQuery(name = "CuentaXCobrar.findByFechaCuenta", query = "SELECT c FROM CuentaXCobrar c WHERE c.fechaCuenta = :fechaCuenta")})
public class CuentaXCobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_x_cobrar", nullable = false)
    private Integer idCuentaXCobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Size(max = 1000)
    @Column(name = "descrip_glosa", length = 1000)
    private String descripGlosa;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_deuda", precision = 10, scale = 2)
    private BigDecimal montoDeuda;
    @Column(name = "fecha_cuenta")
    @Temporal(TemporalType.DATE)
    private Date fechaCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuentaXCobrar")
    private List<CuentaAmortizacion> cuentaAmortizacionList;

    public CuentaXCobrar() {
    }

    public CuentaXCobrar(Integer idCuentaXCobrar) {
        this.idCuentaXCobrar = idCuentaXCobrar;
    }

    public CuentaXCobrar(Integer idCuentaXCobrar, int idCliente) {
        this.idCuentaXCobrar = idCuentaXCobrar;
        this.idCliente = idCliente;
    }

    public Integer getIdCuentaXCobrar() {
        return idCuentaXCobrar;
    }

    public void setIdCuentaXCobrar(Integer idCuentaXCobrar) {
        this.idCuentaXCobrar = idCuentaXCobrar;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescripGlosa() {
        return descripGlosa;
    }

    public void setDescripGlosa(String descripGlosa) {
        this.descripGlosa = descripGlosa;
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

    public BigDecimal getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(BigDecimal montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

    public Date getFechaCuenta() {
        return fechaCuenta;
    }

    public void setFechaCuenta(Date fechaCuenta) {
        this.fechaCuenta = fechaCuenta;
    }

    public List<CuentaAmortizacion> getCuentaAmortizacionList() {
        return cuentaAmortizacionList;
    }

    public void setCuentaAmortizacionList(List<CuentaAmortizacion> cuentaAmortizacionList) {
        this.cuentaAmortizacionList = cuentaAmortizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaXCobrar != null ? idCuentaXCobrar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaXCobrar)) {
            return false;
        }
        CuentaXCobrar other = (CuentaXCobrar) object;
        if ((this.idCuentaXCobrar == null && other.idCuentaXCobrar != null) || (this.idCuentaXCobrar != null && !this.idCuentaXCobrar.equals(other.idCuentaXCobrar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.CuentaXCobrar[ idCuentaXCobrar=" + idCuentaXCobrar + " ]";
    }
    
}
