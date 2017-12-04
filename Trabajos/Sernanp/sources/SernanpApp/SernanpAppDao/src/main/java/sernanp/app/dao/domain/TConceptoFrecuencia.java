package sernanp.app.dao.domain;

import java.io.Serializable;

public class TConceptoFrecuencia extends TConceptoFrecuenciaKey implements Serializable {
    private Integer srl_id_concepto_planilla;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_concepto_planilla() {
        return srl_id_concepto_planilla;
    }

    public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
        this.srl_id_concepto_planilla = srl_id_concepto_planilla;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_concepto_planilla=").append(srl_id_concepto_planilla);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}