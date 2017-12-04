package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GuiaPeso extends GuiaPesoKey implements Serializable {
    private Integer id_guia;

    private Integer id_tipo_peso;

    private Integer num_jabas;

    private Integer num_aves;

    private BigDecimal peso_obtenido;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private Integer flag_devolucion;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia() {
        return id_guia;
    }

    public void setId_guia(Integer id_guia) {
        this.id_guia = id_guia;
    }

    public Integer getId_tipo_peso() {
        return id_tipo_peso;
    }

    public void setId_tipo_peso(Integer id_tipo_peso) {
        this.id_tipo_peso = id_tipo_peso;
    }

    public Integer getNum_jabas() {
        return num_jabas;
    }

    public void setNum_jabas(Integer num_jabas) {
        this.num_jabas = num_jabas;
    }

    public Integer getNum_aves() {
        return num_aves;
    }

    public void setNum_aves(Integer num_aves) {
        this.num_aves = num_aves;
    }

    public BigDecimal getPeso_obtenido() {
        return peso_obtenido;
    }

    public void setPeso_obtenido(BigDecimal peso_obtenido) {
        this.peso_obtenido = peso_obtenido;
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

    public Integer getFlag_devolucion() {
        return flag_devolucion;
    }

    public void setFlag_devolucion(Integer flag_devolucion) {
        this.flag_devolucion = flag_devolucion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_guia=").append(id_guia);
        sb.append(", id_tipo_peso=").append(id_tipo_peso);
        sb.append(", num_jabas=").append(num_jabas);
        sb.append(", num_aves=").append(num_aves);
        sb.append(", peso_obtenido=").append(peso_obtenido);
        sb.append(", id_estado=").append(id_estado);
        sb.append(", id_usuario_reg=").append(id_usuario_reg);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", id_usuario_mod=").append(id_usuario_mod);
        sb.append(", fecha_modificacion=").append(fecha_modificacion);
        sb.append(", flag_devolucion=").append(flag_devolucion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}