/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The RolPorAplicacionQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 20:27:34
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class RolPorAplicacionQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_rol; 
	private String nombre_rol; 


	public Integer getId_rol() { 
	  return id_rol; 
	} 
	public void setId_rol(Integer id_rol) { 
	  this.id_rol = id_rol; 
	} 
	public String getNombre_rol() { 
	  return nombre_rol; 
	} 
	public void setNombre_rol(String nombre_rol) { 
	  this.nombre_rol = nombre_rol; 
	} 


} 