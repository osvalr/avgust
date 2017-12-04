package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPersonalVacacionesKey implements Serializable {
    private Integer srl_id_pers_vac;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_pers_vac() {
        return srl_id_pers_vac;
    }

    public void setSrl_id_pers_vac(Integer srl_id_pers_vac) {
        this.srl_id_pers_vac = srl_id_pers_vac;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_pers_vac=").append(srl_id_pers_vac);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}