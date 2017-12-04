package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class MembInfoReferidoKey implements Serializable {
    private Integer id_referido;

    private static final long serialVersionUID = 1L;

    public Integer getId_referido() {
        return id_referido;
    }

    public void setId_referido(Integer id_referido) {
        this.id_referido = id_referido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_referido=").append(id_referido);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}