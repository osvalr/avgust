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
@Table(name = "comprobante_pago", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "ComprobantePago.findAll", query = "SELECT c FROM ComprobantePago c")})
public class ComprobantePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante_pago", nullable = false)
    private Integer idComprobantePago;
    @Column(name = "id_tipo_comprobante_pago")
    private Integer idTipoComprobantePago;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_cancelado")
    @Temporal(TemporalType.DATE)
    private Date fechaCancelado;
    @Size(max = 10)
    @Column(name = "serie_docu_comprobante", length = 10)
    private String serieDocuComprobante;
    @Size(max = 50)
    @Column(name = "correlativo_docu_cdp", length = 50)
    private String correlativoDocuCdp;
    @Size(max = 50)
    @Column(name = "num_docu_comprobante", length = 50)
    private String numDocuComprobante;
    @Column(name = "id_cliente")
    private Integer idCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_total_venta", precision = 10, scale = 2)
    private BigDecimal subTotalVenta;
    @Column(name = "valor_igv_venta", precision = 10, scale = 2)
    private BigDecimal valorIgvVenta;
    @Column(name = "importe_total", precision = 10, scale = 2)
    private BigDecimal importeTotal;
    @Column(name = "flag_percepcion")
    private Integer flagPercepcion;
    @Column(name = "porcentaje_percepcion", precision = 10, scale = 4)
    private BigDecimal porcentajePercepcion;
    @Column(name = "monto_percepcion", precision = 10, scale = 2)
    private BigDecimal montoPercepcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobantePago")
    private List<ComprobanteItem> comprobanteItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobantePago")
    private List<GuiaRemision> guiaRemisionList;

    public ComprobantePago() {
    }

    public ComprobantePago(Integer idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    public Integer getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(Integer idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    public Integer getIdTipoComprobantePago() {
        return idTipoComprobantePago;
    }

    public void setIdTipoComprobantePago(Integer idTipoComprobantePago) {
        this.idTipoComprobantePago = idTipoComprobantePago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCancelado() {
        return fechaCancelado;
    }

    public void setFechaCancelado(Date fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public String getSerieDocuComprobante() {
        return serieDocuComprobante;
    }

    public void setSerieDocuComprobante(String serieDocuComprobante) {
        this.serieDocuComprobante = serieDocuComprobante;
    }

    public String getCorrelativoDocuCdp() {
        return correlativoDocuCdp;
    }

    public void setCorrelativoDocuCdp(String correlativoDocuCdp) {
        this.correlativoDocuCdp = correlativoDocuCdp;
    }

    public String getNumDocuComprobante() {
        return numDocuComprobante;
    }

    public void setNumDocuComprobante(String numDocuComprobante) {
        this.numDocuComprobante = numDocuComprobante;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getSubTotalVenta() {
        return subTotalVenta;
    }

    public void setSubTotalVenta(BigDecimal subTotalVenta) {
        this.subTotalVenta = subTotalVenta;
    }

    public BigDecimal getValorIgvVenta() {
        return valorIgvVenta;
    }

    public void setValorIgvVenta(BigDecimal valorIgvVenta) {
        this.valorIgvVenta = valorIgvVenta;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Integer getFlagPercepcion() {
        return flagPercepcion;
    }

    public void setFlagPercepcion(Integer flagPercepcion) {
        this.flagPercepcion = flagPercepcion;
    }

    public BigDecimal getPorcentajePercepcion() {
        return porcentajePercepcion;
    }

    public void setPorcentajePercepcion(BigDecimal porcentajePercepcion) {
        this.porcentajePercepcion = porcentajePercepcion;
    }

    public BigDecimal getMontoPercepcion() {
        return montoPercepcion;
    }

    public void setMontoPercepcion(BigDecimal montoPercepcion) {
        this.montoPercepcion = montoPercepcion;
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

    public List<ComprobanteItem> getComprobanteItemList() {
        return comprobanteItemList;
    }

    public void setComprobanteItemList(List<ComprobanteItem> comprobanteItemList) {
        this.comprobanteItemList = comprobanteItemList;
    }

    public List<GuiaRemision> getGuiaRemisionList() {
        return guiaRemisionList;
    }

    public void setGuiaRemisionList(List<GuiaRemision> guiaRemisionList) {
        this.guiaRemisionList = guiaRemisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobantePago != null ? idComprobantePago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantePago)) {
            return false;
        }
        ComprobantePago other = (ComprobantePago) object;
        if ((this.idComprobantePago == null && other.idComprobantePago != null) || (this.idComprobantePago != null && !this.idComprobantePago.equals(other.idComprobantePago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.ComprobantePago[ idComprobantePago=" + idComprobantePago + " ]";
    }
    
}
