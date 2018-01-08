/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ClienteNaturalQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   18/03/2016 19:19:56
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class ClienteNaturalQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_tipo_doc; 
	private Integer id_estado; 
	private Integer id_persona; 
	private String num_tipo_doc; 
	private String nombres_completos; 

	public ClienteNaturalQueryCriteria() {
		super();
	}
	
	public Integer getId_tipo_doc() { 
	  return id_tipo_doc; 
	} 
	public void setId_tipo_doc(Integer id_tipo_doc) { 
	  this.id_tipo_doc = id_tipo_doc; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	} 
	public Integer getId_persona() { 
	  return id_persona; 
	} 
	public void setId_persona(Integer id_persona) { 
	  this.id_persona = id_persona; 
	} 
	public String getNum_tipo_doc() { 
	  return num_tipo_doc; 
	} 
	public void setNum_tipo_doc(String num_tipo_doc) { 
	  this.num_tipo_doc = num_tipo_doc; 
	} 
	public String getNombres_completos() { 
	  return nombres_completos; 
	} 
	public void setNombres_completos(String nombres_completos) { 
	  this.nombres_completos = nombres_completos; 
	} 

} 