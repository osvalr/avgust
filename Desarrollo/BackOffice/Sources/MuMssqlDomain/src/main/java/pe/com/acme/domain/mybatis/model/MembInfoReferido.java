package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class MembInfoReferido extends MembInfoReferidoKey implements Serializable {
    private String memb___id_referido;

    private String memb___id;

    private Date fecha_registro;

    private static final long serialVersionUID = 1L;

    public String getMemb___id_referido() {
        return memb___id_referido;
    }

    public void setMemb___id_referido(String memb___id_referido) {
        this.memb___id_referido = memb___id_referido;
    }

    public String getMemb___id() {
        return memb___id;
    }

    public void setMemb___id(String memb___id) {
        this.memb___id = memb___id;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memb___id_referido=").append(memb___id_referido);
        sb.append(", memb___id=").append(memb___id);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}