package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPersonalDescuentoTmpKey implements Serializable {
    private Integer srl_id_pers_desc_tmp;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_pers_desc_tmp() {
        return srl_id_pers_desc_tmp;
    }

    public void setSrl_id_pers_desc_tmp(Integer srl_id_pers_desc_tmp) {
        this.srl_id_pers_desc_tmp = srl_id_pers_desc_tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_pers_desc_tmp=").append(srl_id_pers_desc_tmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}