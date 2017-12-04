package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class GuiaPesoKey implements Serializable {
    private Integer id_guia_peso;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia_peso() {
        return id_guia_peso;
    }

    public void setId_guia_peso(Integer id_guia_peso) {
        this.id_guia_peso = id_guia_peso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia_peso=").append(id_guia_peso);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}