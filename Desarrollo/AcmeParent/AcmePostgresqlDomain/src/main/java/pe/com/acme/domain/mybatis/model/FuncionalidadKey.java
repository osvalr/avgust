package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class FuncionalidadKey implements Serializable {
    private Integer id_funcionalidad;

    private static final long serialVersionUID = 1L;

    public Integer getId_funcionalidad() {
        return id_funcionalidad;
    }

    public void setId_funcionalidad(Integer id_funcionalidad) {
        this.id_funcionalidad = id_funcionalidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_funcionalidad=").append(id_funcionalidad);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}