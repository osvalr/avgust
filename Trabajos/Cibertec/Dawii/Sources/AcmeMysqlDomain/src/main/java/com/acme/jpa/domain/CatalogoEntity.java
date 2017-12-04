package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@Table(name="catalogo")
@NamedQuery(name="CatalogoEntity.findAll", query="SELECT c FROM CatalogoEntity c")
public class CatalogoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_catalogo;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	private Integer id_estado;
	private Integer id_user;
	private Integer id_user_mod;
	private String nombre_catalogo;

	//bi-directional many-to-one association to CatalogoItemEntity
	@OneToMany(mappedBy="catalogo", fetch=FetchType.EAGER)
	private List<CatalogoItemEntity> catalogoItems;

	public CatalogoEntity() {
	}

	public List<CatalogoItemEntity> getCatalogoItems() {
		return this.catalogoItems;
	}

	public void setCatalogoItems(List<CatalogoItemEntity> catalogoItems) {
		this.catalogoItems = catalogoItems;
	}

	public CatalogoItemEntity addCatalogoItem(CatalogoItemEntity catalogoItem) {
		getCatalogoItems().add(catalogoItem);
		catalogoItem.setCatalogo(this);

		return catalogoItem;
	}

	public CatalogoItemEntity removeCatalogoItem(CatalogoItemEntity catalogoItem) {
		getCatalogoItems().remove(catalogoItem);
		catalogoItem.setCatalogo(null);

		return catalogoItem;
	}

	public Integer getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(Integer id_catalogo) {
		this.id_catalogo = id_catalogo;
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

	public String getNombre_catalogo() {
		return nombre_catalogo;
	}

	public void setNombre_catalogo(String nombre_catalogo) {
		this.nombre_catalogo = nombre_catalogo;
	}
}