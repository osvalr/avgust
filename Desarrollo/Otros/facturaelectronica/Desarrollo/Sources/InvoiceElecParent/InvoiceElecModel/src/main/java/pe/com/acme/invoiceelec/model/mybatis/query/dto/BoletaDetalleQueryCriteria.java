/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The BoletaDetalleQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   14/07/2016 04:08:14
*/

package pe.com.acme.invoiceelec.model.mybatis.query.dto; 

import pe.com.acme.util.AbstractModelCriteria;

public class BoletaDetalleQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String ventas_key; 
	private Integer emp_id; 

	public BoletaDetalleQueryCriteria() {
		super();
	}
	
	public String getVentas_key() { 
	  return ventas_key; 
	} 
	public void setVentas_key(String ventas_key) { 
	  this.ventas_key = ventas_key; 
	} 
	public Integer getEmp_id() { 
	  return emp_id; 
	} 
	public void setEmp_id(Integer emp_id) { 
	  this.emp_id = emp_id; 
	} 

} 