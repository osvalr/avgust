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
import javax.validation.constraints.NotNull;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "guia_remision_item", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "GuiaRemisionItem.findAll", query = "SELECT g FROM GuiaRemisionItem g")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdGuiaRemisionItem", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idGuiaRemisionItem = :idGuiaRemisionItem")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdArticulo", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idArticulo = :idArticulo")
    , @NamedQuery(name = "GuiaRemisionItem.findByCantidadArticulo", query = "SELECT g FROM GuiaRemisionItem g WHERE g.cantidadArticulo = :cantidadArticulo")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdUnidadMedida", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idUnidadMedida = :idUnidadMedida")
    , @NamedQuery(name = "GuiaRemisionItem.findByPesoTotal", query = "SELECT g FROM GuiaRemisionItem g WHERE g.pesoTotal = :pesoTotal")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdEstado", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idEstado = :idEstado")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdUsuarioReg", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "GuiaRemisionItem.findByFechaRegistro", query = "SELECT g FROM GuiaRemisionItem g WHERE g.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "GuiaRemisionItem.findByIdUsuarioMod", query = "SELECT g FROM GuiaRemisionItem g WHERE g.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "GuiaRemisionItem.findByFechaModificacion", query = "SELECT g FROM GuiaRemisionItem g WHERE g.fechaModificacion = :fechaModificacion")})
public class GuiaRemisionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_remision_item", nullable = false)
    private Integer idGuiaRemisionItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo", nullable = false)
    private int idArticulo;
    @Column(name = "cantidad_articulo")
    private Integer cantidadArticulo;
    @Column(name = "id_unidad_medida")
    private Integer idUnidadMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_total", precision = 10, scale = 2)
    private BigDecimal pesoTotal;
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
    @JoinColumn(name = "id_guia_remision", referencedColumnName = "id_guia_remision", nullable = false)
    @ManyToOne(optional = false)
    private GuiaRemision idGuiaRemision;

    public GuiaRemisionItem() {
    }

    public GuiaRemisionItem(Integer idGuiaRemisionItem) {
        this.idGuiaRemisionItem = idGuiaRemisionItem;
    }

    public GuiaRemisionItem(Integer idGuiaRemisionItem, int idArticulo) {
        this.idGuiaRemisionItem = idGuiaRemisionItem;
        this.idArticulo = idArticulo;
    }

    public Integer getIdGuiaRemisionItem() {
        return idGuiaRemisionItem;
    }

    public void setIdGuiaRemisionItem(Integer idGuiaRemisionItem) {
        this.idGuiaRemisionItem = idGuiaRemisionItem;
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

    public BigDecimal getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(BigDecimal pesoTotal) {
        this.pesoTotal = pesoTotal;
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

    public GuiaRemision getIdGuiaRemision() {
        return idGuiaRemision;
    }

    public void setIdGuiaRemision(GuiaRemision idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaRemisionItem != null ? idGuiaRemisionItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaRemisionItem)) {
            return false;
        }
        GuiaRemisionItem other = (GuiaRemisionItem) object;
        if ((this.idGuiaRemisionItem == null && other.idGuiaRemisionItem != null) || (this.idGuiaRemisionItem != null && !this.idGuiaRemisionItem.equals(other.idGuiaRemisionItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.GuiaRemisionItem[ idGuiaRemisionItem=" + idGuiaRemisionItem + " ]";
    }
    
}
