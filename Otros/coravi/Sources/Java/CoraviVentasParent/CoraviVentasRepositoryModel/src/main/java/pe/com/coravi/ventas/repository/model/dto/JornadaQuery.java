package pe.com.coravi.ventas.repository.model.dto;

import java.util.Date;

/**
 * Created by JRaffo on 11/04/17.
 */
public class JornadaQuery {

    private Integer num_dia;
    private Integer num_mes;
    private Integer num_anio;
    private Date fecha_jornada;
    private Integer id_estado;
    private Integer id_usuario_reg;
    private Date fecha_registro;
    private Integer id_usuario_mod;
    private Date fecha_modificacion;

    public Integer getNum_dia() {
        return num_dia;
    }

    public void setNum_dia(Integer num_dia) {
        this.num_dia = num_dia;
    }

    public Integer getNum_mes() {
        return num_mes;
    }

    public void setNum_mes(Integer num_mes) {
        this.num_mes = num_mes;
    }

    public Integer getNum_anio() {
        return num_anio;
    }

    public void setNum_anio(Integer num_anio) {
        this.num_anio = num_anio;
    }

    public Date getFecha_jornada() {
        return fecha_jornada;
    }

    public void setFecha_jornada(Date fecha_jornada) {
        this.fecha_jornada = fecha_jornada;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_usuario_reg() {
        return id_usuario_reg;
    }

    public void setId_usuario_reg(Integer id_usuario_reg) {
        this.id_usuario_reg = id_usuario_reg;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Integer getId_usuario_mod() {
        return id_usuario_mod;
    }

    public void setId_usuario_mod(Integer id_usuario_mod) {
        this.id_usuario_mod = id_usuario_mod;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
