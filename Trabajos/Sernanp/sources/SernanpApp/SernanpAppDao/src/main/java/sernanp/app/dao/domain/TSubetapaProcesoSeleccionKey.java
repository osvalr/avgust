package sernanp.app.dao.domain;

import java.io.Serializable;

public class TSubetapaProcesoSeleccionKey implements Serializable {
    private Integer srl_id_subetapa_proceso_seleccion;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_subetapa_proceso_seleccion() {
        return srl_id_subetapa_proceso_seleccion;
    }

    public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) {
        this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_subetapa_proceso_seleccion=").append(srl_id_subetapa_proceso_seleccion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}