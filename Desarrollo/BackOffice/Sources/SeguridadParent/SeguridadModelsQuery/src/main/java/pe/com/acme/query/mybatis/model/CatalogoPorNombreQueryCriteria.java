/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The CatalogoPorNombreQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/02/2016 20:03:33
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class CatalogoPorNombreQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String nombre_catalogo; 

	public CatalogoPorNombreQueryCriteria() {
		super();
	}
	
	public String getNombre_catalogo() { 
	  return nombre_catalogo; 
	} 
	public void setNombre_catalogo(String nombre_catalogo) { 
	  this.nombre_catalogo = nombre_catalogo; 
	} 

} 