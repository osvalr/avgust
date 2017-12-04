package sernanp.app.dao.domain;

import java.util.Date;

public class TAfectoConcepto extends TAfectoConceptoKey {
    private Integer srl_id_concepto_planilla;

    private Integer srl_id_concepto_planilla_afecto;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_concepto_planilla() {
        return srl_id_concepto_planilla;
    }

    public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
        this.srl_id_concepto_planilla = srl_id_concepto_planilla;
    }

    public Integer getSrl_id_concepto_planilla_afecto() {
        return srl_id_concepto_planilla_afecto;
    }

    public void setSrl_id_concepto_planilla_afecto(Integer srl_id_concepto_planilla_afecto) {
        this.srl_id_concepto_planilla_afecto = srl_id_concepto_planilla_afecto;
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