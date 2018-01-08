/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ProveedorQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   18/03/2016 20:10:32
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class ProveedorQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_persona; 
	private String razon_social; 
	private String num_tipo_doc; 
	private Integer id_estado; 
	private String descrip_estado; 


	public Integer getId_persona() { 
	  return id_persona; 
	} 
	public void setId_persona(Integer id_persona) { 
	  this.id_persona = id_persona; 
	} 
	public String getRazon_social() { 
	  return razon_social; 
	} 
	public void setRazon_social(String razon_social) { 
	  this.razon_social = razon_social; 
	} 
	public String getNum_tipo_doc() { 
	  return num_tipo_doc; 
	} 
	public void setNum_tipo_doc(String num_tipo_doc) { 
	  this.num_tipo_doc = num_tipo_doc; 
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