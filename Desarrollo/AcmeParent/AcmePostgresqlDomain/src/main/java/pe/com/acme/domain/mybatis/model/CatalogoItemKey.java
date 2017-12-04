package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class CatalogoItemKey implements Serializable {
    private Integer id_catalogo_item;

    private static final long serialVersionUID = 1L;

    public Integer getId_catalogo_item() {
        return id_catalogo_item;
    }

    public void setId_catalogo_item(Integer id_catalogo_item) {
        this.id_catalogo_item = id_catalogo_item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_catalogo_item=").append(id_catalogo_item);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}