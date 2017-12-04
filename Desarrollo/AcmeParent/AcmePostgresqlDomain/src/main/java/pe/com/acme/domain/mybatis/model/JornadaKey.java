package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class JornadaKey implements Serializable {
    private Integer num_dia;

    private Integer num_mes;

    private Integer num_anio;

    private static final long serialVersionUID = 1L;

    public Integer getNum_dia() {
        return num_dia;
    }

    public void setNum_dia(Integer num_dia) {
        this.num_dia = num_dia;
    }

    public Integer getNum_mes() {
        return num_mes;
    }

    public void setNum_mes(Integer num_mes) {
        this.num_mes = num_mes;
    }

    public Integer getNum_anio() {
        return num_anio;
    }

    public void setNum_anio(Integer num_anio) {
        this.num_anio = num_anio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", num_dia=").append(num_dia);
        sb.append(", num_mes=").append(num_mes);
        sb.append(", num_anio=").append(num_anio);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}