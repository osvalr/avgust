package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class CuentaAmortizacionKey implements Serializable {
    private Integer id_cuenta_amortizacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_cuenta_amortizacion() {
        return id_cuenta_amortizacion;
    }

    public void setId_cuenta_amortizacion(Integer id_cuenta_amortizacion) {
        this.id_cuenta_amortizacion = id_cuenta_amortizacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_cuenta_amortizacion=").append(id_cuenta_amortizacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}