/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ObtenerNumeroDocumentoQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:46:00
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModelCriteria;

public class ObtenerNumeroDocumentoQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String serie; 
	private String id_tipo_documento; 

	public ObtenerNumeroDocumentoQueryCriteria() {
		super();
	}
	
	public String getSerie() { 
	  return serie; 
	} 
	public void setSerie(String serie) { 
	  this.serie = serie; 
	} 
	public String getId_tipo_documento() { 
	  return id_tipo_documento; 
	} 
	public void setId_tipo_documento(String id_tipo_documento) { 
	  this.id_tipo_documento = id_tipo_documento; 
	} 

} 