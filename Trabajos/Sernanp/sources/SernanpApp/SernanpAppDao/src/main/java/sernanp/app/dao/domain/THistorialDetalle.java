package sernanp.app.dao.domain;

import java.util.Date;

public class THistorialDetalle extends THistorialDetalleKey {
    private String var_valor_json;

    private String var_id_responsable;

    private String var_id_tipo_operacion;

    private Date tsp_fecha_registro;

    public String getVar_valor_json() {
        return var_valor_json;
    }

    public void setVar_valor_json(String var_valor_json) {
        this.var_valor_json = var_valor_json;
    }

    public String getVar_id_responsable() {
        return var_id_responsable;
    }

    public void setVar_id_responsable(String var_id_responsable) {
        this.var_id_responsable = var_id_responsable;
    }

    public String getVar_id_tipo_operacion() {
        return var_id_tipo_operacion;
    }

    public void setVar_id_tipo_operacion(String var_id_tipo_operacion) {
        this.var_id_tipo_operacion = var_id_tipo_operacion;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}