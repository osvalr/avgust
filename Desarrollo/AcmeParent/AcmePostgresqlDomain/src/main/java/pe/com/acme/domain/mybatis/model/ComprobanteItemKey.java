package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class ComprobanteItemKey implements Serializable {
    private Integer id_comprobante_item;

    private static final long serialVersionUID = 1L;

    public Integer getId_comprobante_item() {
        return id_comprobante_item;
    }

    public void setId_comprobante_item(Integer id_comprobante_item) {
        this.id_comprobante_item = id_comprobante_item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_comprobante_item=").append(id_comprobante_item);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}