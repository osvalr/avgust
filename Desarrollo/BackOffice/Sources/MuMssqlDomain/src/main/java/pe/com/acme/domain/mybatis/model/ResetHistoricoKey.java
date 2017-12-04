package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class ResetHistoricoKey implements Serializable {
    private Integer id_reset_historico;

    private static final long serialVersionUID = 1L;

    public Integer getId_reset_historico() {
        return id_reset_historico;
    }

    public void setId_reset_historico(Integer id_reset_historico) {
        this.id_reset_historico = id_reset_historico;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_reset_historico=").append(id_reset_historico);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}