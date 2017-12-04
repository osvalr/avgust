package sernanp.app.dao.domain;

import java.io.Serializable;

public class TGenericaGastoKey implements Serializable {
    private Integer srl_id_generica_gasto;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_generica_gasto() {
        return srl_id_generica_gasto;
    }

    public void setSrl_id_generica_gasto(Integer srl_id_generica_gasto) {
        this.srl_id_generica_gasto = srl_id_generica_gasto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_generica_gasto=").append(srl_id_generica_gasto);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}