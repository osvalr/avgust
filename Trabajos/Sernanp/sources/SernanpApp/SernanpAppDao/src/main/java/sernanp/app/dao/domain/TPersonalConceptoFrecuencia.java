package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPersonalConceptoFrecuencia extends TPersonalConceptoFrecuenciaKey implements Serializable {
    private Integer srl_id_personal_concepto;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_personal_concepto() {
        return srl_id_personal_concepto;
    }

    public void setSrl_id_personal_concepto(Integer srl_id_personal_concepto) {
        this.srl_id_personal_concepto = srl_id_personal_concepto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_personal_concepto=").append(srl_id_personal_concepto);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}