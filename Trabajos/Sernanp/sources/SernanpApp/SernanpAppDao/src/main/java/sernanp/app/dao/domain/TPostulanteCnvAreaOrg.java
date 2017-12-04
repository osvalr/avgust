package sernanp.app.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPostulanteCnvAreaOrg extends TPostulanteCnvAreaOrgKey implements Serializable {
    private Integer int_id_postulante;

    private Integer srl_id_conv_area_org;

    private Integer int_num_activacion;

    private Integer int_orden_merito;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private BigDecimal dec_puntaje_total;

    private Integer srl_id_archivo;

    private static final long serialVersionUID = 1L;

    public Integer getInt_id_postulante() {
        return int_id_postulante;
    }

    public void setInt_id_postulante(Integer int_id_postulante) {
        this.int_id_postulante = int_id_postulante;
    }

    public Integer getSrl_id_conv_area_org() {
        return srl_id_conv_area_org;
    }

    public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
        this.srl_id_conv_area_org = srl_id_conv_area_org;
    }

    public Integer getInt_num_activacion() {
        return int_num_activacion;
    }

    public void setInt_num_activacion(Integer int_num_activacion) {
        this.int_num_activacion = int_num_activacion;
    }

    public Integer getInt_orden_merito() {
        return int_orden_merito;
    }

    public void setInt_orden_merito(Integer int_orden_merito) {
        this.int_orden_merito = int_orden_merito;
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

    public BigDecimal getDec_puntaje_total() {
        return dec_puntaje_total;
    }

    public void setDec_puntaje_total(BigDecimal dec_puntaje_total) {
        this.dec_puntaje_total = dec_puntaje_total;
    }

    public Integer getSrl_id_archivo() {
        return srl_id_archivo;
    }

    public void setSrl_id_archivo(Integer srl_id_archivo) {
        this.srl_id_archivo = srl_id_archivo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", int_id_postulante=").append(int_id_postulante);
        sb.append(", srl_id_conv_area_org=").append(srl_id_conv_area_org);
        sb.append(", int_num_activacion=").append(int_num_activacion);
        sb.append(", int_orden_merito=").append(int_orden_merito);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", dec_puntaje_total=").append(dec_puntaje_total);
        sb.append(", srl_id_archivo=").append(srl_id_archivo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}