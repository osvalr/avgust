/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The FuncionalidadPorIdSesionQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   28/02/2016 16:46:19
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModel;

public class FuncionalidadPorIdSesionQuery extends AbstractModel implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Integer id_funcionalidad; 
	private String nombre_funcionalidad; 
	private String icon_cls; 
	private String alias_component; 
	private String component_controllers; 


	public Integer getId_funcionalidad() { 
	  return id_funcionalidad; 
	} 
	public void setId_funcionalidad(Integer id_funcionalidad) { 
	  this.id_funcionalidad = id_funcionalidad; 
	} 
	public String getNombre_funcionalidad() { 
	  return nombre_funcionalidad; 
	} 
	public void setNombre_funcionalidad(String nombre_funcionalidad) { 
	  this.nombre_funcionalidad = nombre_funcionalidad; 
	} 
	public String getIcon_cls() { 
	  return icon_cls; 
	} 
	public void setIcon_cls(String icon_cls) { 
	  this.icon_cls = icon_cls; 
	} 
	public String getAlias_component() { 
	  return alias_component; 
	} 
	public void setAlias_component(String alias_component) { 
	  this.alias_component = alias_component; 
	} 
	public String getComponent_controllers() { 
	  return component_controllers; 
	} 
	public void setComponent_controllers(String component_controllers) { 
	  this.component_controllers = component_controllers; 
	} 


} 