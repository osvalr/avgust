/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaSaldoQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   17/03/2016 17:01:24
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class GuiaSaldoQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_guia_saldo; 
	private Integer id_guia; 

	public GuiaSaldoQueryCriteria() {
		super();
	}
	
	public Integer getId_guia_saldo() { 
	  return id_guia_saldo; 
	} 
	public void setId_guia_saldo(Integer id_guia_saldo) { 
	  this.id_guia_saldo = id_guia_saldo; 
	} 
	public Integer getId_guia() { 
	  return id_guia; 
	} 
	public void setId_guia(Integer id_guia) { 
	  this.id_guia = id_guia; 
	} 

} 