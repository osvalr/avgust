/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The RolePorUsuarioAplicacionQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   27/02/2016 22:24:33
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class RolePorUsuarioAplicacionQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_usuario; 
	private Integer id_aplicacion; 
	private String nombre_rol; 

	public RolePorUsuarioAplicacionQueryCriteria() {
		super();
	}
	
	public Integer getId_usuario() { 
	  return id_usuario; 
	} 
	public void setId_usuario(Integer id_usuario) { 
	  this.id_usuario = id_usuario; 
	} 
	public Integer getId_aplicacion() { 
	  return id_aplicacion; 
	} 
	public void setId_aplicacion(Integer id_aplicacion) { 
	  this.id_aplicacion = id_aplicacion; 
	} 
	public String getNombre_rol() { 
	  return nombre_rol; 
	} 
	public void setNombre_rol(String nombre_rol) { 
	  this.nombre_rol = nombre_rol; 
	} 

} 