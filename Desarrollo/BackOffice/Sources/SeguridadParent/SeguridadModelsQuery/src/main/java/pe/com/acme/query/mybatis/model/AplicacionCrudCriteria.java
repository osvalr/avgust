/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The AplicacionCrudCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   01/03/2016 00:01:05
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class AplicacionCrudCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String nombre_aplicacion; 
	private Integer id_estado; 
	private Integer id_aplicacion; 

	public AplicacionCrudCriteria() {
		super();
	}
	
	public String getNombre_aplicacion() { 
	  return nombre_aplicacion; 
	} 
	public void setNombre_aplicacion(String nombre_aplicacion) { 
	  this.nombre_aplicacion = nombre_aplicacion; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	} 
	public Integer getId_aplicacion() { 
	  return id_aplicacion; 
	} 
	public void setId_aplicacion(Integer id_aplicacion) { 
	  this.id_aplicacion = id_aplicacion; 
	} 

} 