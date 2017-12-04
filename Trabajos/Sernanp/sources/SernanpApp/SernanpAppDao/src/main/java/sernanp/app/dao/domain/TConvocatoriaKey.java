package sernanp.app.dao.domain;

import java.io.Serializable;

public class TConvocatoriaKey implements Serializable {
    private Integer srl_id_convocatoria;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_convocatoria() {
        return srl_id_convocatoria;
    }

    public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
        this.srl_id_convocatoria = srl_id_convocatoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_convocatoria=").append(srl_id_convocatoria);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}