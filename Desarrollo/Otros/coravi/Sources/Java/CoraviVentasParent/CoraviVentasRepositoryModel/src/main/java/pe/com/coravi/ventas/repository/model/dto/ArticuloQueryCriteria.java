/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ArticuloQueryCriteria class conten the params in shape attributes
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:52:10
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModelCriteria;

public class ArticuloQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String nombre_articulo; 
	private Integer id_articulo; 

	public ArticuloQueryCriteria() {
		super();
	}
	
	public String getNombre_articulo() { 
	  return nombre_articulo; 
	} 
	public void setNombre_articulo(String nombre_articulo) { 
	  this.nombre_articulo = nombre_articulo; 
	} 
	public Integer getId_articulo() { 
	  return id_articulo; 
	} 
	public void setId_articulo(Integer id_articulo) { 
	  this.id_articulo = id_articulo; 
	} 

} 