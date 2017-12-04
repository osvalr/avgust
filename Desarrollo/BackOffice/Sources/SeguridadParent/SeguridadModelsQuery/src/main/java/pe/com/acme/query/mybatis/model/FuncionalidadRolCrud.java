/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The FuncionalidadRolCrud class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 17:39:33
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class FuncionalidadRolCrud extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_funcionalidad; 
	private Integer id_perfil; 
	private String nombre_perfil; 
	private Integer id_aplicacion; 
	private String nombre_aplicacion; 
	private Integer id_rol; 
	private String nombre_rol; 
	private String nombre_funcionalidad; 
	private Integer id_estado; 
	private String descrip_estado; 


	public Integer getId_funcionalidad() { 
	  return id_funcionalidad; 
	} 
	public void setId_funcionalidad(Integer id_funcionalidad) { 
	  this.id_funcionalidad = id_funcionalidad; 
	} 
	public Integer getId_perfil() { 
	  return id_perfil; 
	} 
	public void setId_perfil(Integer id_perfil) { 
	  this.id_perfil = id_perfil; 
	} 
	public String getNombre_perfil() { 
	  return nombre_perfil; 
	} 
	public void setNombre_perfil(String nombre_perfil) { 
	  this.nombre_perfil = nombre_perfil; 
	} 
	public Integer getId_aplicacion() { 
	  return id_aplicacion; 
	} 
	public void setId_aplicacion(Integer id_aplicacion) { 
	  this.id_aplicacion = id_aplicacion; 
	} 
	public String getNombre_aplicacion() { 
	  return nombre_aplicacion; 
	} 
	public void setNombre_aplicacion(String nombre_aplicacion) { 
	  this.nombre_aplicacion = nombre_aplicacion; 
	} 
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
	public String getNombre_funcionalidad() { 
	  return nombre_funcionalidad; 
	} 
	public void setNombre_funcionalidad(String nombre_funcionalidad) { 
	  this.nombre_funcionalidad = nombre_funcionalidad; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	} 
	public String getDescrip_estado() { 
	  return descrip_estado; 
	} 
	public void setDescrip_estado(String descrip_estado) { 
	  this.descrip_estado = descrip_estado; 
	} 


} 