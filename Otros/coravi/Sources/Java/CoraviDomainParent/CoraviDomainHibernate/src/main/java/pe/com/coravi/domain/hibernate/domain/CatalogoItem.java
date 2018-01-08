/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "catalogo_item", catalog = "bd_acme", schema = "general")
@NamedQueries({
    @NamedQuery(name = "CatalogoItem.findAll", query = "SELECT c FROM CatalogoItem c")
    , @NamedQuery(name = "CatalogoItem.findByIdCatalogoItem", query = "SELECT c FROM CatalogoItem c WHERE c.idCatalogoItem = :idCatalogoItem")
    , @NamedQuery(name = "CatalogoItem.findByValorItem", query = "SELECT c FROM CatalogoItem c WHERE c.valorItem = :valorItem")
    , @NamedQuery(name = "CatalogoItem.findByDescripItem", query = "SELECT c FROM CatalogoItem c WHERE c.descripItem = :descripItem")
    , @NamedQuery(name = "CatalogoItem.findByValorA", query = "SELECT c FROM CatalogoItem c WHERE c.valorA = :valorA")
    , @NamedQuery(name = "CatalogoItem.findByValorB", query = "SELECT c FROM CatalogoItem c WHERE c.valorB = :valorB")
    , @NamedQuery(name = "CatalogoItem.findByValorC", query = "SELECT c FROM CatalogoItem c WHERE c.valorC = :valorC")
    , @NamedQuery(name = "CatalogoItem.findByValorD", query = "SELECT c FROM CatalogoItem c WHERE c.valorD = :valorD")
    , @NamedQuery(name = "CatalogoItem.findByValorE", query = "SELECT c FROM CatalogoItem c WHERE c.valorE = :valorE")
    , @NamedQuery(name = "CatalogoItem.findByIdEstado", query = "SELECT c FROM CatalogoItem c WHERE c.idEstado = :idEstado")
    , @NamedQuery(name = "CatalogoItem.findByIdUsuarioReg", query = "SELECT c FROM CatalogoItem c WHERE c.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "CatalogoItem.findByFechaRegistro", query = "SELECT c FROM CatalogoItem c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "CatalogoItem.findByIdUsuarioMod", query = "SELECT c FROM CatalogoItem c WHERE c.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "CatalogoItem.findByFechaModificacion", query = "SELECT c FROM CatalogoItem c WHERE c.fechaModificacion = :fechaModificacion")})
public class CatalogoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_catalogo_item", nullable = false)
    private Integer idCatalogoItem;
    @Column(name = "valor_item")
    private Short valorItem;
    @Size(max = 500)
    @Column(name = "descrip_item", length = 500)
    private String descripItem;
    @Size(max = 500)
    @Column(name = "valor_a", length = 500)
    private String valorA;
    @Size(max = 500)
    @Column(name = "valor_b", length = 500)
    private String valorB;
    @Size(max = 500)
    @Column(name = "valor_c", length = 500)
    private String valorC;
    @Size(max = 500)
    @Column(name = "valor_d", length = 500)
    private String valorD;
    @Size(max = 500)
    @Column(name = "valor_e", length = 500)
    private String valorE;
    @Column(name = "id_estado")
    private Short idEstado;
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
    @JoinColumn(name = "id_catalogo", referencedColumnName = "id_catalogo", nullable = false)
    @ManyToOne(optional = false)
    private Catalogo idCatalogo;

    public CatalogoItem() {
    }

    public CatalogoItem(Integer idCatalogoItem) {
        this.idCatalogoItem = idCatalogoItem;
    }

    public Integer getIdCatalogoItem() {
        return idCatalogoItem;
    }

    public void setIdCatalogoItem(Integer idCatalogoItem) {
        this.idCatalogoItem = idCatalogoItem;
    }

    public Short getValorItem() {
        return valorItem;
    }

    public void setValorItem(Short valorItem) {
        this.valorItem = valorItem;
    }

    public String getDescripItem() {
        return descripItem;
    }

    public void setDescripItem(String descripItem) {
        this.descripItem = descripItem;
    }

    public String getValorA() {
        return valorA;
    }

    public void setValorA(String valorA) {
        this.valorA = valorA;
    }

    public String getValorB() {
        return valorB;
    }

    public void setValorB(String valorB) {
        this.valorB = valorB;
    }

    public String getValorC() {
        return valorC;
    }

    public void setValorC(String valorC) {
        this.valorC = valorC;
    }

    public String getValorD() {
        return valorD;
    }

    public void setValorD(String valorD) {
        this.valorD = valorD;
    }

    public String getValorE() {
        return valorE;
    }

    public void setValorE(String valorE) {
        this.valorE = valorE;
    }

    public Short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Short idEstado) {
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

    public Catalogo getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Catalogo idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogoItem != null ? idCatalogoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoItem)) {
            return false;
        }
        CatalogoItem other = (CatalogoItem) object;
        if ((this.idCatalogoItem == null && other.idCatalogoItem != null) || (this.idCatalogoItem != null && !this.idCatalogoItem.equals(other.idCatalogoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.CatalogoItem[ idCatalogoItem=" + idCatalogoItem + " ]";
    }
    
}
