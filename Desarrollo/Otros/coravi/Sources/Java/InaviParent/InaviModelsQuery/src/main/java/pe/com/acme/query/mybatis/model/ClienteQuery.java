/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ClienteQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   12/03/2016 12:20:22
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class ClienteQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_persona; 
	private String nombres; 


	public Integer getId_persona() { 
	  return id_persona; 
	} 
	public void setId_persona(Integer id_persona) { 
	  this.id_persona = id_persona; 
	} 
	public String getNombres() { 
	  return nombres; 
	} 
	public void setNombres(String nombres) { 
	  this.nombres = nombres; 
	} 


} 