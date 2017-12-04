package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class ItemsByNameCatalogoQueryCriteria extends DataCriteria {

private String nombre_catalogo; 

public String getNombre_catalogo() { 
  return nombre_catalogo; 
} 
public void setNombre_catalogo(String nombre_catalogo) { 
  this.nombre_catalogo = nombre_catalogo; 
} 

} 
