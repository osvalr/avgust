/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

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
import javax.validation.constraints.NotNull;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "comprobante_item", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "ComprobanteItem.findAll", query = "SELECT c FROM ComprobanteItem c")})
public class ComprobanteItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante_item", nullable = false)
    private Integer idComprobanteItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo", nullable = false)
    private int idArticulo;
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
    @JoinColumn(name = "id_comprobante_pago", referencedColumnName = "id_comprobante_pago", nullable = false)
    @ManyToOne(optional = false)
    private ComprobantePago idComprobantePago;

    public ComprobanteItem() {
    }

    public ComprobanteItem(Integer idComprobanteItem) {
        this.idComprobanteItem = idComprobanteItem;
    }

    public ComprobanteItem(Integer idComprobanteItem, int idArticulo) {
        this.idComprobanteItem = idComprobanteItem;
        this.idArticulo = idArticulo;
    }

    public Integer getIdComprobanteItem() {
        return idComprobanteItem;
    }

    public void setIdComprobanteItem(Integer idComprobanteItem) {
        this.idComprobanteItem = idComprobanteItem;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
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

    public ComprobantePago getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(ComprobantePago idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobanteItem != null ? idComprobanteItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteItem)) {
            return false;
        }
        ComprobanteItem other = (ComprobanteItem) object;
        if ((this.idComprobanteItem == null && other.idComprobanteItem != null) || (this.idComprobanteItem != null && !this.idComprobanteItem.equals(other.idComprobanteItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.ComprobanteItem[ idComprobanteItem=" + idComprobanteItem + " ]";
    }
    
}
