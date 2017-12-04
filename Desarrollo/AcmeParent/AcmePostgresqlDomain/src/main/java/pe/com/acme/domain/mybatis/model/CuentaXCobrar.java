package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CuentaXCobrar extends CuentaXCobrarKey implements Serializable {
    private Integer id_cliente;

    private String descrip_glosa;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private BigDecimal monto_deuda;

    private Date fecha_cuenta;

    private static final long serialVersionUID = 1L;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescrip_glosa() {
        return descrip_glosa;
    }

    public void setDescrip_glosa(String descrip_glosa) {
        this.descrip_glosa = descrip_glosa;
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

    public BigDecimal getMonto_deuda() {
        return monto_deuda;
    }

    public void setMonto_deuda(BigDecimal monto_deuda) {
        this.monto_deuda = monto_deuda;
    }

    public Date getFecha_cuenta() {
        return fecha_cuenta;
    }

    public void setFecha_cuenta(Date fecha_cuenta) {
        this.fecha_cuenta = fecha_cuenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id_cliente=").append(id_cliente);
        sb.append(", descrip_glosa=").append(descrip_glosa);
        sb.append(", id_estado=").append(id_estado);
        sb.append(", id_usuario_reg=").append(id_usuario_reg);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", id_usuario_mod=").append(id_usuario_mod);
        sb.append(", fecha_modificacion=").append(fecha_modificacion);
        sb.append(", monto_deuda=").append(monto_deuda);
        sb.append(", fecha_cuenta=").append(fecha_cuenta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}