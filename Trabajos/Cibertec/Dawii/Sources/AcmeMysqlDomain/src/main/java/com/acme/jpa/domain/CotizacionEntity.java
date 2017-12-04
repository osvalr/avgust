package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cotizacion database table.
 * 
 */
@Entity
@Table(name="cotizacion")
@NamedQuery(name="CotizacionEntity.findAll", query="SELECT c FROM CotizacionEntity c")
public class CotizacionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cotizacion;
	private String cod_cotizacion;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	private Integer id_estado;
	private Integer id_user;
	private Integer id_user_mod;
	private Double importe_total;

	//bi-directional many-to-one association to PersonaEntity
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private PersonaEntity persona1;

	//bi-directional many-to-one association to PersonaEntity
	@ManyToOne
	@JoinColumn(name="id_vendedor")
	private PersonaEntity persona2;

	//bi-directional many-to-one association to CotizacionProductoEntity
	@OneToMany(mappedBy="cotizacion", fetch=FetchType.EAGER)
	private List<CotizacionProductoEntity> cotizacionProductos;

	public CotizacionEntity() {
	}

	public PersonaEntity getPersona1() {
		return this.persona1;
	}

	public void setPersona1(PersonaEntity persona1) {
		this.persona1 = persona1;
	}

	public PersonaEntity getPersona2() {
		return this.persona2;
	}

	public void setPersona2(PersonaEntity persona2) {
		this.persona2 = persona2;
	}

	public List<CotizacionProductoEntity> getCotizacionProductos() {
		return this.cotizacionProductos;
	}

	public void setCotizacionProductos(List<CotizacionProductoEntity> cotizacionProductos) {
		this.cotizacionProductos = cotizacionProductos;
	}

	public CotizacionProductoEntity addCotizacionProducto(CotizacionProductoEntity cotizacionProducto) {
		getCotizacionProductos().add(cotizacionProducto);
		cotizacionProducto.setCotizacion(this);

		return cotizacionProducto;
	}

	public CotizacionProductoEntity removeCotizacionProducto(CotizacionProductoEntity cotizacionProducto) {
		getCotizacionProductos().remove(cotizacionProducto);
		cotizacionProducto.setCotizacion(null);

		return cotizacionProducto;
	}

	public Integer getId_cotizacion() {
		return id_cotizacion;
	}

	public void setId_cotizacion(Integer id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}

	public String getCod_cotizacion() {
		return cod_cotizacion;
	}

	public void setCod_cotizacion(String cod_cotizacion) {
		this.cod_cotizacion = cod_cotizacion;
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

	public Double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(Double importe_total) {
		this.importe_total = importe_total;
	}
}