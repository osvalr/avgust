package sernanp.app.dao.domain;

import java.util.Date;

public class TEstadoTabla extends TEstadoTablaKey {
    private String var_nombre_tabla;

    private Date tsp_fecha_registro;

    public String getVar_nombre_tabla() {
        return var_nombre_tabla;
    }

    public void setVar_nombre_tabla(String var_nombre_tabla) {
        this.var_nombre_tabla = var_nombre_tabla;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}