package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

import java.util.ArrayList;
import java.util.List;

public class CatalogoQuery extends DataTranferObject implements java.io.Serializable {

private static final long serialVersionUID = 1L;
private Integer id_catalogo; 
private String nombre_catalogo;

  private String nom_user;
  private String nom_user_mod;
  private String descrip_estado;

private List<CatalogoItemQuery> catalogoItemQueryList = new ArrayList<CatalogoItemQuery>();

public Integer getId_catalogo() { 
  return id_catalogo; 
} 
public void setId_catalogo(Integer id_catalogo) { 
  this.id_catalogo = id_catalogo; 
} 
public String getNombre_catalogo() { 
  return nombre_catalogo; 
} 
public void setNombre_catalogo(String nombre_catalogo) { 
  this.nombre_catalogo = nombre_catalogo; 
}

  public List<CatalogoItemQuery> getCatalogoItemQueryList() {
    return catalogoItemQueryList;
  }

  public void setCatalogoItemQueryList(List<CatalogoItemQuery> catalogoItemQueryList) {
    this.catalogoItemQueryList = catalogoItemQueryList;
  }

  public String getNom_user() {
    return nom_user;
  }

  public void setNom_user(String nom_user) {
    this.nom_user = nom_user;
  }

  public String getNom_user_mod() {
    return nom_user_mod;
  }

  public void setNom_user_mod(String nom_user_mod) {
    this.nom_user_mod = nom_user_mod;
  }

  public String getDescrip_estado() {
    return descrip_estado;
  }

  public void setDescrip_estado(String descrip_estado) {
    this.descrip_estado = descrip_estado;
  }
}
