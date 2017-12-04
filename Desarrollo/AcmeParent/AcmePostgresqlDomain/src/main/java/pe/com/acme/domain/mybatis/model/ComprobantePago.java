package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ComprobantePago extends ComprobantePagoKey implements Serializable {
    private Integer id_tipo_comprobante_pago;

    private Date fecha_emision;

    private Date fecha_cancelado;

    private String serie_docu_comprobante;

    private String correlativo_docu_cdp;

    private String num_docu_comprobante;

    private Integer id_cliente;

    private BigDecimal sub_total_venta;

    private BigDecimal valor_igv_venta;

    private BigDecimal importe_total;

    private Integer flag_percepcion;

    private BigDecimal porcentaje_percepcion;

    private BigDecimal monto_percepcion;

    private Integer id_estado;

    private Integer id_usuario_reg;

    private Date fecha_registro;

    private Integer id_usuario_mod;

    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    public Integer getId_tipo_comprobante_pago() {
        return id_tipo_comprobante_pago;
    }

    public void setId_tipo_comprobante_pago(Integer id_tipo_comprobante_pago) {
        this.id_tipo_comprobante_pago = id_tipo_comprobante_pago;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_cancelado() {
        return fecha_cancelado;
    }

    public void setFecha_cancelado(Date fecha_cancelado) {
        this.fecha_cancelado = fecha_cancelado;
    }

    public String getSerie_docu_comprobante() {
        return serie_docu_comprobante;
    }

    public void setSerie_docu_comprobante(String serie_docu_comprobante) {
        this.serie_docu_comprobante = serie_docu_comprobante;
    }

    public String getCorrelativo_docu_cdp() {
        return correlativo_docu_cdp;
    }

    public void setCorrelativo_docu_cdp(String correlativo_docu_cdp) {
        this.correlativo_docu_cdp = correlativo_docu_cdp;
    }

    public String getNum_docu_comprobante() {
        return num_docu_comprobante;
    }

    public void setNum_docu_comprobante(String num_docu_comprobante) {
        this.num_docu_comprobante = num_docu_comprobante;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public BigDecimal getSub_total_venta() {
        return sub_total_venta;
    }

    public void setSub_total_venta(BigDecimal sub_total_venta) {
        this.sub_total_venta = sub_total_venta;
    }

    public BigDecimal getValor_igv_venta() {
        return valor_igv_venta;
    }

    public void setValor_igv_venta(BigDecimal valor_igv_venta) {
        this.valor_igv_venta = valor_igv_venta;
    }

    public BigDecimal getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(BigDecimal importe_total) {
        this.importe_total = importe_total;
    }

    public Integer getFlag_percepcion() {
        return flag_percepcion;
    }

    public void setFlag_percepcion(Integer flag_percepcion) {
        this.flag_percepcion = flag_percepcion;
    }

    public BigDecimal getPorcentaje_percepcion() {
        return porcentaje_percepcion;
    }

    public void setPorcentaje_percepcion(BigDecimal porcentaje_percepcion) {
        this.porcentaje_percepcion = porcentaje_percepcion;
    }

    public BigDecimal getMonto_percepcion() {
        return monto_percepcion;
    }

    public void setMonto_percepcion(BigDecimal monto_percepcion) {
        this.monto_percepcion = monto_percepcion;
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
        sb.append(", id_tipo_comprobante_pago=").append(id_tipo_comprobante_pago);
        sb.append(", fecha_emision=").append(fecha_emision);
        sb.append(", fecha_cancelado=").append(fecha_cancelado);
        sb.append(", serie_docu_comprobante=").append(serie_docu_comprobante);
        sb.append(", correlativo_docu_cdp=").append(correlativo_docu_cdp);
        sb.append(", num_docu_comprobante=").append(num_docu_comprobante);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append(", sub_total_venta=").append(sub_total_venta);
        sb.append(", valor_igv_venta=").append(valor_igv_venta);
        sb.append(", importe_total=").append(importe_total);
        sb.append(", flag_percepcion=").append(flag_percepcion);
        sb.append(", porcentaje_percepcion=").append(porcentaje_percepcion);
        sb.append(", monto_percepcion=").append(monto_percepcion);
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