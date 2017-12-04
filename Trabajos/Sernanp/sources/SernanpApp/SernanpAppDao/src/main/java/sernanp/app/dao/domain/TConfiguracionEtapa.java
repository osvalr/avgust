package sernanp.app.dao.domain;

import java.util.Date;

public class TConfiguracionEtapa extends TConfiguracionEtapaKey {
    private Integer srl_id_configuracion_evaluacion_personal;

    private Integer srl_id_subetapa_proceso_seleccion;

    private Integer int_orden;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_configuracion_evaluacion_personal() {
        return srl_id_configuracion_evaluacion_personal;
    }

    public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) {
        this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal;
    }

    public Integer getSrl_id_subetapa_proceso_seleccion() {
        return srl_id_subetapa_proceso_seleccion;
    }

    public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) {
        this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
    }

    public Integer getInt_orden() {
        return int_orden;
    }

    public void setInt_orden(Integer int_orden) {
        this.int_orden = int_orden;
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