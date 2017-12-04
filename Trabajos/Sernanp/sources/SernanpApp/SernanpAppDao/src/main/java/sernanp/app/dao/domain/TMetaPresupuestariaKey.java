package sernanp.app.dao.domain;

import java.io.Serializable;

public class TMetaPresupuestariaKey implements Serializable {
    private Integer srl_id_meta_presupuestaria;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_meta_presupuestaria() {
        return srl_id_meta_presupuestaria;
    }

    public void setSrl_id_meta_presupuestaria(Integer srl_id_meta_presupuestaria) {
        this.srl_id_meta_presupuestaria = srl_id_meta_presupuestaria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_meta_presupuestaria=").append(srl_id_meta_presupuestaria);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}