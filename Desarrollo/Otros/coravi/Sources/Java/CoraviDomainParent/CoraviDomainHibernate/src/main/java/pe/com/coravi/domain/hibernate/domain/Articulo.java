/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import pe.com.coravi.domain.hibernate.util.AbstractDomain;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(catalog = "bd_acme", schema = "general", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo_articulo"})})
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articulo.findByCodigoArticulo", query = "SELECT a FROM Articulo a WHERE a.codigoArticulo = :codigoArticulo")
    , @NamedQuery(name = "Articulo.findByNombreArticulo", query = "SELECT a FROM Articulo a WHERE a.nombreArticulo = :nombreArticulo")
    , @NamedQuery(name = "Articulo.findByIdEstado", query = "SELECT a FROM Articulo a WHERE a.idEstado = :idEstado")
    , @NamedQuery(name = "Articulo.findByIdUsuarioReg", query = "SELECT a FROM Articulo a WHERE a.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "Articulo.findByFechaRegistro", query = "SELECT a FROM Articulo a WHERE a.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Articulo.findByIdUsuarioMod", query = "SELECT a FROM Articulo a WHERE a.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "Articulo.findByFechaModificacion", query = "SELECT a FROM Articulo a WHERE a.fechaModificacion = :fechaModificacion")})
public class Articulo extends AbstractDomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo", nullable = false)
    private Integer idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_articulo", nullable = false, length = 100)
    private String codigoArticulo;
    @Size(max = 500)
    @Column(name = "nombre_articulo", length = 500)
    private String nombreArticulo;

    public Articulo() {
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
}
