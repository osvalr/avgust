package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cotizacion_producto database table.
 * 
 */
@Entity
@Table(name="cotizacion_producto")
@NamedQuery(name="CotizacionProductoEntity.findAll", query="SELECT c FROM CotizacionProductoEntity c")
public class CotizacionProductoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cotizacion_producto;
	private Integer cantidad;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	private Integer id_estado;
	private Integer id_moneda;
	private Integer id_user;
	private Integer id_user_mod;
	private Double precio;
	private Double sub_total;

	//bi-directional many-to-one association to CotizacionEntity
	@ManyToOne
	@JoinColumn(name="id_cotizacion")
	private CotizacionEntity cotizacion;

	//bi-directional many-to-one association to ProductoEntity
	@ManyToOne
	@JoinColumn(name="id_producto")
	private ProductoEntity producto;

	public CotizacionProductoEntity() {
	}

	public CotizacionEntity getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(CotizacionEntity cotizacion) {
		this.cotizacion = cotizacion;
	}

	public ProductoEntity getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Integer getId_cotizacion_producto() {
		return id_cotizacion_producto;
	}

	public void setId_cotizacion_producto(Integer id_cotizacion_producto) {
		this.id_cotizacion_producto = id_cotizacion_producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getFec_mod() {
		return fec_mod;
	}

	public void setFec_mod(Timestamp fec_mod) {
		this.fec_mod = fec_mod;
	}

	public Timestamp getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Timestamp fec_reg) {
		this.fec_reg = fec_reg;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_user_mod() {
		return id_user_mod;
	}

	public void setId_user_mod(Integer id_user_mod) {
		this.id_user_mod = id_user_mod;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getSub_total() {
		return sub_total;
	}

	public void setSub_total(Double sub_total) {
		this.sub_total = sub_total;
	}
}