/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(catalog = "bd_acme", schema = "inavi")
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g")})
public class Guia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia", nullable = false)
    private Integer idGuia;
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "id_tipo_mvto_guia")
    private Integer idTipoMvtoGuia;
    @Column(name = "id_tipo_producto")
    private Integer idTipoProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_peso_bruto", precision = 10, scale = 2)
    private BigDecimal totalPesoBruto;
    @Column(name = "total_peso_tara", precision = 10, scale = 2)
    private BigDecimal totalPesoTara;
    @Column(name = "total_peso_devolucion", precision = 10, scale = 2)
    private BigDecimal totalPesoDevolucion;
    @Column(name = "total_peso_neto", precision = 10, scale = 2)
    private BigDecimal totalPesoNeto;
    @Column(name = "precio_aplicado", precision = 10, scale = 4)
    private BigDecimal precioAplicado;
    @Column(name = "id_moneda_local")
    private Integer idMonedaLocal;
    @Column(name = "total_importe", precision = 10, scale = 2)
    private BigDecimal totalImporte;
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
    @Column(name = "id_guia_referencia")
    private Integer idGuiaReferencia;
    @Column(name = "id_tipo_guia")
    private Integer idTipoGuia;
    @JoinColumns({
        @JoinColumn(name = "num_dia", referencedColumnName = "num_dia", nullable = false),
        @JoinColumn(name = "num_mes", referencedColumnName = "num_mes", nullable = false),
        @JoinColumn(name = "num_anio", referencedColumnName = "num_anio", nullable = false)})
    @ManyToOne(optional = false)
    private Jornada jornada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuia")
    private List<GuiaSaldo> guiaSaldoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuia")
    private List<GuiaPeso> guiaPesoList;

    public Guia() {
    }

    public Guia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTipoMvtoGuia() {
        return idTipoMvtoGuia;
    }

    public void setIdTipoMvtoGuia(Integer idTipoMvtoGuia) {
        this.idTipoMvtoGuia = idTipoMvtoGuia;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public BigDecimal getTotalPesoBruto() {
        return totalPesoBruto;
    }

    public void setTotalPesoBruto(BigDecimal totalPesoBruto) {
        this.totalPesoBruto = totalPesoBruto;
    }

    public BigDecimal getTotalPesoTara() {
        return totalPesoTara;
    }

    public void setTotalPesoTara(BigDecimal totalPesoTara) {
        this.totalPesoTara = totalPesoTara;
    }

    public BigDecimal getTotalPesoDevolucion() {
        return totalPesoDevolucion;
    }

    public void setTotalPesoDevolucion(BigDecimal totalPesoDevolucion) {
        this.totalPesoDevolucion = totalPesoDevolucion;
    }

    public BigDecimal getTotalPesoNeto() {
        return totalPesoNeto;
    }

    public void setTotalPesoNeto(BigDecimal totalPesoNeto) {
        this.totalPesoNeto = totalPesoNeto;
    }

    public BigDecimal getPrecioAplicado() {
        return precioAplicado;
    }

    public void setPrecioAplicado(BigDecimal precioAplicado) {
        this.precioAplicado = precioAplicado;
    }

    public Integer getIdMonedaLocal() {
        return idMonedaLocal;
    }

    public void setIdMonedaLocal(Integer idMonedaLocal) {
        this.idMonedaLocal = idMonedaLocal;
    }

    public BigDecimal getTotalImporte() {
        return totalImporte;
    }

    public void setTotalImporte(BigDecimal totalImporte) {
        this.totalImporte = totalImporte;
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

    public Integer getIdGuiaReferencia() {
        return idGuiaReferencia;
    }

    public void setIdGuiaReferencia(Integer idGuiaReferencia) {
        this.idGuiaReferencia = idGuiaReferencia;
    }

    public Integer getIdTipoGuia() {
        return idTipoGuia;
    }

    public void setIdTipoGuia(Integer idTipoGuia) {
        this.idTipoGuia = idTipoGuia;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public List<GuiaSaldo> getGuiaSaldoList() {
        return guiaSaldoList;
    }

    public void setGuiaSaldoList(List<GuiaSaldo> guiaSaldoList) {
        this.guiaSaldoList = guiaSaldoList;
    }

    public List<GuiaPeso> getGuiaPesoList() {
        return guiaPesoList;
    }

    public void setGuiaPesoList(List<GuiaPeso> guiaPesoList) {
        this.guiaPesoList = guiaPesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuia != null ? idGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idGuia == null && other.idGuia != null) || (this.idGuia != null && !this.idGuia.equals(other.idGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.Guia[ idGuia=" + idGuia + " ]";
    }
    
}
