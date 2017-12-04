package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class PerfilAplicacionKey implements Serializable {
    private Integer id_aplicacion;

    private Integer id_perfil;

    private static final long serialVersionUID = 1L;

    public Integer getId_aplicacion() {
        return id_aplicacion;
    }

    public void setId_aplicacion(Integer id_aplicacion) {
        this.id_aplicacion = id_aplicacion;
    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_aplicacion=").append(id_aplicacion);
        sb.append(", id_perfil=").append(id_perfil);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}