/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The SubModelQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   21/02/2016 23:55:02
*/

package pe.com.jrtotem.app.generator.mybatis.query.domain; 

import pe.com.jrtotem.app.generator.util.AbstractModelCriteria;

public class SubModelQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	private Integer id_model_input_parent; 

	public SubModelQueryCriteria() {
		super();
	}
	
	public Integer getId_model_input_parent() { 
	  return id_model_input_parent; 
	} 
	public void setId_model_input_parent(Integer id_model_input_parent) { 
	  this.id_model_input_parent = id_model_input_parent; 
	} 

} 