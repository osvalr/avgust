package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TGenericaGasto extends TGenericaGastoKey implements Serializable {
    private Integer int_cod_generica_gasto;

    private String var_descrip_generica_gasto;

    private String var_detalle_generica_gasto;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getInt_cod_generica_gasto() {
        return int_cod_generica_gasto;
    }

    public void setInt_cod_generica_gasto(Integer int_cod_generica_gasto) {
        this.int_cod_generica_gasto = int_cod_generica_gasto;
    }

    public String getVar_descrip_generica_gasto() {
        return var_descrip_generica_gasto;
    }

    public void setVar_descrip_generica_gasto(String var_descrip_generica_gasto) {
        this.var_descrip_generica_gasto = var_descrip_generica_gasto;
    }

    public String getVar_detalle_generica_gasto() {
        return var_detalle_generica_gasto;
    }

    public void setVar_detalle_generica_gasto(String var_detalle_generica_gasto) {
        this.var_detalle_generica_gasto = var_detalle_generica_gasto;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", int_cod_generica_gasto=").append(int_cod_generica_gasto);
        sb.append(", var_descrip_generica_gasto=").append(var_descrip_generica_gasto);
        sb.append(", var_detalle_generica_gasto=").append(var_detalle_generica_gasto);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}