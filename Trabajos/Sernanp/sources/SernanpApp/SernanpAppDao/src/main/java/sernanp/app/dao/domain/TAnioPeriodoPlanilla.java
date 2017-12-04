package sernanp.app.dao.domain;

import java.util.Date;

public class TAnioPeriodoPlanilla extends TAnioPeriodoPlanillaKey {
    private Integer srl_id_anio_planilla;

    private Integer int_id_periodo_mes;

    private Date dte_fecha_inicio_periodo;

    private Date dte_fecha_fin_periodo;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public Integer getInt_id_periodo_mes() {
        return int_id_periodo_mes;
    }

    public void setInt_id_periodo_mes(Integer int_id_periodo_mes) {
        this.int_id_periodo_mes = int_id_periodo_mes;
    }

    public Date getDte_fecha_inicio_periodo() {
        return dte_fecha_inicio_periodo;
    }

    public void setDte_fecha_inicio_periodo(Date dte_fecha_inicio_periodo) {
        this.dte_fecha_inicio_periodo = dte_fecha_inicio_periodo;
    }

    public Date getDte_fecha_fin_periodo() {
        return dte_fecha_fin_periodo;
    }

    public void setDte_fecha_fin_periodo(Date dte_fecha_fin_periodo) {
        this.dte_fecha_fin_periodo = dte_fecha_fin_periodo;
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
}