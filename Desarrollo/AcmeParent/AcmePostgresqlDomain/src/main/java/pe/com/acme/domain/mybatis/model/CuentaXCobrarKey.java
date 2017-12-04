package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class CuentaXCobrarKey implements Serializable {
    private Integer id_cuenta_x_cobrar;

    private static final long serialVersionUID = 1L;

    public Integer getId_cuenta_x_cobrar() {
        return id_cuenta_x_cobrar;
    }

    public void setId_cuenta_x_cobrar(Integer id_cuenta_x_cobrar) {
        this.id_cuenta_x_cobrar = id_cuenta_x_cobrar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_cuenta_x_cobrar=").append(id_cuenta_x_cobrar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}