package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class GuiaSaldoKey implements Serializable {
    private Integer id_guia_saldo;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia_saldo() {
        return id_guia_saldo;
    }

    public void setId_guia_saldo(Integer id_guia_saldo) {
        this.id_guia_saldo = id_guia_saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia_saldo=").append(id_guia_saldo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}