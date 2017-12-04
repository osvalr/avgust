package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GuiaRemisionItem extends GuiaRemisionItemKey implements Serializable {
    private Integer id_guia_remision;

    private Integer id_articulo;

    private Integer cantidad_articulo;

    private Integer id_unidad_medida;

    private BigDecimal peso_total;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia_remision() {
        return id_guia_remision;
    }

    public void setId_guia_remision(Integer id_guia_remision) {
        this.id_guia_remision = id_guia_remision;
    }

    public Integer getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(Integer id_articulo) {
        this.id_articulo = id_articulo;
    }

    public Integer getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(Integer cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }

    public Integer getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(Integer id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }

    public BigDecimal getPeso_total() {
        return peso_total;
    }

    public void setPeso_total(BigDecimal peso_total) {
        this.peso_total = peso_total;
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
        sb.append(", id_guia_remision=").append(id_guia_remision);
        sb.append(", id_articulo=").append(id_articulo);
        sb.append(", cantidad_articulo=").append(cantidad_articulo);
        sb.append(", id_unidad_medida=").append(id_unidad_medida);
        sb.append(", peso_total=").append(peso_total);
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