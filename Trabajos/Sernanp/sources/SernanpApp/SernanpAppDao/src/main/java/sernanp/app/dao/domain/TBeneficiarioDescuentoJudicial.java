package sernanp.app.dao.domain;

import java.util.Date;

public class TBeneficiarioDescuentoJudicial extends TBeneficiarioDescuentoJudicialKey {
    private Integer idpersonal;

    private String var_descripcion_descuento;

    private Integer int_id_tipo_documento;

    private String var_numero_doc;

    private String var_nombres;

    private String var_ape_pater;

    private String var_ape_mater;

    private String var_numero_cuenta;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;
    
    private static final long serialVersionUID = 1L;

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getVar_descripcion_descuento() {
        return var_descripcion_descuento;
    }

    public void setVar_descripcion_descuento(String var_descripcion_descuento) {
        this.var_descripcion_descuento = var_descripcion_descuento;
    }

    public Integer getInt_id_tipo_documento() {
        return int_id_tipo_documento;
    }

    public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
        this.int_id_tipo_documento = int_id_tipo_documento;
    }

    public String getVar_numero_doc() {
        return var_numero_doc;
    }

    public void setVar_numero_doc(String var_numero_doc) {
        this.var_numero_doc = var_numero_doc;
    }

    public String getVar_nombres() {
        return var_nombres;
    }

    public void setVar_nombres(String var_nombres) {
        this.var_nombres = var_nombres;
    }

    public String getVar_ape_pater() {
        return var_ape_pater;
    }

    public void setVar_ape_pater(String var_ape_pater) {
        this.var_ape_pater = var_ape_pater;
    }

    public String getVar_ape_mater() {
        return var_ape_mater;
    }

    public void setVar_ape_mater(String var_ape_mater) {
        this.var_ape_mater = var_ape_mater;
    }

    public String getVar_numero_cuenta() {
        return var_numero_cuenta;
    }

    public void setVar_numero_cuenta(String var_numero_cuenta) {
        this.var_numero_cuenta = var_numero_cuenta;
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
        sb.append(", idpersonal=").append(idpersonal);
        sb.append(", var_descripcion_descuento=").append(var_descripcion_descuento);
        sb.append(", int_id_tipo_documento=").append(int_id_tipo_documento);
        sb.append(", var_numero_doc=").append(var_numero_doc);
        sb.append(", var_nombres=").append(var_nombres);
        sb.append(", var_ape_pater=").append(var_ape_pater);
        sb.append(", var_ape_mater=").append(var_ape_mater);
        sb.append(", var_numero_cuenta=").append(var_numero_cuenta);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    
}