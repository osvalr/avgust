package sernanp.app.dao.domain;

import java.util.Date;

public class TAfpComision extends TAfpComisionKey {
    private Integer srl_id_afp;

    private Integer int_id_tipo_comision;

    private Double dec_aporte;

    private Double dec_seguro;

    private Double dec_comision;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_afp() {
        return srl_id_afp;
    }

    public void setSrl_id_afp(Integer srl_id_afp) {
        this.srl_id_afp = srl_id_afp;
    }

    public Integer getInt_id_tipo_comision() {
        return int_id_tipo_comision;
    }

    public void setInt_id_tipo_comision(Integer int_id_tipo_comision) {
        this.int_id_tipo_comision = int_id_tipo_comision;
    }

    public Double getDec_aporte() {
        return dec_aporte;
    }

    public void setDec_aporte(Double dec_aporte) {
        this.dec_aporte = dec_aporte;
    }

    public Double getDec_seguro() {
        return dec_seguro;
    }

    public void setDec_seguro(Double dec_seguro) {
        this.dec_seguro = dec_seguro;
    }

    public Double getDec_comision() {
        return dec_comision;
    }

    public void setDec_comision(Double dec_comision) {
        this.dec_comision = dec_comision;
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