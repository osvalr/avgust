package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TMetaPresupuestaria extends TMetaPresupuestariaKey implements Serializable {
    private String var_cod_meta_presupuestaria;

    private String var_descripcion;

    private Integer int_id_unidad_medida;

    private String var_per_meta_presupuestaria;

    private Integer int_cantidad_anual;

    private Integer int_cantidad_semestral;

    private Integer idubigeo;

    private String chr_tipo;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public String getVar_cod_meta_presupuestaria() {
        return var_cod_meta_presupuestaria;
    }

    public void setVar_cod_meta_presupuestaria(String var_cod_meta_presupuestaria) {
        this.var_cod_meta_presupuestaria = var_cod_meta_presupuestaria;
    }

    public String getVar_descripcion() {
        return var_descripcion;
    }

    public void setVar_descripcion(String var_descripcion) {
        this.var_descripcion = var_descripcion;
    }

    public Integer getInt_id_unidad_medida() {
        return int_id_unidad_medida;
    }

    public void setInt_id_unidad_medida(Integer int_id_unidad_medida) {
        this.int_id_unidad_medida = int_id_unidad_medida;
    }

    public String getVar_per_meta_presupuestaria() {
        return var_per_meta_presupuestaria;
    }

    public void setVar_per_meta_presupuestaria(String var_per_meta_presupuestaria) {
        this.var_per_meta_presupuestaria = var_per_meta_presupuestaria;
    }

    public Integer getInt_cantidad_anual() {
        return int_cantidad_anual;
    }

    public void setInt_cantidad_anual(Integer int_cantidad_anual) {
        this.int_cantidad_anual = int_cantidad_anual;
    }

    public Integer getInt_cantidad_semestral() {
        return int_cantidad_semestral;
    }

    public void setInt_cantidad_semestral(Integer int_cantidad_semestral) {
        this.int_cantidad_semestral = int_cantidad_semestral;
    }

    public Integer getIdubigeo() {
        return idubigeo;
    }

    public void setIdubigeo(Integer idubigeo) {
        this.idubigeo = idubigeo;
    }

    public String getChr_tipo() {
        return chr_tipo;
    }

    public void setChr_tipo(String chr_tipo) {
        this.chr_tipo = chr_tipo;
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
        sb.append(", var_cod_meta_presupuestaria=").append(var_cod_meta_presupuestaria);
        sb.append(", var_descripcion=").append(var_descripcion);
        sb.append(", int_id_unidad_medida=").append(int_id_unidad_medida);
        sb.append(", var_per_meta_presupuestaria=").append(var_per_meta_presupuestaria);
        sb.append(", int_cantidad_anual=").append(int_cantidad_anual);
        sb.append(", int_cantidad_semestral=").append(int_cantidad_semestral);
        sb.append(", idubigeo=").append(idubigeo);
        sb.append(", chr_tipo=").append(chr_tipo);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}