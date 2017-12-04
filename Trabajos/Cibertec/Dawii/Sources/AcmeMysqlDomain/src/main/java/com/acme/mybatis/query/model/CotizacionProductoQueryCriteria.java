package com.acme.mybatis.query.model;

import com.acme.util.DataCriteria;

public class CotizacionProductoQueryCriteria extends DataCriteria {

private Integer id_cotizacion_producto; 
private Integer id_cotizacion; 

public Integer getId_cotizacion_producto() { 
  return id_cotizacion_producto; 
} 
public void setId_cotizacion_producto(Integer id_cotizacion_producto) { 
  this.id_cotizacion_producto = id_cotizacion_producto; 
} 
public Integer getId_cotizacion() { 
  return id_cotizacion; 
} 
public void setId_cotizacion(Integer id_cotizacion) { 
  this.id_cotizacion = id_cotizacion; 
} 


} 
