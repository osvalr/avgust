package sernanp.app.dao.domain;

import java.io.Serializable;

public class TFactorEvaluacionKey implements Serializable {
    private Integer srl_id_factor_evaluacion;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_factor_evaluacion() {
        return srl_id_factor_evaluacion;
    }

    public void setSrl_id_factor_evaluacion(Integer srl_id_factor_evaluacion) {
        this.srl_id_factor_evaluacion = srl_id_factor_evaluacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_factor_evaluacion=").append(srl_id_factor_evaluacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}