package sernanp.app.dao.domain;

import java.io.Serializable;

public class TConceptoFrecuenciaKey implements Serializable {
    private Integer srl_id_frecuencia;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_frecuencia() {
        return srl_id_frecuencia;
    }

    public void setSrl_id_frecuencia(Integer srl_id_frecuencia) {
        this.srl_id_frecuencia = srl_id_frecuencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_frecuencia=").append(srl_id_frecuencia);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}