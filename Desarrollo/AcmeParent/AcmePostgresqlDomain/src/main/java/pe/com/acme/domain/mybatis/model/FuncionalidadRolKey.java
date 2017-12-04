package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class FuncionalidadRolKey implements Serializable {
    private Integer id_funcionalidad;

    private Integer id_rol;

    private Integer id_aplicacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_funcionalidad() {
        return id_funcionalidad;
    }

    public void setId_funcionalidad(Integer id_funcionalidad) {
        this.id_funcionalidad = id_funcionalidad;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

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
        sb.append(", id_funcionalidad=").append(id_funcionalidad);
        sb.append(", id_rol=").append(id_rol);
        sb.append(", id_aplicacion=").append(id_aplicacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}