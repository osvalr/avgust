/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The DocumentoFacturaDetalleQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   13/09/2016 05:03:11
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModel;

import java.math.BigDecimal;

public class DocumentoBoletaDetalleQuery extends AbstractModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id_comprobante_item;
	private Integer id_comprobante_pago;
	private Integer id_unidad_medida;
	private String descrip_unidad_medida;
	private Integer id_articulo;
	private String nombre_articulo;
	private Integer cantidad_articulo;
	private BigDecimal peso_articulo;
	private BigDecimal precio_unitario;
	private BigDecimal importe_total;
	private Integer id_estado; 
	private String descrip_estado;

	public Integer getId_comprobante_item() {
		return id_comprobante_item;
	}

	public void setId_comprobante_item(Integer id_comprobante_item) {
		this.id_comprobante_item = id_comprobante_item;
	}

	public Integer getId_comprobante_pago() {
		return id_comprobante_pago;
	}

	public void setId_comprobante_pago(Integer id_comprobante_pago) {
		this.id_comprobante_pago = id_comprobante_pago;
	}

	public Integer getId_unidad_medida() {
		return id_unidad_medida;
	}

	public void setId_unidad_medida(Integer id_unidad_medida) {
		this.id_unidad_medida = id_unidad_medida;
	}

	public String getDescrip_unidad_medida() {
		return descrip_unidad_medida;
	}

	public void setDescrip_unidad_medida(String descrip_unidad_medida) {
		this.descrip_unidad_medida = descrip_unidad_medida;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}

	public Integer getCantidad_articulo() {
		return cantidad_articulo;
	}

	public void setCantidad_articulo(Integer cantidad_articulo) {
		this.cantidad_articulo = cantidad_articulo;
	}

	public BigDecimal getPeso_articulo() {
		return peso_articulo;
	}

	public void setPeso_articulo(BigDecimal peso_articulo) {
		this.peso_articulo = peso_articulo;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public BigDecimal getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(BigDecimal importe_total) {
		this.importe_total = importe_total;
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

	@Override
	public String toString() {
		return "DocumentoBoletaDetalleQuery{" +
				"id_comprobante_item=" + id_comprobante_item +
				", id_comprobante_pago=" + id_comprobante_pago +
				", id_unidad_medida=" + id_unidad_medida +
				", descrip_unidad_medida='" + descrip_unidad_medida + '\'' +
				", id_articulo=" + id_articulo +
				", nombre_articulo='" + nombre_articulo + '\'' +
				", cantidad_articulo=" + cantidad_articulo +
				", peso_articulo=" + peso_articulo +
				", precio_unitario=" + precio_unitario +
				", importe_total=" + importe_total +
				", id_estado=" + id_estado +
				", descrip_estado='" + descrip_estado + '\'' +
				'}';
	}
}