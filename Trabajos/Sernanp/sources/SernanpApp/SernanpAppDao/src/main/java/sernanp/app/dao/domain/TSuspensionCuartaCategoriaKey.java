package sernanp.app.dao.domain;

import java.io.Serializable;

public class TSuspensionCuartaCategoriaKey implements Serializable {
    private Integer srl_id_suspension_cuarta_categoria;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_suspension_cuarta_categoria() {
        return srl_id_suspension_cuarta_categoria;
    }

    public void setSrl_id_suspension_cuarta_categoria(Integer srl_id_suspension_cuarta_categoria) {
        this.srl_id_suspension_cuarta_categoria = srl_id_suspension_cuarta_categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_suspension_cuarta_categoria=").append(srl_id_suspension_cuarta_categoria);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}