package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TClasificador extends TClasificadorKey implements Serializable {
    private Integer srl_id_generica_gasto;

    private Integer int_tipo_transaccion;

    private Integer int_cod_generica_gasto;

    private Integer int_generica_nivel_i;

    private Integer int_generica_nivel_ii;

    private Integer int_especifica_nivel_i;

    private Integer int_especifica_nivel_ii;

    private String var_descrip_clasificador;

    private String var_detalle_clasificador;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_generica_gasto() {
        return srl_id_generica_gasto;
    }

    public void setSrl_id_generica_gasto(Integer srl_id_generica_gasto) {
        this.srl_id_generica_gasto = srl_id_generica_gasto;
    }

    public Integer getInt_tipo_transaccion() {
        return int_tipo_transaccion;
    }

    public void setInt_tipo_transaccion(Integer int_tipo_transaccion) {
        this.int_tipo_transaccion = int_tipo_transaccion;
    }

    public Integer getInt_cod_generica_gasto() {
        return int_cod_generica_gasto;
    }

    public void setInt_cod_generica_gasto(Integer int_cod_generica_gasto) {
        this.int_cod_generica_gasto = int_cod_generica_gasto;
    }

    public Integer getInt_generica_nivel_i() {
        return int_generica_nivel_i;
    }

    public void setInt_generica_nivel_i(Integer int_generica_nivel_i) {
        this.int_generica_nivel_i = int_generica_nivel_i;
    }

    public Integer getInt_generica_nivel_ii() {
        return int_generica_nivel_ii;
    }

    public void setInt_generica_nivel_ii(Integer int_generica_nivel_ii) {
        this.int_generica_nivel_ii = int_generica_nivel_ii;
    }

    public Integer getInt_especifica_nivel_i() {
        return int_especifica_nivel_i;
    }

    public void setInt_especifica_nivel_i(Integer int_especifica_nivel_i) {
        this.int_especifica_nivel_i = int_especifica_nivel_i;
    }

    public Integer getInt_especifica_nivel_ii() {
        return int_especifica_nivel_ii;
    }

    public void setInt_especifica_nivel_ii(Integer int_especifica_nivel_ii) {
        this.int_especifica_nivel_ii = int_especifica_nivel_ii;
    }

    public String getVar_descrip_clasificador() {
        return var_descrip_clasificador;
    }

    public void setVar_descrip_clasificador(String var_descrip_clasificador) {
        this.var_descrip_clasificador = var_descrip_clasificador;
    }

    public String getVar_detalle_clasificador() {
        return var_detalle_clasificador;
    }

    public void setVar_detalle_clasificador(String var_detalle_clasificador) {
        this.var_detalle_clasificador = var_detalle_clasificador;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_generica_gasto=").append(srl_id_generica_gasto);
        sb.append(", int_tipo_transaccion=").append(int_tipo_transaccion);
        sb.append(", int_cod_generica_gasto=").append(int_cod_generica_gasto);
        sb.append(", int_generica_nivel_i=").append(int_generica_nivel_i);
        sb.append(", int_generica_nivel_ii=").append(int_generica_nivel_ii);
        sb.append(", int_especifica_nivel_i=").append(int_especifica_nivel_i);
        sb.append(", int_especifica_nivel_ii=").append(int_especifica_nivel_ii);
        sb.append(", var_descrip_clasificador=").append(var_descrip_clasificador);
        sb.append(", var_detalle_clasificador=").append(var_detalle_clasificador);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}