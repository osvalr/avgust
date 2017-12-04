package sernanp.app.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPersonalVacaciones extends TPersonalVacacionesKey implements Serializable {
    private Integer int_periodo_vac;

    private Date dte_fec_inicio_programacion_vac;

    private Integer int_est_vacaciones;

    private Date tsp_fec_sys_crea;

    private Date tsp_fec_sys_mod;

    private Integer idpersonal;

    private Integer int_dias_vac_corresponde;

    private Integer int_dias_vac_goce;

    private BigDecimal int_dias_vac_truncas;

    private static final long serialVersionUID = 1L;

    public Integer getInt_periodo_vac() {
        return int_periodo_vac;
    }

    public void setInt_periodo_vac(Integer int_periodo_vac) {
        this.int_periodo_vac = int_periodo_vac;
    }

    public Date getDte_fec_inicio_programacion_vac() {
        return dte_fec_inicio_programacion_vac;
    }

    public void setDte_fec_inicio_programacion_vac(Date dte_fec_inicio_programacion_vac) {
        this.dte_fec_inicio_programacion_vac = dte_fec_inicio_programacion_vac;
    }

    public Integer getInt_est_vacaciones() {
        return int_est_vacaciones;
    }

    public void setInt_est_vacaciones(Integer int_est_vacaciones) {
        this.int_est_vacaciones = int_est_vacaciones;
    }

    public Date getTsp_fec_sys_crea() {
        return tsp_fec_sys_crea;
    }

    public void setTsp_fec_sys_crea(Date tsp_fec_sys_crea) {
        this.tsp_fec_sys_crea = tsp_fec_sys_crea;
    }

    public Date getTsp_fec_sys_mod() {
        return tsp_fec_sys_mod;
    }

    public void setTsp_fec_sys_mod(Date tsp_fec_sys_mod) {
        this.tsp_fec_sys_mod = tsp_fec_sys_mod;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getInt_dias_vac_corresponde() {
        return int_dias_vac_corresponde;
    }

    public void setInt_dias_vac_corresponde(Integer int_dias_vac_corresponde) {
        this.int_dias_vac_corresponde = int_dias_vac_corresponde;
    }

    public Integer getInt_dias_vac_goce() {
        return int_dias_vac_goce;
    }

    public void setInt_dias_vac_goce(Integer int_dias_vac_goce) {
        this.int_dias_vac_goce = int_dias_vac_goce;
    }

    public BigDecimal getInt_dias_vac_truncas() {
        return int_dias_vac_truncas;
    }

    public void setInt_dias_vac_truncas(BigDecimal int_dias_vac_truncas) {
        this.int_dias_vac_truncas = int_dias_vac_truncas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", int_periodo_vac=").append(int_periodo_vac);
        sb.append(", dte_fec_inicio_programacion_vac=").append(dte_fec_inicio_programacion_vac);
        sb.append(", int_est_vacaciones=").append(int_est_vacaciones);
        sb.append(", tsp_fec_sys_crea=").append(tsp_fec_sys_crea);
        sb.append(", tsp_fec_sys_mod=").append(tsp_fec_sys_mod);
        sb.append(", idpersonal=").append(idpersonal);
        sb.append(", int_dias_vac_corresponde=").append(int_dias_vac_corresponde);
        sb.append(", int_dias_vac_goce=").append(int_dias_vac_goce);
        sb.append(", int_dias_vac_truncas=").append(int_dias_vac_truncas);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}