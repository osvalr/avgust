package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPostulantePersonalArchivoKey implements Serializable {
    private Integer srl_id_archivo;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_archivo() {
        return srl_id_archivo;
    }

    public void setSrl_id_archivo(Integer srl_id_archivo) {
        this.srl_id_archivo = srl_id_archivo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_archivo=").append(srl_id_archivo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}