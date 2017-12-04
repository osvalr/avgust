package sernanp.app.dao.domain;

import java.util.Date;

public class TConvocatoriaAreaOrg extends TConvocatoriaAreaOrgKey {
    private Integer srl_id_convocatoria;

    private Integer idarea;

    private Integer idunidad;

    private String var_codigo_postulacion;

    private Integer int_num_puestos;

    private Integer int_id_estado;

    private Integer int_num_activacion;

    private Date tsp_fecha_registro;

    private Integer srl_id_requerimiento_personal;

    private Integer srl_id_configuracion_factor_evaluacion;

    private Integer srl_id_configuracion_evaluacion_personal;

    private Integer idpersonal;

    private String var_lugar_prestacion;

    private Date dte_fecha_inicio_contrato;

    private Date dte_fecha_fin_contrato;

    public Integer getSrl_id_convocatoria() {
        return srl_id_convocatoria;
    }

    public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
        this.srl_id_convocatoria = srl_id_convocatoria;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public String getVar_codigo_postulacion() {
        return var_codigo_postulacion;
    }

    public void setVar_codigo_postulacion(String var_codigo_postulacion) {
        this.var_codigo_postulacion = var_codigo_postulacion;
    }

    public Integer getInt_num_puestos() {
        return int_num_puestos;
    }

    public void setInt_num_puestos(Integer int_num_puestos) {
        this.int_num_puestos = int_num_puestos;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Integer getInt_num_activacion() {
        return int_num_activacion;
    }

    public void setInt_num_activacion(Integer int_num_activacion) {
        this.int_num_activacion = int_num_activacion;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }

    public Integer getSrl_id_requerimiento_personal() {
        return srl_id_requerimiento_personal;
    }

    public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) {
        this.srl_id_requerimiento_personal = srl_id_requerimiento_personal;
    }

    public Integer getSrl_id_configuracion_factor_evaluacion() {
        return srl_id_configuracion_factor_evaluacion;
    }

    public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) {
        this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion;
    }

    public Integer getSrl_id_configuracion_evaluacion_personal() {
        return srl_id_configuracion_evaluacion_personal;
    }

    public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) {
        this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getVar_lugar_prestacion() {
        return var_lugar_prestacion;
    }

    public void setVar_lugar_prestacion(String var_lugar_prestacion) {
        this.var_lugar_prestacion = var_lugar_prestacion;
    }

    public Date getDte_fecha_inicio_contrato() {
        return dte_fecha_inicio_contrato;
    }

    public void setDte_fecha_inicio_contrato(Date dte_fecha_inicio_contrato) {
        this.dte_fecha_inicio_contrato = dte_fecha_inicio_contrato;
    }

    public Date getDte_fecha_fin_contrato() {
        return dte_fecha_fin_contrato;
    }

    public void setDte_fecha_fin_contrato(Date dte_fecha_fin_contrato) {
        this.dte_fecha_fin_contrato = dte_fecha_fin_contrato;
    }
}