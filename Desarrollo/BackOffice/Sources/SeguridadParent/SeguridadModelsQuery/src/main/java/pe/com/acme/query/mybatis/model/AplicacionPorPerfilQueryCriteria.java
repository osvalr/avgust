/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The AplicacionPorPerfilQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 17:51:52
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class AplicacionPorPerfilQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_perfil; 
	private String nombre_aplicacion; 

	public AplicacionPorPerfilQueryCriteria() {
		super();
	}
	
	public Integer getId_perfil() { 
	  return id_perfil; 
	} 
	public void setId_perfil(Integer id_perfil) { 
	  this.id_perfil = id_perfil; 
	} 
	public String getNombre_aplicacion() { 
	  return nombre_aplicacion; 
	} 
	public void setNombre_aplicacion(String nombre_aplicacion) { 
	  this.nombre_aplicacion = nombre_aplicacion; 
	} 

} 