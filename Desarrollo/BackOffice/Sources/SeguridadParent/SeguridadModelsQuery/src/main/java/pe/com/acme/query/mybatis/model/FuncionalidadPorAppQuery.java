/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The FuncionalidadPorAppQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/02/2016 21:57:17
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class FuncionalidadPorAppQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_funcionalidad; 
	private Integer id_aplicacion; 
	private String nombre_funcionalidad; 


	public Integer getId_funcionalidad() { 
	  return id_funcionalidad; 
	} 
	public void setId_funcionalidad(Integer id_funcionalidad) { 
	  this.id_funcionalidad = id_funcionalidad; 
	} 
	public Integer getId_aplicacion() { 
	  return id_aplicacion; 
	} 
	public void setId_aplicacion(Integer id_aplicacion) { 
	  this.id_aplicacion = id_aplicacion; 
	} 
	public String getNombre_funcionalidad() { 
	  return nombre_funcionalidad; 
	} 
	public void setNombre_funcionalidad(String nombre_funcionalidad) { 
	  this.nombre_funcionalidad = nombre_funcionalidad; 
	} 


} 