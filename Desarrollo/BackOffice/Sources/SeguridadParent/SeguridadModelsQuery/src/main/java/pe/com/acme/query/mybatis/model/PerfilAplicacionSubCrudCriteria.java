/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The PerfilAplicacionSubCrudCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 16:45:53
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class PerfilAplicacionSubCrudCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_aplicacion; 
	private Integer id_perfil; 
	private Integer id_estado; 

	public PerfilAplicacionSubCrudCriteria() {
		super();
	}
	
	public Integer getId_aplicacion() { 
	  return id_aplicacion; 
	} 
	public void setId_aplicacion(Integer id_aplicacion) { 
	  this.id_aplicacion = id_aplicacion; 
	} 
	public Integer getId_perfil() { 
	  return id_perfil; 
	} 
	public void setId_perfil(Integer id_perfil) { 
	  this.id_perfil = id_perfil; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	} 

} 