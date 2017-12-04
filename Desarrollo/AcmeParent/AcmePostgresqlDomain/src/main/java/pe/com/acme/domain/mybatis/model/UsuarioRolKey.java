package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class UsuarioRolKey implements Serializable {
    private Integer id_usuario;

    private Integer id_rol;

    private Integer id_aplicacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", id_rol=").append(id_rol);
        sb.append(", id_aplicacion=").append(id_aplicacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}