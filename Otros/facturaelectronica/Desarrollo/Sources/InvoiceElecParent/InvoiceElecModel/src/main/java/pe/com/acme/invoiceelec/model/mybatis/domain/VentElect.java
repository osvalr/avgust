package pe.com.acme.invoiceelec.model.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

public class VentElect extends VentElectKey implements Serializable {
    private String estadoDoc;

    private String rutaDocElec;

    private String rutaCodBarras;

    private String numfUsuadd;

    private Date numfFecadd;

    private String numfUsumod;

    private Date numfFecmod;

    private String rutaCodBarrasMatrix;

    private String tipDocElect;

    private String numDocElect;

    private static final long serialVersionUID = 1L;

    public String getEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(String estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    public String getRutaDocElec() {
        return rutaDocElec;
    }

    public void setRutaDocElec(String rutaDocElec) {
        this.rutaDocElec = rutaDocElec;
    }

    public String getRutaCodBarras() {
        return rutaCodBarras;
    }

    public void setRutaCodBarras(String rutaCodBarras) {
        this.rutaCodBarras = rutaCodBarras;
    }

    public String getNumfUsuadd() {
        return numfUsuadd;
    }

    public void setNumfUsuadd(String numfUsuadd) {
        this.numfUsuadd = numfUsuadd;
    }

    public Date getNumfFecadd() {
        return numfFecadd;
    }

    public void setNumfFecadd(Date numfFecadd) {
        this.numfFecadd = numfFecadd;
    }

    public String getNumfUsumod() {
        return numfUsumod;
    }

    public void setNumfUsumod(String numfUsumod) {
        this.numfUsumod = numfUsumod;
    }

    public Date getNumfFecmod() {
        return numfFecmod;
    }

    public void setNumfFecmod(Date numfFecmod) {
        this.numfFecmod = numfFecmod;
    }

    public String getRutaCodBarrasMatrix() {
        return rutaCodBarrasMatrix;
    }

    public void setRutaCodBarrasMatrix(String rutaCodBarrasMatrix) {
        this.rutaCodBarrasMatrix = rutaCodBarrasMatrix;
    }

    public String getTipDocElect() {
        return tipDocElect;
    }

    public void setTipDocElect(String tipDocElect) {
        this.tipDocElect = tipDocElect;
    }

    public String getNumDocElect() {
        return numDocElect;
    }

    public void setNumDocElect(String numDocElect) {
        this.numDocElect = numDocElect;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", estadoDoc=").append(estadoDoc);
        sb.append(", rutaDocElec=").append(rutaDocElec);
        sb.append(", rutaCodBarras=").append(rutaCodBarras);
        sb.append(", numfUsuadd=").append(numfUsuadd);
        sb.append(", numfFecadd=").append(numfFecadd);
        sb.append(", numfUsumod=").append(numfUsumod);
        sb.append(", numfFecmod=").append(numfFecmod);
        sb.append(", rutaCodBarrasMatrix=").append(rutaCodBarrasMatrix);
        sb.append(", tipDocElect=").append(tipDocElect);
        sb.append(", numDocElect=").append(numDocElect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}