package sernanp.app.dao.domain;

import java.util.Date;

public class TUnidadMedidaMeta extends TUnidadMedidaMetaKey {
    private String var_descrip_unidad_medida_meta;

    private String var_ambito_unidad_medida_meta;

    private String var_estructura_unidad_medida_meta;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_descrip_unidad_medida_meta() {
        return var_descrip_unidad_medida_meta;
    }

    public void setVar_descrip_unidad_medida_meta(String var_descrip_unidad_medida_meta) {
        this.var_descrip_unidad_medida_meta = var_descrip_unidad_medida_meta;
    }

    public String getVar_ambito_unidad_medida_meta() {
        return var_ambito_unidad_medida_meta;
    }

    public void setVar_ambito_unidad_medida_meta(String var_ambito_unidad_medida_meta) {
        this.var_ambito_unidad_medida_meta = var_ambito_unidad_medida_meta;
    }

    public String getVar_estructura_unidad_medida_meta() {
        return var_estructura_unidad_medida_meta;
    }

    public void setVar_estructura_unidad_medida_meta(String var_estructura_unidad_medida_meta) {
        this.var_estructura_unidad_medida_meta = var_estructura_unidad_medida_meta;
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