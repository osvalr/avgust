package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TPersonalMetaFteFto implements Serializable {
    private Integer srl_id_anio_planilla;

    private Integer idpersonal;

    private String c_meta;

    private String c_fte_fto;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private Integer idpersonanatural;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getC_meta() {
        return c_meta;
    }

    public void setC_meta(String c_meta) {
        this.c_meta = c_meta;
    }

    public String getC_fte_fto() {
        return c_fte_fto;
    }

    public void setC_fte_fto(String c_fte_fto) {
        this.c_fte_fto = c_fte_fto;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_anio_planilla=").append(srl_id_anio_planilla);
        sb.append(", idpersonal=").append(idpersonal);
        sb.append(", c_meta=").append(c_meta);
        sb.append(", c_fte_fto=").append(c_fte_fto);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", idpersonanatural=").append(idpersonanatural);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}