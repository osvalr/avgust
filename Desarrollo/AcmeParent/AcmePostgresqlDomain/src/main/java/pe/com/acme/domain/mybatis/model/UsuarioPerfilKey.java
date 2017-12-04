package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class UsuarioPerfilKey implements Serializable {
    private Integer id_usuario;

    private Integer id_perfil;

    private static final long serialVersionUID = 1L;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", id_perfil=").append(id_perfil);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}