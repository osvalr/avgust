/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The CatalogoQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/02/2016 19:59:30
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class CatalogoQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_catalogo; 
	private String nombre_catalogo; 

	public CatalogoQueryCriteria() {
		super();
	}
	
	public Integer getId_catalogo() { 
	  return id_catalogo; 
	} 
	public void setId_catalogo(Integer id_catalogo) { 
	  this.id_catalogo = id_catalogo; 
	} 
	public String getNombre_catalogo() { 
	  return nombre_catalogo; 
	} 
	public void setNombre_catalogo(String nombre_catalogo) { 
	  this.nombre_catalogo = nombre_catalogo; 
	} 

} 