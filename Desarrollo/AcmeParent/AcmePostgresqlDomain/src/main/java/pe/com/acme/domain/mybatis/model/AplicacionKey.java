package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class AplicacionKey implements Serializable {
    private Integer id_aplicacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_aplicacion() {
        return id_aplicacion;
    }

    public void setId_aplicacion(Integer id_aplicacion) {
        this.id_aplicacion = id_aplicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_aplicacion=").append(id_aplicacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}