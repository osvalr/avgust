package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class CatalogoQueryCriteria extends DataCriteria {

private Integer id_catalogo;
private String nombre_catalogo; 
private Integer id_estado; 

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
public Integer getId_estado() { 
  return id_estado; 
} 
public void setId_estado(Integer id_estado) { 
  this.id_estado = id_estado; 
} 

} 
