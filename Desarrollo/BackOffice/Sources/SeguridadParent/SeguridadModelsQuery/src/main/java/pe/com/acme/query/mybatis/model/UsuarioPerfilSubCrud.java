/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The UsuarioPerfilSubCrud class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 19:46:43
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class UsuarioPerfilSubCrud extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_usuario; 
	private Integer id_perfil; 
	private String nombre_perfil; 
	private Integer id_estado; 
	private String descrip_estado; 


	public Integer getId_usuario() { 
	  return id_usuario; 
	} 
	public void setId_usuario(Integer id_usuario) { 
	  this.id_usuario = id_usuario; 
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