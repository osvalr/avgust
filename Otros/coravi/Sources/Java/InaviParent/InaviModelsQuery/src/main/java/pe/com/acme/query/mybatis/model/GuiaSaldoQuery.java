/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaSaldoQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   17/03/2016 17:01:24
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class GuiaSaldoQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_guia_saldo; 
	private Integer id_guia; 
	private Double monto_amortizado; 
	private String fecha_saldo; 
	private Integer id_estado; 
	private String descrip_estado; 


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
	public Double getMonto_amortizado() { 
	  return monto_amortizado; 
	} 
	public void setMonto_amortizado(Double monto_amortizado) { 
	  this.monto_amortizado = monto_amortizado; 
	} 
	public String getFecha_saldo() { 
	  return fecha_saldo; 
	} 
	public void setFecha_saldo(String fecha_saldo) { 
	  this.fecha_saldo = fecha_saldo; 
	} 
	public Integer getId_estado() { 
	  return id_estado; 
	} 
	public void setId_estado(Integer id_estado) { 
	  this.id_estado = id_estado; 
	} 
	public String getDescrip_estado() { 
	  return descrip_estado; 
	} 
	public void setDescrip_estado(String descrip_estado) { 
	  this.descrip_estado = descrip_estado; 
	} 


} 