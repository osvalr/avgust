package sernanp.app.dao.domain;

import java.io.Serializable;

public class TConvAreaOrgFactorEvalKey implements Serializable {
    private Integer srl_conv_area_org_factor_eval;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_conv_area_org_factor_eval() {
        return srl_conv_area_org_factor_eval;
    }

    public void setSrl_conv_area_org_factor_eval(Integer srl_conv_area_org_factor_eval) {
        this.srl_conv_area_org_factor_eval = srl_conv_area_org_factor_eval;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_conv_area_org_factor_eval=").append(srl_conv_area_org_factor_eval);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}