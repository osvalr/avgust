/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
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
@Table(name = "guia_remision", catalog = "bd_acme", schema = "ventas")
@NamedQueries({
    @NamedQuery(name = "GuiaRemision.findAll", query = "SELECT g FROM GuiaRemision g")})
public class GuiaRemision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_remision", nullable = false)
    private Integer idGuiaRemision;
    @Size(max = 10)
    @Column(name = "serie_docu_guia", length = 10)
    private String serieDocuGuia;
    @Size(max = 50)
    @Column(name = "correlativo_docu_guia", length = 50)
    private String correlativoDocuGuia;
    @Size(max = 50)
    @Column(name = "num_docu_guia", length = 50)
    private String numDocuGuia;
    @Column(name = "fecha_inicio_traslado")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioTraslado;
    @Column(name = "id_destinatario")
    private Integer idDestinatario;
    @Column(name = "id_motivo_traslado")
    private Integer idMotivoTraslado;
    @Size(max = 1000)
    @Column(name = "direccion_partida", length = 1000)
    private String direccionPartida;
    @Size(max = 10)
    @Column(name = "codigo_departamento_partida", length = 10)
    private String codigoDepartamentoPartida;
    @Size(max = 10)
    @Column(name = "codigo_provincia_partida", length = 10)
    private String codigoProvinciaPartida;
    @Size(max = 10)
    @Column(name = "codigo_distrito_partida", length = 10)
    private String codigoDistritoPartida;
    @Size(max = 1000)
    @Column(name = "direccion_llegada", length = 1000)
    private String direccionLlegada;
    @Size(max = 10)
    @Column(name = "codigo_departamento_llegada", length = 10)
    private String codigoDepartamentoLlegada;
    @Size(max = 10)
    @Column(name = "codigo_provincia_llegada", length = 10)
    private String codigoProvinciaLlegada;
    @Size(max = 10)
    @Column(name = "codigo_distrito_llegada", length = 10)
    private String codigoDistritoLlegada;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuiaRemision")
    private List<GuiaRemisionItem> guiaRemisionItemList;

    public GuiaRemision() {
    }

    public GuiaRemision(Integer idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

    public Integer getIdGuiaRemision() {
        return idGuiaRemision;
    }

    public void setIdGuiaRemision(Integer idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

    public String getSerieDocuGuia() {
        return serieDocuGuia;
    }

    public void setSerieDocuGuia(String serieDocuGuia) {
        this.serieDocuGuia = serieDocuGuia;
    }

    public String getCorrelativoDocuGuia() {
        return correlativoDocuGuia;
    }

    public void setCorrelativoDocuGuia(String correlativoDocuGuia) {
        this.correlativoDocuGuia = correlativoDocuGuia;
    }

    public String getNumDocuGuia() {
        return numDocuGuia;
    }

    public void setNumDocuGuia(String numDocuGuia) {
        this.numDocuGuia = numDocuGuia;
    }

    public Date getFechaInicioTraslado() {
        return fechaInicioTraslado;
    }

    public void setFechaInicioTraslado(Date fechaInicioTraslado) {
        this.fechaInicioTraslado = fechaInicioTraslado;
    }

    public Integer getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Integer idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public Integer getIdMotivoTraslado() {
        return idMotivoTraslado;
    }

    public void setIdMotivoTraslado(Integer idMotivoTraslado) {
        this.idMotivoTraslado = idMotivoTraslado;
    }

    public String getDireccionPartida() {
        return direccionPartida;
    }

    public void setDireccionPartida(String direccionPartida) {
        this.direccionPartida = direccionPartida;
    }

    public String getCodigoDepartamentoPartida() {
        return codigoDepartamentoPartida;
    }

    public void setCodigoDepartamentoPartida(String codigoDepartamentoPartida) {
        this.codigoDepartamentoPartida = codigoDepartamentoPartida;
    }

    public String getCodigoProvinciaPartida() {
        return codigoProvinciaPartida;
    }

    public void setCodigoProvinciaPartida(String codigoProvinciaPartida) {
        this.codigoProvinciaPartida = codigoProvinciaPartida;
    }

    public String getCodigoDistritoPartida() {
        return codigoDistritoPartida;
    }

    public void setCodigoDistritoPartida(String codigoDistritoPartida) {
        this.codigoDistritoPartida = codigoDistritoPartida;
    }

    public String getDireccionLlegada() {
        return direccionLlegada;
    }

    public void setDireccionLlegada(String direccionLlegada) {
        this.direccionLlegada = direccionLlegada;
    }

    public String getCodigoDepartamentoLlegada() {
        return codigoDepartamentoLlegada;
    }

    public void setCodigoDepartamentoLlegada(String codigoDepartamentoLlegada) {
        this.codigoDepartamentoLlegada = codigoDepartamentoLlegada;
    }

    public String getCodigoProvinciaLlegada() {
        return codigoProvinciaLlegada;
    }

    public void setCodigoProvinciaLlegada(String codigoProvinciaLlegada) {
        this.codigoProvinciaLlegada = codigoProvinciaLlegada;
    }

    public String getCodigoDistritoLlegada() {
        return codigoDistritoLlegada;
    }

    public void setCodigoDistritoLlegada(String codigoDistritoLlegada) {
        this.codigoDistritoLlegada = codigoDistritoLlegada;
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

    public List<GuiaRemisionItem> getGuiaRemisionItemList() {
        return guiaRemisionItemList;
    }

    public void setGuiaRemisionItemList(List<GuiaRemisionItem> guiaRemisionItemList) {
        this.guiaRemisionItemList = guiaRemisionItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaRemision != null ? idGuiaRemision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaRemision)) {
            return false;
        }
        GuiaRemision other = (GuiaRemision) object;
        if ((this.idGuiaRemision == null && other.idGuiaRemision != null) || (this.idGuiaRemision != null && !this.idGuiaRemision.equals(other.idGuiaRemision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.GuiaRemision[ idGuiaRemision=" + idGuiaRemision + " ]";
    }
    
}
