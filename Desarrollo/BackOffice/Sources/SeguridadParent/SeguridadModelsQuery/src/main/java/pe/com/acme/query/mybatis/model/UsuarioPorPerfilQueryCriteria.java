/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The UsuarioPorPerfilQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 22:31:59
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class UsuarioPorPerfilQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_perfil; 
	private String nombre_usuario; 

	public UsuarioPorPerfilQueryCriteria() {
		super();
	}
	
	public Integer getId_perfil() { 
	  return id_perfil; 
	} 
	public void setId_perfil(Integer id_perfil) { 
	  this.id_perfil = id_perfil; 
	} 
	public String getNombre_usuario() { 
	  return nombre_usuario; 
	} 
	public void setNombre_usuario(String nombre_usuario) { 
	  this.nombre_usuario = nombre_usuario; 
	} 

} 