/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import pe.com.coravi.domain.hibernate.util.AbstractDomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "comprobante_item", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "ComprobanteItem.findAll", query = "SELECT c FROM ComprobanteItem c")
    , @NamedQuery(name = "ComprobanteItem.findByIdComprobanteItem", query = "SELECT c FROM ComprobanteItem c WHERE c.idComprobanteItem = :idComprobanteItem")
    , @NamedQuery(name = "ComprobanteItem.findByCantidadArticulo", query = "SELECT c FROM ComprobanteItem c WHERE c.cantidadArticulo = :cantidadArticulo")
    , @NamedQuery(name = "ComprobanteItem.findByIdUnidadMedida", query = "SELECT c FROM ComprobanteItem c WHERE c.idUnidadMedida = :idUnidadMedida")
    , @NamedQuery(name = "ComprobanteItem.findByPesoArticulo", query = "SELECT c FROM ComprobanteItem c WHERE c.pesoArticulo = :pesoArticulo")
    , @NamedQuery(name = "ComprobanteItem.findByPrecioUnitario", query = "SELECT c FROM ComprobanteItem c WHERE c.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "ComprobanteItem.findByImporteTotal", query = "SELECT c FROM ComprobanteItem c WHERE c.importeTotal = :importeTotal")
    , @NamedQuery(name = "ComprobanteItem.findByIdEstado", query = "SELECT c FROM ComprobanteItem c WHERE c.idEstado = :idEstado")
    , @NamedQuery(name = "ComprobanteItem.findByIdUsuarioReg", query = "SELECT c FROM ComprobanteItem c WHERE c.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "ComprobanteItem.findByFechaRegistro", query = "SELECT c FROM ComprobanteItem c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "ComprobanteItem.findByIdUsuarioMod", query = "SELECT c FROM ComprobanteItem c WHERE c.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "ComprobanteItem.findByFechaModificacion", query = "SELECT c FROM ComprobanteItem c WHERE c.fechaModificacion = :fechaModificacion")})
public class ComprobanteItem extends AbstractDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante_item", nullable = false)
    private Integer idComprobanteItem;

    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", nullable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;

    @Column(name = "cantidad_articulo")
    private Integer cantidadArticulo;

    @Column(name = "id_unidad_medida")
    private Integer idUnidadMedida;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_articulo", precision = 10, scale = 2)
    private BigDecimal pesoArticulo;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "importe_total", precision = 10, scale = 2)
    private BigDecimal importeTotal;

    @JoinColumn(name = "id_comprobante_pago", referencedColumnName = "id_comprobante_pago", nullable = false)
    @ManyToOne(optional = false)
    private ComprobantePago comprobantePago;

    public ComprobanteItem() {
    }

    public Integer getIdComprobanteItem() {
        return idComprobanteItem;
    }

    public void setIdComprobanteItem(Integer idComprobanteItem) {
        this.idComprobanteItem = idComprobanteItem;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(Integer cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public BigDecimal getPesoArticulo() {
        return pesoArticulo;
    }

    public void setPesoArticulo(BigDecimal pesoArticulo) {
        this.pesoArticulo = pesoArticulo;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComprobanteItem)) return false;
        ComprobanteItem that = (ComprobanteItem) o;
        return Objects.equals(idComprobanteItem, that.idComprobanteItem) &&
                Objects.equals(articulo, that.articulo) &&
                Objects.equals(cantidadArticulo, that.cantidadArticulo) &&
                Objects.equals(idUnidadMedida, that.idUnidadMedida) &&
                Objects.equals(pesoArticulo, that.pesoArticulo) &&
                Objects.equals(precioUnitario, that.precioUnitario) &&
                Objects.equals(importeTotal, that.importeTotal) &&
                Objects.equals(comprobantePago, that.comprobantePago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComprobanteItem, articulo, cantidadArticulo, idUnidadMedida, pesoArticulo, precioUnitario, importeTotal, comprobantePago);
    }

    @Override
    public String toString() {
        return "ComprobanteItem{" +
                "idComprobanteItem=" + idComprobanteItem +
                ", articulo=" + articulo +
                ", cantidadArticulo=" + cantidadArticulo +
                ", idUnidadMedida=" + idUnidadMedida +
                ", pesoArticulo=" + pesoArticulo +
                ", precioUnitario=" + precioUnitario +
                ", importeTotal=" + importeTotal +
                ", comprobantePago=" + comprobantePago +
                '}';
    }
}
