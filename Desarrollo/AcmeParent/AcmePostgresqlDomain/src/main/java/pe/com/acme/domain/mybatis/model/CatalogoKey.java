package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class CatalogoKey implements Serializable {
    private Integer id_catalogo;

    private static final long serialVersionUID = 1L;

    public Integer getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(Integer id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_catalogo=").append(id_catalogo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}