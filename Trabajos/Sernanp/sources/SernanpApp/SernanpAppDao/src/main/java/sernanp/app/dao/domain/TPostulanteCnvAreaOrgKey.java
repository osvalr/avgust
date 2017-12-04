package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPostulanteCnvAreaOrgKey implements Serializable {
    private Integer srl_id_postulante_conv_area_org;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_postulante_conv_area_org() {
        return srl_id_postulante_conv_area_org;
    }

    public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) {
        this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_postulante_conv_area_org=").append(srl_id_postulante_conv_area_org);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}