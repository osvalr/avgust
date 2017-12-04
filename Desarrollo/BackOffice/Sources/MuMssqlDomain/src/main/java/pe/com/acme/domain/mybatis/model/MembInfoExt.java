package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class MembInfoExt extends MembInfoExtKey implements Serializable {
    private String nombres;

    private String ape_pater;

    private String ape_mater;

    private Date fecha_nacimiento;

    private Date fecha_registro;

    private static final long serialVersionUID = 1L;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_pater() {
        return ape_pater;
    }

    public void setApe_pater(String ape_pater) {
        this.ape_pater = ape_pater;
    }

    public String getApe_mater() {
        return ape_mater;
    }

    public void setApe_mater(String ape_mater) {
        this.ape_mater = ape_mater;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
        sb.append(", nombres=").append(nombres);
        sb.append(", ape_pater=").append(ape_pater);
        sb.append(", ape_mater=").append(ape_mater);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}