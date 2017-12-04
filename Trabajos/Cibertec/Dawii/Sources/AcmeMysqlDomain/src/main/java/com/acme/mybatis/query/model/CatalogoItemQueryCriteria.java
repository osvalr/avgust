package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class CatalogoItemQueryCriteria extends DataCriteria {

private Integer id_estado; 
private Integer id_catalogo; 
private Integer id_catalogo_item; 

public Integer getId_estado() { 
  return id_estado; 
} 
public void setId_estado(Integer id_estado) { 
  this.id_estado = id_estado; 
} 
public Integer getId_catalogo() { 
  return id_catalogo; 
} 
public void setId_catalogo(Integer id_catalogo) { 
  this.id_catalogo = id_catalogo; 
} 
public Integer getId_catalogo_item() { 
  return id_catalogo_item; 
} 
public void setId_catalogo_item(Integer id_catalogo_item) { 
  this.id_catalogo_item = id_catalogo_item; 
} 

} 
