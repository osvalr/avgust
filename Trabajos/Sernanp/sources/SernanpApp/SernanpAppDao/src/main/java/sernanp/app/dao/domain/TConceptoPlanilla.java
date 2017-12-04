package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TConceptoPlanilla extends TConceptoPlanillaKey {
    private String var_cod_concepto;

    private String var_descrip_concepto;

    private String var_descrip_corto_concepto;

    private String var_cod_pdt_concepto;

    private String var_cod_mef_concepto;

    private String var_cod_siaf_concepto;

    private Integer int_id_tipo_concepto;

    private Integer int_id_sub_tipo_concepto;

    private Integer int_requiere_frecuencia_concepto;

    private BigDecimal dec_monto_concepto;

    private Integer int_id_tipo_monto_concepto;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;
    
    private static final long serialVersionUID = 1L;

    public String getVar_cod_concepto() {
        return var_cod_concepto;
    }

    public void setVar_cod_concepto(String var_cod_concepto) {
        this.var_cod_concepto = var_cod_concepto;
    }

    public String getVar_descrip_concepto() {
        return var_descrip_concepto;
    }

    public void setVar_descrip_concepto(String var_descrip_concepto) {
        this.var_descrip_concepto = var_descrip_concepto;
    }

    public String getVar_descrip_corto_concepto() {
        return var_descrip_corto_concepto;
    }

    public void setVar_descrip_corto_concepto(String var_descrip_corto_concepto) {
        this.var_descrip_corto_concepto = var_descrip_corto_concepto;
    }

    public String getVar_cod_pdt_concepto() {
        return var_cod_pdt_concepto;
    }

    public void setVar_cod_pdt_concepto(String var_cod_pdt_concepto) {
        this.var_cod_pdt_concepto = var_cod_pdt_concepto;
    }

    public String getVar_cod_mef_concepto() {
        return var_cod_mef_concepto;
    }

    public void setVar_cod_mef_concepto(String var_cod_mef_concepto) {
        this.var_cod_mef_concepto = var_cod_mef_concepto;
    }

    public String getVar_cod_siaf_concepto() {
        return var_cod_siaf_concepto;
    }

    public void setVar_cod_siaf_concepto(String var_cod_siaf_concepto) {
        this.var_cod_siaf_concepto = var_cod_siaf_concepto;
    }

    public Integer getInt_id_tipo_concepto() {
        return int_id_tipo_concepto;
    }

    public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) {
        this.int_id_tipo_concepto = int_id_tipo_concepto;
    }

    public Integer getInt_id_sub_tipo_concepto() {
        return int_id_sub_tipo_concepto;
    }

    public void setInt_id_sub_tipo_concepto(Integer int_id_sub_tipo_concepto) {
        this.int_id_sub_tipo_concepto = int_id_sub_tipo_concepto;
    }

    public Integer getInt_requiere_frecuencia_concepto() {
        return int_requiere_frecuencia_concepto;
    }

    public void setInt_requiere_frecuencia_concepto(Integer int_requiere_frecuencia_concepto) {
        this.int_requiere_frecuencia_concepto = int_requiere_frecuencia_concepto;
    }

    public BigDecimal getDec_monto_concepto() {
        return dec_monto_concepto;
    }

    public void setDec_monto_concepto(BigDecimal dec_monto_concepto) {
        this.dec_monto_concepto = dec_monto_concepto;
    }

    public Integer getInt_id_tipo_monto_concepto() {
        return int_id_tipo_monto_concepto;
    }

    public void setInt_id_tipo_monto_concepto(Integer int_id_tipo_monto_concepto) {
        this.int_id_tipo_monto_concepto = int_id_tipo_monto_concepto;
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
        sb.append(", var_cod_concepto=").append(var_cod_concepto);
        sb.append(", var_descrip_concepto=").append(var_descrip_concepto);
        sb.append(", var_descrip_corto_concepto=").append(var_descrip_corto_concepto);
        sb.append(", var_cod_pdt_concepto=").append(var_cod_pdt_concepto);
        sb.append(", var_cod_mef_concepto=").append(var_cod_mef_concepto);
        sb.append(", var_cod_siaf_concepto=").append(var_cod_siaf_concepto);
        sb.append(", int_id_tipo_concepto=").append(int_id_tipo_concepto);
        sb.append(", int_requiere_frecuencia_concepto=").append(int_requiere_frecuencia_concepto);
        sb.append(", dec_monto_concepto=").append(dec_monto_concepto);
        sb.append(", int_id_tipo_monto_concepto=").append(int_id_tipo_monto_concepto);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", int_id_sub_tipo_concepto=").append(int_id_sub_tipo_concepto);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}