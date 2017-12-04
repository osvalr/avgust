package sernanp.app.dao.domain;

import java.util.Date;

public class TNumeroTelefono extends TNumeroTelefonoKey {
    private String var_cod_cuidad;

    private String var_numero_telefono;

    private Integer int_id_tipo_telefono;

    private Integer int_id_tipo_operador;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_cod_cuidad() {
        return var_cod_cuidad;
    }

    public void setVar_cod_cuidad(String var_cod_cuidad) {
        this.var_cod_cuidad = var_cod_cuidad;
    }

    public String getVar_numero_telefono() {
        return var_numero_telefono;
    }

    public void setVar_numero_telefono(String var_numero_telefono) {
        this.var_numero_telefono = var_numero_telefono;
    }

    public Integer getInt_id_tipo_telefono() {
        return int_id_tipo_telefono;
    }

    public void setInt_id_tipo_telefono(Integer int_id_tipo_telefono) {
        this.int_id_tipo_telefono = int_id_tipo_telefono;
    }

    public Integer getInt_id_tipo_operador() {
        return int_id_tipo_operador;
    }

    public void setInt_id_tipo_operador(Integer int_id_tipo_operador) {
        this.int_id_tipo_operador = int_id_tipo_operador;
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