package sernanp.app.dao.domain;

import java.util.Date;

public class TConvFechaEtapaConfig extends TConvFechaEtapaConfigKey {
    private Integer srl_id_convocatoria;

    private Integer srl_id_subetapa_proceso_seleccion;

    private Date dte_fecha_inicio;

    private Date dte_fecha_termino;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_convocatoria() {
        return srl_id_convocatoria;
    }

    public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
        this.srl_id_convocatoria = srl_id_convocatoria;
    }

    public Integer getSrl_id_subetapa_proceso_seleccion() {
        return srl_id_subetapa_proceso_seleccion;
    }

    public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) {
        this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
    }

    public Date getDte_fecha_inicio() {
        return dte_fecha_inicio;
    }

    public void setDte_fecha_inicio(Date dte_fecha_inicio) {
        this.dte_fecha_inicio = dte_fecha_inicio;
    }

    public Date getDte_fecha_termino() {
        return dte_fecha_termino;
    }

    public void setDte_fecha_termino(Date dte_fecha_termino) {
        this.dte_fecha_termino = dte_fecha_termino;
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