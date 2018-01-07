/*
* Copyright «©» 2018, SENAMHI All rights reserved.
*
* This file was generated by MybatisModelGenerator v.4.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.4.0] by JRaffo 
*/


/**
* The DocumentoVentaAgrupadoQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   05/01/2018 12:14:54
*/

package pe.com.kapcom.facturador.ws.model.mybatis.bean;

import pe.com.kapcom.util.BaseModel;

public class DocumentoVentaAgrupadoQuery extends BaseModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.String ventas_key; 

	private java.util.List<DocumentoVentaDetalleQuery> listDocumentoVentaDetalleQuery; 

	public java.lang.String getVentas_key() { 
	  return ventas_key; 
	} 
	public void setVentas_key(java.lang.String ventas_key) { 
	  this.ventas_key = ventas_key; 
	} 

	public java.util.List<DocumentoVentaDetalleQuery> getListDocumentoVentaDetalleQuery() { 
	  return listDocumentoVentaDetalleQuery; 
	} 
	public void setListDocumentoVentaDetalleQuery(java.util.List<DocumentoVentaDetalleQuery> listDocumentoVentaDetalleQuery) { 
	  this.listDocumentoVentaDetalleQuery = listDocumentoVentaDetalleQuery; 
	} 

} 
