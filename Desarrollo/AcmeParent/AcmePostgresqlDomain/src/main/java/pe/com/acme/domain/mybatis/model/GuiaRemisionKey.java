package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class GuiaRemisionKey implements Serializable {
    private Integer id_guia_remision;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia_remision() {
        return id_guia_remision;
    }

    public void setId_guia_remision(Integer id_guia_remision) {
        this.id_guia_remision = id_guia_remision;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia_remision=").append(id_guia_remision);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}