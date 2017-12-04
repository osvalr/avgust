package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class LogInHistoricoKey implements Serializable {
    private Integer id_log_in_historico;

    private static final long serialVersionUID = 1L;

    public Integer getId_log_in_historico() {
        return id_log_in_historico;
    }

    public void setId_log_in_historico(Integer id_log_in_historico) {
        this.id_log_in_historico = id_log_in_historico;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_log_in_historico=").append(id_log_in_historico);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}