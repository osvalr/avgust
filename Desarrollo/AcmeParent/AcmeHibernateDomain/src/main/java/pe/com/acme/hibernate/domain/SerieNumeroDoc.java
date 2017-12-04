/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "serie_numero_doc", catalog = "bd_acme", schema = "general")
@NamedQueries({
    @NamedQuery(name = "SerieNumeroDoc.findAll", query = "SELECT s FROM SerieNumeroDoc s")})
public class SerieNumeroDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_serie_numero_doc", nullable = false)
    private Integer idSerieNumeroDoc;
    @Size(max = 50)
    @Column(length = 50)
    private String serie;
    @Column(name = "numero_doc")
    private Integer numeroDoc;
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    private Integer longitud;
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

    public SerieNumeroDoc() {
    }

    public SerieNumeroDoc(Integer idSerieNumeroDoc) {
        this.idSerieNumeroDoc = idSerieNumeroDoc;
    }

    public Integer getIdSerieNumeroDoc() {
        return idSerieNumeroDoc;
    }

    public void setIdSerieNumeroDoc(Integer idSerieNumeroDoc) {
        this.idSerieNumeroDoc = idSerieNumeroDoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(Integer numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerieNumeroDoc != null ? idSerieNumeroDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerieNumeroDoc)) {
            return false;
        }
        SerieNumeroDoc other = (SerieNumeroDoc) object;
        if ((this.idSerieNumeroDoc == null && other.idSerieNumeroDoc != null) || (this.idSerieNumeroDoc != null && !this.idSerieNumeroDoc.equals(other.idSerieNumeroDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.SerieNumeroDoc[ idSerieNumeroDoc=" + idSerieNumeroDoc + " ]";
    }
    
}
