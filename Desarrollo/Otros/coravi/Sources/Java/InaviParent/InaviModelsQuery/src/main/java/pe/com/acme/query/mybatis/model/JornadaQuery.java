/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The JornadaQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   09/03/2016 20:09:12
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class JornadaQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private String cod_jornada; 
	private String fecha_jornada; 


	public String getCod_jornada() { 
	  return cod_jornada; 
	} 
	public void setCod_jornada(String cod_jornada) { 
	  this.cod_jornada = cod_jornada; 
	} 
	public String getFecha_jornada() { 
	  return fecha_jornada; 
	} 
	public void setFecha_jornada(String fecha_jornada) { 
	  this.fecha_jornada = fecha_jornada; 
	} 


} 