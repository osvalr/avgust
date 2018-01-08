/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import pe.com.coravi.domain.hibernate.util.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "comprobante_pago", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "ComprobantePago.findAll", query = "SELECT c FROM ComprobantePago c")
    , @NamedQuery(name = "ComprobantePago.findByIdComprobantePago", query = "SELECT c FROM ComprobantePago c WHERE c.idComprobantePago = :idComprobantePago")
    , @NamedQuery(name = "ComprobantePago.findByIdTipoComprobantePago", query = "SELECT c FROM ComprobantePago c WHERE c.idTipoComprobantePago = :idTipoComprobantePago")
    , @NamedQuery(name = "ComprobantePago.findByFechaEmision", query = "SELECT c FROM ComprobantePago c WHERE c.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "ComprobantePago.findByFechaCancelado", query = "SELECT c FROM ComprobantePago c WHERE c.fechaCancelado = :fechaCancelado")
    , @NamedQuery(name = "ComprobantePago.findBySerieDocuComprobante", query = "SELECT c FROM ComprobantePago c WHERE c.serieDocuComprobante = :serieDocuComprobante")
    , @NamedQuery(name = "ComprobantePago.findByCorrelativoDocuCdp", query = "SELECT c FROM ComprobantePago c WHERE c.correlativoDocuCdp = :correlativoDocuCdp")
    , @NamedQuery(name = "ComprobantePago.findByNumDocuComprobante", query = "SELECT c FROM ComprobantePago c WHERE c.numDocuComprobante = :numDocuComprobante")
    , @NamedQuery(name = "ComprobantePago.findByIdCliente", query = "SELECT c FROM ComprobantePago c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ComprobantePago.findBySubTotalVenta", query = "SELECT c FROM ComprobantePago c WHERE c.subTotalVenta = :subTotalVenta")
    , @NamedQuery(name = "ComprobantePago.findByValorIgvVenta", query = "SELECT c FROM ComprobantePago c WHERE c.valorIgvVenta = :valorIgvVenta")
    , @NamedQuery(name = "ComprobantePago.findByImporteTotal", query = "SELECT c FROM ComprobantePago c WHERE c.importeTotal = :importeTotal")
    , @NamedQuery(name = "ComprobantePago.findByFlagPercepcion", query = "SELECT c FROM ComprobantePago c WHERE c.flagPercepcion = :flagPercepcion")
    , @NamedQuery(name = "ComprobantePago.findByPorcentajePercepcion", query = "SELECT c FROM ComprobantePago c WHERE c.porcentajePercepcion = :porcentajePercepcion")
    , @NamedQuery(name = "ComprobantePago.findByMontoPercepcion", query = "SELECT c FROM ComprobantePago c WHERE c.montoPercepcion = :montoPercepcion")
    , @NamedQuery(name = "ComprobantePago.findByIdEstado", query = "SELECT c FROM ComprobantePago c WHERE c.idEstado = :idEstado")
    , @NamedQuery(name = "ComprobantePago.findByIdUsuarioReg", query = "SELECT c FROM ComprobantePago c WHERE c.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "ComprobantePago.findByFechaRegistro", query = "SELECT c FROM ComprobantePago c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "ComprobantePago.findByIdUsuarioMod", query = "SELECT c FROM ComprobantePago c WHERE c.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "ComprobantePago.findByFechaModificacion", query = "SELECT c FROM ComprobantePago c WHERE c.fechaModificacion = :fechaModificacion")})
public class ComprobantePago extends AbstractDomain implements Serializable {

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

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobantePago")
//    private List<ComprobanteItem> comprobanteItemList;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobantePago")
//    private List<GuiaRemision> guiaRemisionList;

    public ComprobantePago() {
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

    @Override
    public String toString() {
        return "ComprobantePago{" +
                "idComprobantePago=" + idComprobantePago +
                ", idTipoComprobantePago=" + idTipoComprobantePago +
                ", fechaEmision=" + fechaEmision +
                ", fechaCancelado=" + fechaCancelado +
                ", serieDocuComprobante='" + serieDocuComprobante + '\'' +
                ", correlativoDocuCdp='" + correlativoDocuCdp + '\'' +
                ", numDocuComprobante='" + numDocuComprobante + '\'' +
                ", idCliente=" + idCliente +
                ", subTotalVenta=" + subTotalVenta +
                ", valorIgvVenta=" + valorIgvVenta +
                ", importeTotal=" + importeTotal +
                ", flagPercepcion=" + flagPercepcion +
                ", porcentajePercepcion=" + porcentajePercepcion +
                ", montoPercepcion=" + montoPercepcion +
                '}';
    }
}
