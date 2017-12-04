package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GuiaSaldo extends GuiaSaldoKey implements Serializable {
    private Integer id_guia;

    private Integer id_moneda;

    private BigDecimal monto_amortizado;

    private Date fecha_saldo;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_guia() {
        return id_guia;
    }

    public void setId_guia(Integer id_guia) {
        this.id_guia = id_guia;
    }

    public Integer getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(Integer id_moneda) {
        this.id_moneda = id_moneda;
    }

    public BigDecimal getMonto_amortizado() {
        return monto_amortizado;
    }

    public void setMonto_amortizado(BigDecimal monto_amortizado) {
        this.monto_amortizado = monto_amortizado;
    }

    public Date getFecha_saldo() {
        return fecha_saldo;
    }

    public void setFecha_saldo(Date fecha_saldo) {
        this.fecha_saldo = fecha_saldo;
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
        sb.append(", id_guia=").append(id_guia);
        sb.append(", id_moneda=").append(id_moneda);
        sb.append(", monto_amortizado=").append(monto_amortizado);
        sb.append(", fecha_saldo=").append(fecha_saldo);
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