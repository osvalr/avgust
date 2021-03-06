/*
* Copyright «©» 2018, SENAMHI All rights reserved.
*
* This file was generated by MybatisModelGenerator v.4.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.4.0] by JRaffo 
*/


/**
* The BoletaAnuladaQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   12/01/2018 22:08:31
*/

package pe.com.acme.invoiceelec.model.mybatis.query.dto;

import pe.com.acme.util.AbstractModel;

public class BoletaAnuladaQuery extends AbstractModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.String ruc_emisor; 
	private java.util.Date fecha_emision; 
	private java.lang.String f_tipo_doc; 
	private java.lang.String serie_doc; 
	private java.lang.String num_doc; 
	private java.lang.String tipo_doc_clie; 
	private java.lang.String num_doc_clie; 
	private java.lang.String r_tot_val_vta_op_gravadas; 
	private java.lang.String r_tot_val_vta_op_exoneradas; 
	private java.lang.String r_tot_val_vta_op_inafectas; 
	private java.lang.String r_sum_otros_c; 
	private java.lang.String r_sum_isc; 
	private java.lang.String r_sum_igv; 
	private java.lang.String r_sum_otros_t; 
	private java.lang.String r_monto_tot; 
	private java.lang.String tip_doc_mod; 
	private java.lang.String serie_doc_mod; 
	private java.lang.String num_doc_mod; 
	private java.lang.String regimen_perc; 
	private java.lang.String base_perc; 
	private java.lang.String monto_perc; 
	private java.lang.String total_cobrar; 
	private java.lang.String estado; 


	public java.lang.String getRuc_emisor() { 
	  return ruc_emisor; 
	} 
	public void setRuc_emisor(java.lang.String ruc_emisor) { 
	  this.ruc_emisor = ruc_emisor; 
	} 
	public java.util.Date getFecha_emision() { 
	  return fecha_emision; 
	} 
	public void setFecha_emision(java.util.Date fecha_emision) { 
	  this.fecha_emision = fecha_emision; 
	} 
	public java.lang.String getF_tipo_doc() { 
	  return f_tipo_doc; 
	} 
	public void setF_tipo_doc(java.lang.String f_tipo_doc) { 
	  this.f_tipo_doc = f_tipo_doc; 
	} 
	public java.lang.String getSerie_doc() { 
	  return serie_doc; 
	} 
	public void setSerie_doc(java.lang.String serie_doc) { 
	  this.serie_doc = serie_doc; 
	} 
	public java.lang.String getNum_doc() { 
	  return num_doc; 
	} 
	public void setNum_doc(java.lang.String num_doc) { 
	  this.num_doc = num_doc; 
	} 
	public java.lang.String getTipo_doc_clie() { 
	  return tipo_doc_clie; 
	} 
	public void setTipo_doc_clie(java.lang.String tipo_doc_clie) { 
	  this.tipo_doc_clie = tipo_doc_clie; 
	} 
	public java.lang.String getNum_doc_clie() { 
	  return num_doc_clie; 
	} 
	public void setNum_doc_clie(java.lang.String num_doc_clie) { 
	  this.num_doc_clie = num_doc_clie; 
	} 
	public java.lang.String getR_tot_val_vta_op_gravadas() { 
	  return r_tot_val_vta_op_gravadas; 
	} 
	public void setR_tot_val_vta_op_gravadas(java.lang.String r_tot_val_vta_op_gravadas) { 
	  this.r_tot_val_vta_op_gravadas = r_tot_val_vta_op_gravadas; 
	} 
	public java.lang.String getR_tot_val_vta_op_exoneradas() { 
	  return r_tot_val_vta_op_exoneradas; 
	} 
	public void setR_tot_val_vta_op_exoneradas(java.lang.String r_tot_val_vta_op_exoneradas) { 
	  this.r_tot_val_vta_op_exoneradas = r_tot_val_vta_op_exoneradas; 
	} 
	public java.lang.String getR_tot_val_vta_op_inafectas() { 
	  return r_tot_val_vta_op_inafectas; 
	} 
	public void setR_tot_val_vta_op_inafectas(java.lang.String r_tot_val_vta_op_inafectas) { 
	  this.r_tot_val_vta_op_inafectas = r_tot_val_vta_op_inafectas; 
	} 
	public java.lang.String getR_sum_otros_c() { 
	  return r_sum_otros_c; 
	} 
	public void setR_sum_otros_c(java.lang.String r_sum_otros_c) { 
	  this.r_sum_otros_c = r_sum_otros_c; 
	} 
	public java.lang.String getR_sum_isc() { 
	  return r_sum_isc; 
	} 
	public void setR_sum_isc(java.lang.String r_sum_isc) { 
	  this.r_sum_isc = r_sum_isc; 
	} 
	public java.lang.String getR_sum_igv() { 
	  return r_sum_igv; 
	} 
	public void setR_sum_igv(java.lang.String r_sum_igv) { 
	  this.r_sum_igv = r_sum_igv; 
	} 
	public java.lang.String getR_sum_otros_t() { 
	  return r_sum_otros_t; 
	} 
	public void setR_sum_otros_t(java.lang.String r_sum_otros_t) { 
	  this.r_sum_otros_t = r_sum_otros_t; 
	} 
	public java.lang.String getR_monto_tot() { 
	  return r_monto_tot; 
	} 
	public void setR_monto_tot(java.lang.String r_monto_tot) { 
	  this.r_monto_tot = r_monto_tot; 
	} 
	public java.lang.String getTip_doc_mod() { 
	  return tip_doc_mod; 
	} 
	public void setTip_doc_mod(java.lang.String tip_doc_mod) { 
	  this.tip_doc_mod = tip_doc_mod; 
	} 
	public java.lang.String getSerie_doc_mod() { 
	  return serie_doc_mod; 
	} 
	public void setSerie_doc_mod(java.lang.String serie_doc_mod) { 
	  this.serie_doc_mod = serie_doc_mod; 
	} 
	public java.lang.String getNum_doc_mod() { 
	  return num_doc_mod; 
	} 
	public void setNum_doc_mod(java.lang.String num_doc_mod) { 
	  this.num_doc_mod = num_doc_mod; 
	} 
	public java.lang.String getRegimen_perc() { 
	  return regimen_perc; 
	} 
	public void setRegimen_perc(java.lang.String regimen_perc) { 
	  this.regimen_perc = regimen_perc; 
	} 
	public java.lang.String getBase_perc() { 
	  return base_perc; 
	} 
	public void setBase_perc(java.lang.String base_perc) { 
	  this.base_perc = base_perc; 
	} 
	public java.lang.String getMonto_perc() { 
	  return monto_perc; 
	} 
	public void setMonto_perc(java.lang.String monto_perc) { 
	  this.monto_perc = monto_perc; 
	} 
	public java.lang.String getTotal_cobrar() { 
	  return total_cobrar; 
	} 
	public void setTotal_cobrar(java.lang.String total_cobrar) { 
	  this.total_cobrar = total_cobrar; 
	} 
	public java.lang.String getEstado() { 
	  return estado; 
	} 
	public void setEstado(java.lang.String estado) { 
	  this.estado = estado; 
	} 


} 
