package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TFuenteFinanciamiento extends TFuenteFinanciamientoKey implements Serializable {
    private Integer int_cod_fuente_financiamiento;

    private String var_descripcion_fuente_financiamiento;

    private String var_sigla;

    private Integer int_id_tipo_fuente_financiamiento;

    private String var_coordinador;

    private String var_email;

    private Integer int_id_estado;

    private Integer int_id_auditoria;

    private String var_rubro_fte_fto;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getInt_cod_fuente_financiamiento() {
        return int_cod_fuente_financiamiento;
    }

    public void setInt_cod_fuente_financiamiento(Integer int_cod_fuente_financiamiento) {
        this.int_cod_fuente_financiamiento = int_cod_fuente_financiamiento;
    }

    public String getVar_descripcion_fuente_financiamiento() {
        return var_descripcion_fuente_financiamiento;
    }

    public void setVar_descripcion_fuente_financiamiento(String var_descripcion_fuente_financiamiento) {
        this.var_descripcion_fuente_financiamiento = var_descripcion_fuente_financiamiento;
    }

    public String getVar_sigla() {
        return var_sigla;
    }

    public void setVar_sigla(String var_sigla) {
        this.var_sigla = var_sigla;
    }

    public Integer getInt_id_tipo_fuente_financiamiento() {
        return int_id_tipo_fuente_financiamiento;
    }

    public void setInt_id_tipo_fuente_financiamiento(Integer int_id_tipo_fuente_financiamiento) {
        this.int_id_tipo_fuente_financiamiento = int_id_tipo_fuente_financiamiento;
    }

    public String getVar_coordinador() {
        return var_coordinador;
    }

    public void setVar_coordinador(String var_coordinador) {
        this.var_coordinador = var_coordinador;
    }

    public String getVar_email() {
        return var_email;
    }

    public void setVar_email(String var_email) {
        this.var_email = var_email;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Integer getInt_id_auditoria() {
        return int_id_auditoria;
    }

    public void setInt_id_auditoria(Integer int_id_auditoria) {
        this.int_id_auditoria = int_id_auditoria;
    }

    public String getVar_rubro_fte_fto() {
        return var_rubro_fte_fto;
    }

    public void setVar_rubro_fte_fto(String var_rubro_fte_fto) {
        this.var_rubro_fte_fto = var_rubro_fte_fto;
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
        sb.append(", int_cod_fuente_financiamiento=").append(int_cod_fuente_financiamiento);
        sb.append(", var_descripcion_fuente_financiamiento=").append(var_descripcion_fuente_financiamiento);
        sb.append(", var_sigla=").append(var_sigla);
        sb.append(", int_id_tipo_fuente_financiamiento=").append(int_id_tipo_fuente_financiamiento);
        sb.append(", var_coordinador=").append(var_coordinador);
        sb.append(", var_email=").append(var_email);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", int_id_auditoria=").append(int_id_auditoria);
        sb.append(", var_rubro_fte_fto=").append(var_rubro_fte_fto);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}