package com.acme.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the catalogo_item database table.
 * 
 */
@Entity
@Table(name="catalogo_item")
@NamedQuery(name="CatalogoItemEntity.findAll", query="SELECT c FROM CatalogoItemEntity c")
public class CatalogoItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_catalogo_item;
	private Timestamp fec_mod;
	private Timestamp fec_reg;
	private Integer id_estado;
	private Integer id_user;
	private Integer id_user_mod;
	private String valor_a;
	private String valor_b;
	private String valor_c;
	private String valor_d;
	private String valor_e;

	//bi-directional many-to-one association to CatalogoEntity
	@ManyToOne
	@JoinColumn(name="id_catalogo")
	private CatalogoEntity catalogo;

	//bi-directional many-to-one association to CatalogoItemEntity
	@ManyToOne
	@JoinColumn(name="id_catalogo_item_foraneo")
	private CatalogoItemEntity catalogoItem;

	//bi-directional many-to-one association to CatalogoItemEntity
	@OneToMany(mappedBy="catalogoItem", fetch=FetchType.EAGER)
	private List<CatalogoItemEntity> catalogoItems;

	public CatalogoItemEntity() {
	}

	public CatalogoEntity getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(CatalogoEntity catalogo) {
		this.catalogo = catalogo;
	}

	public CatalogoItemEntity getCatalogoItem() {
		return this.catalogoItem;
	}

	public void setCatalogoItem(CatalogoItemEntity catalogoItem) {
		this.catalogoItem = catalogoItem;
	}

	public List<CatalogoItemEntity> getCatalogoItems() {
		return this.catalogoItems;
	}

	public void setCatalogoItems(List<CatalogoItemEntity> catalogoItems) {
		this.catalogoItems = catalogoItems;
	}

	public CatalogoItemEntity addCatalogoItem(CatalogoItemEntity catalogoItem) {
		getCatalogoItems().add(catalogoItem);
		catalogoItem.setCatalogoItem(this);

		return catalogoItem;
	}

	public CatalogoItemEntity removeCatalogoItem(CatalogoItemEntity catalogoItem) {
		getCatalogoItems().remove(catalogoItem);
		catalogoItem.setCatalogoItem(null);

		return catalogoItem;
	}

	public Integer getId_catalogo_item() {
		return id_catalogo_item;
	}

	public void setId_catalogo_item(Integer id_catalogo_item) {
		this.id_catalogo_item = id_catalogo_item;
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

	public String getValor_a() {
		return valor_a;
	}

	public void setValor_a(String valor_a) {
		this.valor_a = valor_a;
	}

	public String getValor_b() {
		return valor_b;
	}

	public void setValor_b(String valor_b) {
		this.valor_b = valor_b;
	}

	public String getValor_c() {
		return valor_c;
	}

	public void setValor_c(String valor_c) {
		this.valor_c = valor_c;
	}

	public String getValor_d() {
		return valor_d;
	}

	public void setValor_d(String valor_d) {
		this.valor_d = valor_d;
	}

	public String getValor_e() {
		return valor_e;
	}

	public void setValor_e(String valor_e) {
		this.valor_e = valor_e;
	}

}