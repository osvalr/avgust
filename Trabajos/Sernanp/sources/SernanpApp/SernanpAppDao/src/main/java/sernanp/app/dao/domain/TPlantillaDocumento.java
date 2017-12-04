package sernanp.app.dao.domain;

import java.util.Date;

public class TPlantillaDocumento extends TPlantillaDocumentoKey {
    private String var_nombre_plantilla;

    private Date tsp_fecha_registro;

    public String getVar_nombre_plantilla() {
        return var_nombre_plantilla;
    }

    public void setVar_nombre_plantilla(String var_nombre_plantilla) {
        this.var_nombre_plantilla = var_nombre_plantilla;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}