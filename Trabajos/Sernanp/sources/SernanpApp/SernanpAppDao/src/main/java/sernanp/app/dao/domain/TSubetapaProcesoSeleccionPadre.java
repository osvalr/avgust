package sernanp.app.dao.domain;

import java.util.Date;

public class TSubetapaProcesoSeleccionPadre extends TSubetapaProcesoSeleccionPadreKey {
    private Integer srl_id_subetapa_proceso_seleccion;

    private Integer srl_id_subetapa_padre;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_subetapa_proceso_seleccion() {
        return srl_id_subetapa_proceso_seleccion;
    }

    public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) {
        this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
    }

    public Integer getSrl_id_subetapa_padre() {
        return srl_id_subetapa_padre;
    }

    public void setSrl_id_subetapa_padre(Integer srl_id_subetapa_padre) {
        this.srl_id_subetapa_padre = srl_id_subetapa_padre;
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