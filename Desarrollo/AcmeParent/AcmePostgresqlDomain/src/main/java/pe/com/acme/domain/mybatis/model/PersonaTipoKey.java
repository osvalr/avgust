package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class PersonaTipoKey implements Serializable {
    private Integer id_persona;

    private Integer id_tipo_persona;

    private Integer id_sub_tipo_persona;

    private static final long serialVersionUID = 1L;

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Integer getId_tipo_persona() {
        return id_tipo_persona;
    }

    public void setId_tipo_persona(Integer id_tipo_persona) {
        this.id_tipo_persona = id_tipo_persona;
    }

    public Integer getId_sub_tipo_persona() {
        return id_sub_tipo_persona;
    }

    public void setId_sub_tipo_persona(Integer id_sub_tipo_persona) {
        this.id_sub_tipo_persona = id_sub_tipo_persona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_persona=").append(id_persona);
        sb.append(", id_tipo_persona=").append(id_tipo_persona);
        sb.append(", id_sub_tipo_persona=").append(id_sub_tipo_persona);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}