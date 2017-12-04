package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TPersonalDescuento extends TPersonalDescuentoKey {
    private Integer int_periodo_desc;

    private Integer int_mes_desc;

    private BigDecimal num_monto_desc;

    private Date tsp_fec_pers_desc;

    private Integer idpersonal;

    private Integer idtablatipo;

    private Integer int_minutos_tardanza;

    private Integer int_cant_inasistencias;

    private Integer int_cant_dias_permiso;

    private Integer int_cant_dias_licencias_sgh;

    private Date hor_cant_permiso;

    private Integer int_flag_ubicacion;

    private Integer int_id_reg_contractual;

    private Integer int_id_sede;

    public Integer getInt_periodo_desc() {
        return int_periodo_desc;
    }

    public void setInt_periodo_desc(Integer int_periodo_desc) {
        this.int_periodo_desc = int_periodo_desc;
    }

    public Integer getInt_mes_desc() {
        return int_mes_desc;
    }

    public void setInt_mes_desc(Integer int_mes_desc) {
        this.int_mes_desc = int_mes_desc;
    }

    public BigDecimal getNum_monto_desc() {
        return num_monto_desc;
    }

    public void setNum_monto_desc(BigDecimal num_monto_desc) {
        this.num_monto_desc = num_monto_desc;
    }

    public Date getTsp_fec_pers_desc() {
        return tsp_fec_pers_desc;
    }

    public void setTsp_fec_pers_desc(Date tsp_fec_pers_desc) {
        this.tsp_fec_pers_desc = tsp_fec_pers_desc;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdtablatipo() {
        return idtablatipo;
    }

    public void setIdtablatipo(Integer idtablatipo) {
        this.idtablatipo = idtablatipo;
    }

    public Integer getInt_minutos_tardanza() {
        return int_minutos_tardanza;
    }

    public void setInt_minutos_tardanza(Integer int_minutos_tardanza) {
        this.int_minutos_tardanza = int_minutos_tardanza;
    }

    public Integer getInt_cant_inasistencias() {
        return int_cant_inasistencias;
    }

    public void setInt_cant_inasistencias(Integer int_cant_inasistencias) {
        this.int_cant_inasistencias = int_cant_inasistencias;
    }

    public Integer getInt_cant_dias_permiso() {
        return int_cant_dias_permiso;
    }

    public void setInt_cant_dias_permiso(Integer int_cant_dias_permiso) {
        this.int_cant_dias_permiso = int_cant_dias_permiso;
    }

    public Integer getInt_cant_dias_licencias_sgh() {
        return int_cant_dias_licencias_sgh;
    }

    public void setInt_cant_dias_licencias_sgh(Integer int_cant_dias_licencias_sgh) {
        this.int_cant_dias_licencias_sgh = int_cant_dias_licencias_sgh;
    }

    public Date getHor_cant_permiso() {
        return hor_cant_permiso;
    }

    public void setHor_cant_permiso(Date hor_cant_permiso) {
        this.hor_cant_permiso = hor_cant_permiso;
    }

    public Integer getInt_flag_ubicacion() {
        return int_flag_ubicacion;
    }

    public void setInt_flag_ubicacion(Integer int_flag_ubicacion) {
        this.int_flag_ubicacion = int_flag_ubicacion;
    }

    public Integer getInt_id_reg_contractual() {
        return int_id_reg_contractual;
    }

    public void setInt_id_reg_contractual(Integer int_id_reg_contractual) {
        this.int_id_reg_contractual = int_id_reg_contractual;
    }

    public Integer getInt_id_sede() {
        return int_id_sede;
    }

    public void setInt_id_sede(Integer int_id_sede) {
        this.int_id_sede = int_id_sede;
    }
}