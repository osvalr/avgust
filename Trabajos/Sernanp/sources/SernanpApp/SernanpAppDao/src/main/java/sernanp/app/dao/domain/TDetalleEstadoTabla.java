package sernanp.app.dao.domain;

import java.util.Date;

public class TDetalleEstadoTabla extends TDetalleEstadoTablaKey {
    private Integer srl_id_estado_tabla;

    private String var_cod_estado;

    private String var_nombre_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_estado_tabla() {
        return srl_id_estado_tabla;
    }

    public void setSrl_id_estado_tabla(Integer srl_id_estado_tabla) {
        this.srl_id_estado_tabla = srl_id_estado_tabla;
    }

    public String getVar_cod_estado() {
        return var_cod_estado;
    }

    public void setVar_cod_estado(String var_cod_estado) {
        this.var_cod_estado = var_cod_estado;
    }

    public String getVar_nombre_estado() {
        return var_nombre_estado;
    }

    public void setVar_nombre_estado(String var_nombre_estado) {
        this.var_nombre_estado = var_nombre_estado;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}