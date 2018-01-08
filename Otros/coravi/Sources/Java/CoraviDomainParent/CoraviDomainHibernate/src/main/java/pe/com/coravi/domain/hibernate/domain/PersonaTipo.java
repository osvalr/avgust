/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.coravi.domain.hibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JRaffo
 */
@Entity
@Table(name = "persona_tipo", catalog = "bd_acme", schema = "general")
@NamedQueries({
    @NamedQuery(name = "PersonaTipo.findAll", query = "SELECT p FROM PersonaTipo p")
    , @NamedQuery(name = "PersonaTipo.findByIdPersona", query = "SELECT p FROM PersonaTipo p WHERE p.personaTipoPK.idPersona = :idPersona")
    , @NamedQuery(name = "PersonaTipo.findByIdTipoPersona", query = "SELECT p FROM PersonaTipo p WHERE p.personaTipoPK.idTipoPersona = :idTipoPersona")
    , @NamedQuery(name = "PersonaTipo.findByIdSubTipoPersona", query = "SELECT p FROM PersonaTipo p WHERE p.personaTipoPK.idSubTipoPersona = :idSubTipoPersona")
    , @NamedQuery(name = "PersonaTipo.findByIdEstado", query = "SELECT p FROM PersonaTipo p WHERE p.idEstado = :idEstado")
    , @NamedQuery(name = "PersonaTipo.findByIdUsuarioReg", query = "SELECT p FROM PersonaTipo p WHERE p.idUsuarioReg = :idUsuarioReg")
    , @NamedQuery(name = "PersonaTipo.findByFechaRegistro", query = "SELECT p FROM PersonaTipo p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "PersonaTipo.findByIdUsuarioMod", query = "SELECT p FROM PersonaTipo p WHERE p.idUsuarioMod = :idUsuarioMod")
    , @NamedQuery(name = "PersonaTipo.findByFechaModificacion", query = "SELECT p FROM PersonaTipo p WHERE p.fechaModificacion = :fechaModificacion")})
public class PersonaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaTipoPK personaTipoPK;
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
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public PersonaTipo() {
    }

    public PersonaTipo(PersonaTipoPK personaTipoPK) {
        this.personaTipoPK = personaTipoPK;
    }

    public PersonaTipo(int idPersona, int idTipoPersona, int idSubTipoPersona) {
        this.personaTipoPK = new PersonaTipoPK(idPersona, idTipoPersona, idSubTipoPersona);
    }

    public PersonaTipoPK getPersonaTipoPK() {
        return personaTipoPK;
    }

    public void setPersonaTipoPK(PersonaTipoPK personaTipoPK) {
        this.personaTipoPK = personaTipoPK;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaTipoPK != null ? personaTipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaTipo)) {
            return false;
        }
        PersonaTipo other = (PersonaTipo) object;
        if ((this.personaTipoPK == null && other.personaTipoPK != null) || (this.personaTipoPK != null && !this.personaTipoPK.equals(other.personaTipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.coravi.domain.hibernate.domain.PersonaTipo[ personaTipoPK=" + personaTipoPK + " ]";
    }
    
}
