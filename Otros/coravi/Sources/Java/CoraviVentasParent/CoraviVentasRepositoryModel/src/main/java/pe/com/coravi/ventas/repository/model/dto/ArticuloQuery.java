/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ArticuloQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:52:10
*/

package pe.com.coravi.ventas.repository.model.dto;


import pe.com.kapcom.util.AbstractModel;

public class ArticuloQuery extends AbstractModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id_articulo;
	private String codigo_articulo;
	private String nombre_articulo; 
	private Integer id_estado; 
	private String descrip_estado; 


	public Integer getId_articulo() { 
	  return id_articulo; 
	} 
	public void setId_articulo(Integer id_articulo) { 
	  this.id_articulo = id_articulo; 
	} 
	public String getNombre_articulo() { 
	  return nombre_articulo; 
	} 
	public void setNombre_articulo(String nombre_articulo) { 
	  this.nombre_articulo = nombre_articulo; 
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

	public String getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	@Override
	public String toString() {
		return "ArticuloQuery{" +
				"id_articulo=" + id_articulo +
				", codigo_articulo='" + codigo_articulo + '\'' +
				", nombre_articulo='" + nombre_articulo + '\'' +
				", id_estado=" + id_estado +
				", descrip_estado='" + descrip_estado + '\'' +
				'}';
	}
}