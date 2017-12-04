package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TAnioParametroPlanilla extends TAnioParametroPlanillaKey {
    private Integer srl_id_anio_planilla;

    private Integer srl_id_parametro_planilla;

    private BigDecimal dec_valor_parametro;

    private Date dte_fecha_vigencia;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public Integer getSrl_id_parametro_planilla() {
        return srl_id_parametro_planilla;
    }

    public void setSrl_id_parametro_planilla(Integer srl_id_parametro_planilla) {
        this.srl_id_parametro_planilla = srl_id_parametro_planilla;
    }

    public BigDecimal getDec_valor_parametro() {
        return dec_valor_parametro;
    }

    public void setDec_valor_parametro(BigDecimal dec_valor_parametro) {
        this.dec_valor_parametro = dec_valor_parametro;
    }

    public Date getDte_fecha_vigencia() {
        return dte_fecha_vigencia;
    }

    public void setDte_fecha_vigencia(Date dte_fecha_vigencia) {
        this.dte_fecha_vigencia = dte_fecha_vigencia;
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