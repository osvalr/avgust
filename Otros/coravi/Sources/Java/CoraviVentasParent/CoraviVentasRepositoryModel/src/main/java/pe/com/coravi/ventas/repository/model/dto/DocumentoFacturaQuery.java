/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The DocumentoFacturaQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   13/09/2016 05:02:41
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModel;

import java.util.List;

public class DocumentoFacturaQuery extends AbstractModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id_comprobante_pago;
	private Integer id_tipo_comprobante_pago;
	private String fecha_emision; 
	private Double anio_emision; 
	private Double mes_emision; 
	private Double dia_emision; 
	private String fecha_cancelado; 
	private String serie_docu_comprobante;
	private String correlativo_docu_cdp;
	private Integer num_docu_comprobante;
	private Integer id_cliente; 
	private String nombres_cliente;
	private String direccion_cliente;
	private Integer id_tipo_doc_cliente;
	private String descrip_tipo_doc_cliente;
	private String num_tipo_doc_cliente;
	private Double sub_total_venta; 
	private Double valor_igv_venta; 
	private Double importe_total; 
	private Integer flag_percepcion;
	private String descrip_flag_percepcion;
	private Double porcentaje_percepcion;
	private Double monto_percepcion; 
	private Integer id_estado; 
	private String descrip_estado; 

	private java.util.List<DocumentoFacturaDetalleQuery> listDocumentoFacturaDetalleQuery;

	public Integer getId_comprobante_pago() {
		return id_comprobante_pago;
	}

	public void setId_comprobante_pago(Integer id_comprobante_pago) {
		this.id_comprobante_pago = id_comprobante_pago;
	}

	public Integer getId_tipo_comprobante_pago() {
		return id_tipo_comprobante_pago;
	}

	public void setId_tipo_comprobante_pago(Integer id_tipo_comprobante_pago) {
		this.id_tipo_comprobante_pago = id_tipo_comprobante_pago;
	}

	public String getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public Double getAnio_emision() {
		return anio_emision;
	}

	public void setAnio_emision(Double anio_emision) {
		this.anio_emision = anio_emision;
	}

	public Double getMes_emision() {
		return mes_emision;
	}

	public void setMes_emision(Double mes_emision) {
		this.mes_emision = mes_emision;
	}

	public Double getDia_emision() {
		return dia_emision;
	}

	public void setDia_emision(Double dia_emision) {
		this.dia_emision = dia_emision;
	}

	public String getFecha_cancelado() {
		return fecha_cancelado;
	}

	public void setFecha_cancelado(String fecha_cancelado) {
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

	public Integer getNum_docu_comprobante() {
		return num_docu_comprobante;
	}

	public void setNum_docu_comprobante(Integer num_docu_comprobante) {
		this.num_docu_comprobante = num_docu_comprobante;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres_cliente() {
		return nombres_cliente;
	}

	public void setNombres_cliente(String nombres_cliente) {
		this.nombres_cliente = nombres_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public Integer getId_tipo_doc_cliente() {
		return id_tipo_doc_cliente;
	}

	public void setId_tipo_doc_cliente(Integer id_tipo_doc_cliente) {
		this.id_tipo_doc_cliente = id_tipo_doc_cliente;
	}

	public String getDescrip_tipo_doc_cliente() {
		return descrip_tipo_doc_cliente;
	}

	public void setDescrip_tipo_doc_cliente(String descrip_tipo_doc_cliente) {
		this.descrip_tipo_doc_cliente = descrip_tipo_doc_cliente;
	}

	public String getNum_tipo_doc_cliente() {
		return num_tipo_doc_cliente;
	}

	public void setNum_tipo_doc_cliente(String num_tipo_doc_cliente) {
		this.num_tipo_doc_cliente = num_tipo_doc_cliente;
	}

	public Double getSub_total_venta() {
		return sub_total_venta;
	}

	public void setSub_total_venta(Double sub_total_venta) {
		this.sub_total_venta = sub_total_venta;
	}

	public Double getValor_igv_venta() {
		return valor_igv_venta;
	}

	public void setValor_igv_venta(Double valor_igv_venta) {
		this.valor_igv_venta = valor_igv_venta;
	}

	public Double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(Double importe_total) {
		this.importe_total = importe_total;
	}

	public Integer getFlag_percepcion() {
		return flag_percepcion;
	}

	public void setFlag_percepcion(Integer flag_percepcion) {
		this.flag_percepcion = flag_percepcion;
	}

	public String getDescrip_flag_percepcion() {
		return descrip_flag_percepcion;
	}

	public void setDescrip_flag_percepcion(String descrip_flag_percepcion) {
		this.descrip_flag_percepcion = descrip_flag_percepcion;
	}

	public Double getPorcentaje_percepcion() {
		return porcentaje_percepcion;
	}

	public void setPorcentaje_percepcion(Double porcentaje_percepcion) {
		this.porcentaje_percepcion = porcentaje_percepcion;
	}

	public Double getMonto_percepcion() {
		return monto_percepcion;
	}

	public void setMonto_percepcion(Double monto_percepcion) {
		this.monto_percepcion = monto_percepcion;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescrip_estado() {
		return descrip_estado;
	}

	public void setDescrip_estado(String descrip_estado) {
		this.descrip_estado = descrip_estado;
	}

	public List<DocumentoFacturaDetalleQuery> getListDocumentoFacturaDetalleQuery() {
		return listDocumentoFacturaDetalleQuery;
	}

	public void setListDocumentoFacturaDetalleQuery(List<DocumentoFacturaDetalleQuery> listDocumentoFacturaDetalleQuery) {
		this.listDocumentoFacturaDetalleQuery = listDocumentoFacturaDetalleQuery;
	}
}