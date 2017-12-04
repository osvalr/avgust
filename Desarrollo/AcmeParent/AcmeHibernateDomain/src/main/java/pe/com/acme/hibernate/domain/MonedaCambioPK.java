/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.acme.hibernate.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JRaffo
 */
@Embeddable
public class MonedaCambioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_moneda_local", nullable = false)
    private int idMonedaLocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_moneda_foranea", nullable = false)
    private int idMonedaForanea;

    public MonedaCambioPK() {
    }

    public MonedaCambioPK(int idMonedaLocal, int idMonedaForanea) {
        this.idMonedaLocal = idMonedaLocal;
        this.idMonedaForanea = idMonedaForanea;
    }

    public int getIdMonedaLocal() {
        return idMonedaLocal;
    }

    public void setIdMonedaLocal(int idMonedaLocal) {
        this.idMonedaLocal = idMonedaLocal;
    }

    public int getIdMonedaForanea() {
        return idMonedaForanea;
    }

    public void setIdMonedaForanea(int idMonedaForanea) {
        this.idMonedaForanea = idMonedaForanea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMonedaLocal;
        hash += (int) idMonedaForanea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonedaCambioPK)) {
            return false;
        }
        MonedaCambioPK other = (MonedaCambioPK) object;
        if (this.idMonedaLocal != other.idMonedaLocal) {
            return false;
        }
        if (this.idMonedaForanea != other.idMonedaForanea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.MonedaCambioPK[ idMonedaLocal=" + idMonedaLocal + ", idMonedaForanea=" + idMonedaForanea + " ]";
    }
    
}
