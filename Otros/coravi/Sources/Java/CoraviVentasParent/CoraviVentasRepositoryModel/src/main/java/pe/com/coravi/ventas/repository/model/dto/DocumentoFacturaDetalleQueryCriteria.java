/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The DocumentoFacturaDetalleQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   13/09/2016 05:03:11
*/

package pe.com.coravi.ventas.repository.model.dto;

import pe.com.kapcom.util.AbstractModelCriteria;

public class DocumentoFacturaDetalleQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Integer id_comprobante_item;
	private Integer id_comprobante_pago;

	public DocumentoFacturaDetalleQueryCriteria() {
		super();
	}

	public Integer getId_comprobante_item() {
		return id_comprobante_item;
	}

	public void setId_comprobante_item(Integer id_comprobante_item) {
		this.id_comprobante_item = id_comprobante_item;
	}

	public Integer getId_comprobante_pago() {
		return id_comprobante_pago;
	}

	public void setId_comprobante_pago(Integer id_comprobante_pago) {
		this.id_comprobante_pago = id_comprobante_pago;
	}
}