/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ProveedorPorNombreQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   14/03/2016 01:09:00
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class ProveedorPorNombreQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_proveedor; 
	private String nombre_proveedor; 


	public Integer getId_proveedor() { 
	  return id_proveedor; 
	} 
	public void setId_proveedor(Integer id_proveedor) { 
	  this.id_proveedor = id_proveedor; 
	} 
	public String getNombre_proveedor() { 
	  return nombre_proveedor; 
	} 
	public void setNombre_proveedor(String nombre_proveedor) { 
	  this.nombre_proveedor = nombre_proveedor; 
	} 


} 