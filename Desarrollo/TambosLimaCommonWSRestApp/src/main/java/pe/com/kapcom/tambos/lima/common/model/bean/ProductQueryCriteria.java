/*
* Copyright «©» 2017, KAPCOM SOFTWARE S.R.L. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.4.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.4.0] by JRaffo 
*/

/**
* The ProductQueryCriteria class content the params in shape attributes
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   05/09/2017 12:15:39
*/

package pe.com.kapcom.tambos.lima.common.model.bean; 

import pe.com.kapcom.util.BaseModelCriteria;

public class ProductQueryCriteria extends BaseModelCriteria implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private java.lang.String tlisp_id; 
	private java.lang.String cod_marca; 
	private java.lang.String marca_produc; 
	private java.lang.String nom_produc; 
	private java.lang.String cod_produc;
	private boolean noPaging;

	public ProductQueryCriteria() {
		super();
	}
	
	public java.lang.String getTlisp_id() { 
	  return tlisp_id; 
	} 
	public void setTlisp_id(java.lang.String tlisp_id) { 
	  this.tlisp_id = tlisp_id; 
	} 
	public java.lang.String getCod_marca() { 
	  return cod_marca; 
	} 
	public void setCod_marca(java.lang.String cod_marca) { 
	  this.cod_marca = cod_marca; 
	} 
	public java.lang.String getMarca_produc() { 
	  return marca_produc; 
	} 
	public void setMarca_produc(java.lang.String marca_produc) { 
	  this.marca_produc = marca_produc; 
	} 
	public java.lang.String getNom_produc() { 
	  return nom_produc; 
	} 
	public void setNom_produc(java.lang.String nom_produc) { 
	  this.nom_produc = nom_produc; 
	} 
	public java.lang.String getCod_produc() { 
	  return cod_produc; 
	} 
	public void setCod_produc(java.lang.String cod_produc) { 
	  this.cod_produc = cod_produc; 
	}

    public boolean isNoPaging() {
        return noPaging;
    }

    public void setNoPaging(boolean noPaging) {
        this.noPaging = noPaging;
    }
}
