/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaRemisionQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:35:44
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModelCriteria;

public class GuiaRemisionQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Integer id_guia_remision; 
	private Integer id_comprobante_pago; 

	public GuiaRemisionQueryCriteria() {
		super();
	}
	
	public Integer getId_guia_remision() { 
	  return id_guia_remision; 
	} 
	public void setId_guia_remision(Integer id_guia_remision) { 
	  this.id_guia_remision = id_guia_remision; 
	} 
	public Integer getId_comprobante_pago() { 
	  return id_comprobante_pago; 
	} 
	public void setId_comprobante_pago(Integer id_comprobante_pago) { 
	  this.id_comprobante_pago = id_comprobante_pago; 
	} 

} 