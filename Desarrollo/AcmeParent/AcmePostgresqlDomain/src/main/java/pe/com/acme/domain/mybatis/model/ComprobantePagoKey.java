package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class ComprobantePagoKey implements Serializable {
    private Integer id_comprobante_pago;

    private static final long serialVersionUID = 1L;

    public Integer getId_comprobante_pago() {
        return id_comprobante_pago;
    }

    public void setId_comprobante_pago(Integer id_comprobante_pago) {
        this.id_comprobante_pago = id_comprobante_pago;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_comprobante_pago=").append(id_comprobante_pago);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}