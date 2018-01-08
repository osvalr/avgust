/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   06/04/2016 00:17:21
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class GuiaQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_guia; 
	private Integer num_anio; 
	private Integer num_mes; 
	private Integer num_dia; 
	private Integer id_tipo_producto; 
	private String nombre_cliente; 
	private Integer id_estado; 
	private Integer id_cliente;

	public GuiaQueryCriteria() {
		super();
	}
	
	public Integer getId_guia() { 
	  return id_guia; 
	} 
	public void setId_guia(Integer id_guia) { 
	  this.id_guia = id_guia; 
	} 
	public Integer getNum_anio() { 
	  return num_anio; 
	} 
	public void setNum_anio(Integer num_anio) { 
	  this.num_anio = num_anio; 
	} 
	public Integer getNum_mes() { 
	  return num_mes; 
	} 
	public void setNum_mes(Integer num_mes) { 
	  this.num_mes = num_mes; 
	} 
	public Integer getNum_dia() { 
	  return num_dia; 
	} 
	public void setNum_dia(Integer num_dia) { 
	  this.num_dia = num_dia; 
	} 
	public Integer getId_tipo_producto() { 
	  return id_tipo_producto; 
	} 
	public void setId_tipo_producto(Integer id_tipo_producto) { 
	  this.id_tipo_producto = id_tipo_producto; 
	} 
	public String getNombre_cliente() { 
	  return nombre_cliente; 
	} 
	public void setNombre_cliente(String nombre_cliente) { 
	  this.nombre_cliente = nombre_cliente; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	} 

} 