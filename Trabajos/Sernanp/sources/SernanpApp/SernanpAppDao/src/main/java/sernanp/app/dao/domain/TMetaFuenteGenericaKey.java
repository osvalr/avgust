package sernanp.app.dao.domain;

import java.io.Serializable;

public class TMetaFuenteGenericaKey implements Serializable {
    private Integer srl_id_meta_fuente_generica;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_meta_fuente_generica() {
        return srl_id_meta_fuente_generica;
    }

    public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) {
        this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_meta_fuente_generica=").append(srl_id_meta_fuente_generica);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}