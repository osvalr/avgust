package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class SerieNumeroDocKey implements Serializable {
    private Integer id_serie_numero_doc;

    private static final long serialVersionUID = 1L;

    public Integer getId_serie_numero_doc() {
        return id_serie_numero_doc;
    }

    public void setId_serie_numero_doc(Integer id_serie_numero_doc) {
        this.id_serie_numero_doc = id_serie_numero_doc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_serie_numero_doc=").append(id_serie_numero_doc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}