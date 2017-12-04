package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class GuiaKey implements Serializable {
    private Integer id_guia;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia() {
        return id_guia;
    }

    public void setId_guia(Integer id_guia) {
        this.id_guia = id_guia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia=").append(id_guia);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}