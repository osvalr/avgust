/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuildsForScoreQueryCriteria class conten the params in shape attributes 
* equivalents of an clause WHERE for SQL query.
*
* @author  Javier Raffo
* @version 1.0
* @since   10/04/2016 07:10:45
*/

package pe.com.acme.query.mybatis.model; 

import pe.com.acme.util.AbstractModelCriteria;

public class GuildsForScoreQueryCriteria extends AbstractModelCriteria implements java.io.Serializable  { 

	private static final long serialVersionUID = 1L;
	
	private String G_Name; 

	public GuildsForScoreQueryCriteria() {
		super();
	}
	
	public String getG_Name() { 
	  return G_Name; 
	} 
	public void setG_Name(String G_Name) { 
	  this.G_Name = G_Name; 
	} 

} 