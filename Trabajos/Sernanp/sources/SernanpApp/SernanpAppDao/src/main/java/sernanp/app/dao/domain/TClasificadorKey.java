package sernanp.app.dao.domain;

import java.io.Serializable;

public class TClasificadorKey implements Serializable {
    private Integer srl_id_clasificador;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_clasificador() {
        return srl_id_clasificador;
    }

    public void setSrl_id_clasificador(Integer srl_id_clasificador) {
        this.srl_id_clasificador = srl_id_clasificador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_clasificador=").append(srl_id_clasificador);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}