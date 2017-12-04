package sernanp.app.dao.domain;

import java.util.Date;

public class TPersonaNaturalLegajo extends TPersonaNaturalLegajoKey {
    private Integer idpersonanatural;

    private Integer int_id_tipo_documento;

    private String var_nombre_documento;

    private Date tsp_fecha_registro;

    private String var_asunto_documento;

    private String var_descripcion_documento;

    private Integer int_id_estado;

    private Integer srl_id_contrato;

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public Integer getInt_id_tipo_documento() {
        return int_id_tipo_documento;
    }

    public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
        this.int_id_tipo_documento = int_id_tipo_documento;
    }

    public String getVar_nombre_documento() {
        return var_nombre_documento;
    }

    public void setVar_nombre_documento(String var_nombre_documento) {
        this.var_nombre_documento = var_nombre_documento;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }

    public String getVar_asunto_documento() {
        return var_asunto_documento;
    }

    public void setVar_asunto_documento(String var_asunto_documento) {
        this.var_asunto_documento = var_asunto_documento;
    }

    public String getVar_descripcion_documento() {
        return var_descripcion_documento;
    }

    public void setVar_descripcion_documento(String var_descripcion_documento) {
        this.var_descripcion_documento = var_descripcion_documento;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Integer getSrl_id_contrato() {
        return srl_id_contrato;
    }

    public void setSrl_id_contrato(Integer srl_id_contrato) {
        this.srl_id_contrato = srl_id_contrato;
    }
}