package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="ProductoEntity.findAll", query="SELECT p FROM ProductoEntity p")
public class ProductoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_producto;
	private String cod_producto;
	private String descripcion;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	private Integer id_categoria;
	private Integer id_estado;
	private Integer id_moneda;
	private Integer id_user;
	private Integer id_user_mod;
	private String nombre;
	private String observacion;
	private Double precio;
	private String ruta_foto;

	//bi-directional many-to-one association to CotizacionProductoEntity
	@OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
	private List<CotizacionProductoEntity> cotizacionProductos;

	public ProductoEntity() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public List<CotizacionProductoEntity> getCotizacionProductos() {
		return this.cotizacionProductos;
	}

	public void setCotizacionProductos(List<CotizacionProductoEntity> cotizacionProductos) {
		this.cotizacionProductos = cotizacionProductos;
	}

	public CotizacionProductoEntity addCotizacionProducto(CotizacionProductoEntity cotizacionProducto) {
		getCotizacionProductos().add(cotizacionProducto);
		cotizacionProducto.setProducto(this);

		return cotizacionProducto;
	}

	public CotizacionProductoEntity removeCotizacionProducto(CotizacionProductoEntity cotizacionProducto) {
		getCotizacionProductos().remove(cotizacionProducto);
		cotizacionProducto.setProducto(null);

		return cotizacionProducto;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
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

	public String getRuta_foto() {
		return ruta_foto;
	}

	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}
}