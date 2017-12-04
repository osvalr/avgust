package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class GuiaRemisionItemKey implements Serializable {
    private Integer id_guia_remision_item;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia_remision_item() {
        return id_guia_remision_item;
    }

    public void setId_guia_remision_item(Integer id_guia_remision_item) {
        this.id_guia_remision_item = id_guia_remision_item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia_remision_item=").append(id_guia_remision_item);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}