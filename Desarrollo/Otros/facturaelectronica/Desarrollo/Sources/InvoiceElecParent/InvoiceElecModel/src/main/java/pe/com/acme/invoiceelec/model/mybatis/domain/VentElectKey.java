package pe.com.acme.invoiceelec.model.mybatis.domain;

import java.io.Serializable;

public class VentElectKey implements Serializable {
    private String empId;

    private String documKey;

    private String numfSerie;

    private Integer numfCorrel;

    private static final long serialVersionUID = 1L;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDocumKey() {
        return documKey;
    }

    public void setDocumKey(String documKey) {
        this.documKey = documKey;
    }

    public String getNumfSerie() {
        return numfSerie;
    }

    public void setNumfSerie(String numfSerie) {
        this.numfSerie = numfSerie;
    }

    public Integer getNumfCorrel() {
        return numfCorrel;
    }

    public void setNumfCorrel(Integer numfCorrel) {
        this.numfCorrel = numfCorrel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empId=").append(empId);
        sb.append(", documKey=").append(documKey);
        sb.append(", numfSerie=").append(numfSerie);
        sb.append(", numfCorrel=").append(numfCorrel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}