package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class GuiaRemision extends GuiaRemisionKey implements Serializable {
    private Integer id_comprobante_pago;

    private String serie_docu_guia;

    private String correlativo_docu_guia;

    private String num_docu_guia;

    private Date fecha_inicio_traslado;

    private Integer id_destinatario;

    private Integer id_motivo_traslado;

    private String direccion_partida;

    private Integer id_departamento_partida;

    private Integer id_provincia_partida;

    private Integer id_distrito_partida;

    private String direccion_llegada;

    private Integer id_departamento_llegada;

    private Integer id_provincia_llegada;

    private Integer id_distrito_llegada;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_comprobante_pago() {
        return id_comprobante_pago;
    }

    public void setId_comprobante_pago(Integer id_comprobante_pago) {
        this.id_comprobante_pago = id_comprobante_pago;
    }

    public String getSerie_docu_guia() {
        return serie_docu_guia;
    }

    public void setSerie_docu_guia(String serie_docu_guia) {
        this.serie_docu_guia = serie_docu_guia;
    }

    public String getCorrelativo_docu_guia() {
        return correlativo_docu_guia;
    }

    public void setCorrelativo_docu_guia(String correlativo_docu_guia) {
        this.correlativo_docu_guia = correlativo_docu_guia;
    }

    public String getNum_docu_guia() {
        return num_docu_guia;
    }

    public void setNum_docu_guia(String num_docu_guia) {
        this.num_docu_guia = num_docu_guia;
    }

    public Date getFecha_inicio_traslado() {
        return fecha_inicio_traslado;
    }

    public void setFecha_inicio_traslado(Date fecha_inicio_traslado) {
        this.fecha_inicio_traslado = fecha_inicio_traslado;
    }

    public Integer getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(Integer id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public Integer getId_motivo_traslado() {
        return id_motivo_traslado;
    }

    public void setId_motivo_traslado(Integer id_motivo_traslado) {
        this.id_motivo_traslado = id_motivo_traslado;
    }

    public String getDireccion_partida() {
        return direccion_partida;
    }

    public void setDireccion_partida(String direccion_partida) {
        this.direccion_partida = direccion_partida;
    }

    public Integer getId_departamento_partida() {
        return id_departamento_partida;
    }

    public void setId_departamento_partida(Integer id_departamento_partida) {
        this.id_departamento_partida = id_departamento_partida;
    }

    public Integer getId_provincia_partida() {
        return id_provincia_partida;
    }

    public void setId_provincia_partida(Integer id_provincia_partida) {
        this.id_provincia_partida = id_provincia_partida;
    }

    public Integer getId_distrito_partida() {
        return id_distrito_partida;
    }

    public void setId_distrito_partida(Integer id_distrito_partida) {
        this.id_distrito_partida = id_distrito_partida;
    }

    public String getDireccion_llegada() {
        return direccion_llegada;
    }

    public void setDireccion_llegada(String direccion_llegada) {
        this.direccion_llegada = direccion_llegada;
    }

    public Integer getId_departamento_llegada() {
        return id_departamento_llegada;
    }

    public void setId_departamento_llegada(Integer id_departamento_llegada) {
        this.id_departamento_llegada = id_departamento_llegada;
    }

    public Integer getId_provincia_llegada() {
        return id_provincia_llegada;
    }

    public void setId_provincia_llegada(Integer id_provincia_llegada) {
        this.id_provincia_llegada = id_provincia_llegada;
    }

    public Integer getId_distrito_llegada() {
        return id_distrito_llegada;
    }

    public void setId_distrito_llegada(Integer id_distrito_llegada) {
        this.id_distrito_llegada = id_distrito_llegada;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_comprobante_pago=").append(id_comprobante_pago);
        sb.append(", serie_docu_guia=").append(serie_docu_guia);
        sb.append(", correlativo_docu_guia=").append(correlativo_docu_guia);
        sb.append(", num_docu_guia=").append(num_docu_guia);
        sb.append(", fecha_inicio_traslado=").append(fecha_inicio_traslado);
        sb.append(", id_destinatario=").append(id_destinatario);
        sb.append(", id_motivo_traslado=").append(id_motivo_traslado);
        sb.append(", direccion_partida=").append(direccion_partida);
        sb.append(", id_departamento_partida=").append(id_departamento_partida);
        sb.append(", id_provincia_partida=").append(id_provincia_partida);
        sb.append(", id_distrito_partida=").append(id_distrito_partida);
        sb.append(", direccion_llegada=").append(direccion_llegada);
        sb.append(", id_departamento_llegada=").append(id_departamento_llegada);
        sb.append(", id_provincia_llegada=").append(id_provincia_llegada);
        sb.append(", id_distrito_llegada=").append(id_distrito_llegada);
        sb.append(", id_estado=").append(id_estado);
        sb.append(", id_usuario_reg=").append(id_usuario_reg);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", id_usuario_mod=").append(id_usuario_mod);
        sb.append(", fecha_modificacion=").append(fecha_modificacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}