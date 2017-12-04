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
public class JornadaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_dia", nullable = false)
    private int numDia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_mes", nullable = false)
    private int numMes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_anio", nullable = false)
    private int numAnio;

    public JornadaPK() {
    }

    public JornadaPK(int numDia, int numMes, int numAnio) {
        this.numDia = numDia;
        this.numMes = numMes;
        this.numAnio = numAnio;
    }

    public int getNumDia() {
        return numDia;
    }

    public void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public int getNumMes() {
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }

    public int getNumAnio() {
        return numAnio;
    }

    public void setNumAnio(int numAnio) {
        this.numAnio = numAnio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numDia;
        hash += (int) numMes;
        hash += (int) numAnio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaPK)) {
            return false;
        }
        JornadaPK other = (JornadaPK) object;
        if (this.numDia != other.numDia) {
            return false;
        }
        if (this.numMes != other.numMes) {
            return false;
        }
        if (this.numAnio != other.numAnio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.acme.hibernate.domain.JornadaPK[ numDia=" + numDia + ", numMes=" + numMes + ", numAnio=" + numAnio + " ]";
    }
    
}
