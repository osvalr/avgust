package sernanp.app.dao.domain;

import java.util.Date;

public class TPersonanaturalFormacion extends TPersonanaturalFormacionKey {
    private Integer idpersonanatural;

    private Integer srl_id_tipo_profesion;

    private Integer srl_id_grupo_ocupacional;

    private Integer srl_id_nivel_estudio;

    private Integer int_tipo_formacion;

    private String var_descripcion_institucion;

    private Integer idpais;

    private Date dte_fecha_ingreso;

    private Date dte_fecha_culminacion;

    private Integer int_sigue_estudios;

    private Integer srl_id_profesion;

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public Integer getSrl_id_tipo_profesion() {
        return srl_id_tipo_profesion;
    }

    public void setSrl_id_tipo_profesion(Integer srl_id_tipo_profesion) {
        this.srl_id_tipo_profesion = srl_id_tipo_profesion;
    }

    public Integer getSrl_id_grupo_ocupacional() {
        return srl_id_grupo_ocupacional;
    }

    public void setSrl_id_grupo_ocupacional(Integer srl_id_grupo_ocupacional) {
        this.srl_id_grupo_ocupacional = srl_id_grupo_ocupacional;
    }

    public Integer getSrl_id_nivel_estudio() {
        return srl_id_nivel_estudio;
    }

    public void setSrl_id_nivel_estudio(Integer srl_id_nivel_estudio) {
        this.srl_id_nivel_estudio = srl_id_nivel_estudio;
    }

    public Integer getInt_tipo_formacion() {
        return int_tipo_formacion;
    }

    public void setInt_tipo_formacion(Integer int_tipo_formacion) {
        this.int_tipo_formacion = int_tipo_formacion;
    }

    public String getVar_descripcion_institucion() {
        return var_descripcion_institucion;
    }

    public void setVar_descripcion_institucion(String var_descripcion_institucion) {
        this.var_descripcion_institucion = var_descripcion_institucion;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public Date getDte_fecha_ingreso() {
        return dte_fecha_ingreso;
    }

    public void setDte_fecha_ingreso(Date dte_fecha_ingreso) {
        this.dte_fecha_ingreso = dte_fecha_ingreso;
    }

    public Date getDte_fecha_culminacion() {
        return dte_fecha_culminacion;
    }

    public void setDte_fecha_culminacion(Date dte_fecha_culminacion) {
        this.dte_fecha_culminacion = dte_fecha_culminacion;
    }

    public Integer getInt_sigue_estudios() {
        return int_sigue_estudios;
    }

    public void setInt_sigue_estudios(Integer int_sigue_estudios) {
        this.int_sigue_estudios = int_sigue_estudios;
    }

    public Integer getSrl_id_profesion() {
        return srl_id_profesion;
    }

    public void setSrl_id_profesion(Integer srl_id_profesion) {
        this.srl_id_profesion = srl_id_profesion;
    }
}