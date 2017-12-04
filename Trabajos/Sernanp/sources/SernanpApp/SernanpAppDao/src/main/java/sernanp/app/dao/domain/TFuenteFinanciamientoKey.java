package sernanp.app.dao.domain;

import java.io.Serializable;

public class TFuenteFinanciamientoKey implements Serializable {
    private Integer srl_id_fuente_financiamiento;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_fuente_financiamiento() {
        return srl_id_fuente_financiamiento;
    }

    public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) {
        this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_fuente_financiamiento=").append(srl_id_fuente_financiamiento);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}