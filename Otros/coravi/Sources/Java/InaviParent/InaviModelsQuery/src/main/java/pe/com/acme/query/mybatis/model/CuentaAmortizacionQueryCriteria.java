/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The CuentaAmortizacionQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/07/2016 18:14:51
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class CuentaAmortizacionQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_cuenta_x_cobrar; 
	private Integer id_cuenta_amortizacion; 

	public CuentaAmortizacionQueryCriteria() {
		super();
	}
	
	public Integer getId_cuenta_x_cobrar() { 
	  return id_cuenta_x_cobrar; 
	} 
	public void setId_cuenta_x_cobrar(Integer id_cuenta_x_cobrar) { 
	  this.id_cuenta_x_cobrar = id_cuenta_x_cobrar; 
	} 
	public Integer getId_cuenta_amortizacion() { 
	  return id_cuenta_amortizacion; 
	} 
	public void setId_cuenta_amortizacion(Integer id_cuenta_amortizacion) { 
	  this.id_cuenta_amortizacion = id_cuenta_amortizacion; 
	} 

} 