package com.acme.mybatis.query.model;

import com.acme.util.DataTranferObject;

public class ItemsByNameCatalogoQuery extends DataTranferObject implements java.io.Serializable {

private static final long serialVersionUID = 1L;
private Integer id_catalogo_item; 
private Integer valor_b; 
private String valor_a; 

public Integer getId_catalogo_item() { 
  return id_catalogo_item; 
} 
public void setId_catalogo_item(Integer id_catalogo_item) { 
  this.id_catalogo_item = id_catalogo_item; 
} 
public Integer getValor_b() { 
  return valor_b; 
} 
public void setValor_b(Integer valor_b) { 
  this.valor_b = valor_b; 
} 
public String getValor_a() { 
  return valor_a; 
} 
public void setValor_a(String valor_a) { 
  this.valor_a = valor_a; 
} 

} 
