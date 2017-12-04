package sernanp.app.dao.domain;

import java.util.Date;

public class TConvAreaOrgEtapa extends TConvAreaOrgEtapaKey {
    private Integer srl_id_conv_area_org;

    private Integer idarea;

    private Integer idunidad;

    private Integer srl_id_subetapa_proceso_seleccion;

    private String var_descrip_subetapa;

    private Date dte_fecha_inicio;

    private Date dte_fecha_termino;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_conv_area_org() {
        return srl_id_conv_area_org;
    }

    public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
        this.srl_id_conv_area_org = srl_id_conv_area_org;
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

    public Integer getSrl_id_subetapa_proceso_seleccion() {
        return srl_id_subetapa_proceso_seleccion;
    }

    public void setSrl_id_subetapa_proceso_seleccion(Integer srl_id_subetapa_proceso_seleccion) {
        this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
    }

    public String getVar_descrip_subetapa() {
        return var_descrip_subetapa;
    }

    public void setVar_descrip_subetapa(String var_descrip_subetapa) {
        this.var_descrip_subetapa = var_descrip_subetapa;
    }

    public Date getDte_fecha_inicio() {
        return dte_fecha_inicio;
    }

    public void setDte_fecha_inicio(Date dte_fecha_inicio) {
        this.dte_fecha_inicio = dte_fecha_inicio;
    }

    public Date getDte_fecha_termino() {
        return dte_fecha_termino;
    }

    public void setDte_fecha_termino(Date dte_fecha_termino) {
        this.dte_fecha_termino = dte_fecha_termino;
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