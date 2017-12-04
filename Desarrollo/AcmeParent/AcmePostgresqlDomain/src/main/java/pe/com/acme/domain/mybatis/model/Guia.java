package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Guia extends GuiaKey implements Serializable {
    private Integer num_dia;

    private Integer num_mes;

    private Integer num_anio;

    private Integer id_proveedor;

    private Integer id_cliente;

    private Integer id_tipo_mvto_guia;

    private Integer id_tipo_producto;

    private BigDecimal total_peso_bruto;

    private BigDecimal total_peso_tara;

    private BigDecimal total_peso_devolucion;

    private BigDecimal total_peso_neto;

    private BigDecimal precio_aplicado;

    private Integer id_moneda_local;

    private BigDecimal total_importe;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private Integer id_guia_referencia;

    private Integer id_tipo_guia;

    private static final long serialVersionUID = 1L;

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

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_tipo_mvto_guia() {
        return id_tipo_mvto_guia;
    }

    public void setId_tipo_mvto_guia(Integer id_tipo_mvto_guia) {
        this.id_tipo_mvto_guia = id_tipo_mvto_guia;
    }

    public Integer getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(Integer id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public BigDecimal getTotal_peso_bruto() {
        return total_peso_bruto;
    }

    public void setTotal_peso_bruto(BigDecimal total_peso_bruto) {
        this.total_peso_bruto = total_peso_bruto;
    }

    public BigDecimal getTotal_peso_tara() {
        return total_peso_tara;
    }

    public void setTotal_peso_tara(BigDecimal total_peso_tara) {
        this.total_peso_tara = total_peso_tara;
    }

    public BigDecimal getTotal_peso_devolucion() {
        return total_peso_devolucion;
    }

    public void setTotal_peso_devolucion(BigDecimal total_peso_devolucion) {
        this.total_peso_devolucion = total_peso_devolucion;
    }

    public BigDecimal getTotal_peso_neto() {
        return total_peso_neto;
    }

    public void setTotal_peso_neto(BigDecimal total_peso_neto) {
        this.total_peso_neto = total_peso_neto;
    }

    public BigDecimal getPrecio_aplicado() {
        return precio_aplicado;
    }

    public void setPrecio_aplicado(BigDecimal precio_aplicado) {
        this.precio_aplicado = precio_aplicado;
    }

    public Integer getId_moneda_local() {
        return id_moneda_local;
    }

    public void setId_moneda_local(Integer id_moneda_local) {
        this.id_moneda_local = id_moneda_local;
    }

    public BigDecimal getTotal_importe() {
        return total_importe;
    }

    public void setTotal_importe(BigDecimal total_importe) {
        this.total_importe = total_importe;
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

    public Integer getId_guia_referencia() {
        return id_guia_referencia;
    }

    public void setId_guia_referencia(Integer id_guia_referencia) {
        this.id_guia_referencia = id_guia_referencia;
    }

    public Integer getId_tipo_guia() {
        return id_tipo_guia;
    }

    public void setId_tipo_guia(Integer id_tipo_guia) {
        this.id_tipo_guia = id_tipo_guia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", num_dia=").append(num_dia);
        sb.append(", num_mes=").append(num_mes);
        sb.append(", num_anio=").append(num_anio);
        sb.append(", id_proveedor=").append(id_proveedor);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append(", id_tipo_mvto_guia=").append(id_tipo_mvto_guia);
        sb.append(", id_tipo_producto=").append(id_tipo_producto);
        sb.append(", total_peso_bruto=").append(total_peso_bruto);
        sb.append(", total_peso_tara=").append(total_peso_tara);
        sb.append(", total_peso_devolucion=").append(total_peso_devolucion);
        sb.append(", total_peso_neto=").append(total_peso_neto);
        sb.append(", precio_aplicado=").append(precio_aplicado);
        sb.append(", id_moneda_local=").append(id_moneda_local);
        sb.append(", total_importe=").append(total_importe);
        sb.append(", id_estado=").append(id_estado);
        sb.append(", id_usuario_reg=").append(id_usuario_reg);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append(", id_usuario_mod=").append(id_usuario_mod);
        sb.append(", fecha_modificacion=").append(fecha_modificacion);
        sb.append(", id_guia_referencia=").append(id_guia_referencia);
        sb.append(", id_tipo_guia=").append(id_tipo_guia);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}