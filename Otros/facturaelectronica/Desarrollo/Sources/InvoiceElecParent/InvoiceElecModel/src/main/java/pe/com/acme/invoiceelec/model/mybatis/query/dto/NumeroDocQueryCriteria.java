/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The NumeroDocQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   11/07/2016 20:42:05
*/

package pe.com.acme.invoiceelec.model.mybatis.query.dto; 

import pe.com.acme.util.AbstractModelCriteria;

public class NumeroDocQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String emp_id; 
	private String tipdoc_id; 
	private String numf_serie; 

	public NumeroDocQueryCriteria() {
		super();
	}
	
	public String getEmp_id() { 
	  return emp_id; 
	} 
	public void setEmp_id(String emp_id) { 
	  this.emp_id = emp_id; 
	} 
	public String getTipdoc_id() { 
	  return tipdoc_id; 
	} 
	public void setTipdoc_id(String tipdoc_id) { 
	  this.tipdoc_id = tipdoc_id; 
	} 
	public String getNumf_serie() { 
	  return numf_serie; 
	} 
	public void setNumf_serie(String numf_serie) { 
	  this.numf_serie = numf_serie; 
	} 

} 