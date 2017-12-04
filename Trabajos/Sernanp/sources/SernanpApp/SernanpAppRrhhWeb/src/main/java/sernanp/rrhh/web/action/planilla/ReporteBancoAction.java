/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 15/06/2015 18:26:46
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteBancoService;
import sernanp.app.dao.query.domain.ReporteBancoFiltroQueryCriteria;
import sernanp.app.dao.query.domain.ReporteBancoQuery;
import sernanp.app.dao.query.domain.ReporteBancoQueryCriteria;
import sernanp.app.dao.query.mapper.ReporteBancoFiltroQueryMapper;
import sernanp.app.dao.query.mapper.ReporteBancoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteBancoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteBancoService reporteBancoService;
	
	private ReporteBancoQuery reporteBancoQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	String resultado;
	
	@SuppressWarnings("rawtypes")
	private Map parametros;
	
	public String listarReporteBanco(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("")? null: this.getParameter("c_fte_fto");
		String c_meta = this.getParameter("c_meta").equals("")? null: this.getParameter("c_meta");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		parametros	= new HashMap();
		
		if(c_meta == null){
			c_meta = "000-600";
		}
		
		String resultado_concatenacion = null;
		try{
		resultado_concatenacion = concatenarMeta(c_meta);
		
		}catch (BusinessException e) {
		    e.printStackTrace(); return null;
		}catch (Exception e) {
		    e.printStackTrace(); return null;
		}  
		
		ReporteBancoFiltroQueryCriteria criteria = new ReporteBancoFiltroQueryCriteria();
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setInt_anio(anio);
		criteria.setC_fte_fto(c_fte_fto);
        criteria.setC_meta(resultado_concatenacion);
        criteria.setSrl_id_regimen_contractual(int_regimen);
		
		listResult = reporteBancoService.getListByQuery(ReporteBancoFiltroQueryMapper.class, criteria);
		
		
		
		if(c_meta == "000-600"){
			
			parametros.put("strMeta", "Todos");
		}
		else{
			parametros.put("strMeta", "" + c_meta);
		}
		
        return resultado = tipo_reporte;
		
	
    }
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			ReporteBancoQueryCriteria reporteBancoQueryCriteria = this.loadCriteria(this.getHttpRequest(), ReporteBancoQueryCriteria.class);
			List<ReporteBancoQuery> listReporteBancoQuery = reporteBancoService.getListByQuery(ReporteBancoQueryMapper.class, reporteBancoQueryCriteria, start, limit);
			int total = reporteBancoService.getCountRowsByQuery(ReporteBancoQueryMapper.class, reporteBancoQueryCriteria);
			
			this.success(listReporteBancoQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteBancoService.create(reporteBancoQuery);
			this.success(reporteBancoQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteBancoService.save(reporteBancoQuery);
			this.success(reporteBancoQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteBancoService.remove(reporteBancoQuery);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String concatenarMeta(String meta){
		
		try{
			
		   String[] arrayMeta = meta.split(",");
	       String Cadena = "";
	       String Concatenado = "";
	          
	      
	    	   
	          for (int i = 0; i < arrayMeta.length; i++) {
	                  
	                  Cadena = arrayMeta[i];
	                  
	                  String[] arrayCadena = Cadena.split("-");
	                  
	                  int numElementos = arrayCadena.length;
	                  
	                 	                	  
	                 
	                  if (numElementos == 1){
	                	  
	                	  
	                		  
	                	 
		                   String  primer_numero = arrayCadena[0];
		                   String  segundo_numero = null;
		                   
		                  if (segundo_numero == null) {
		                       segundo_numero =  arrayCadena[0];
		                   }                   
		                       segundo_numero= arrayCadena[0];
		                   
		                   int int_primer_numero = Integer.parseInt(primer_numero);
		                   int int_segundo_numero = Integer.parseInt(segundo_numero);
		                   
		                   
		                   if(int_primer_numero > int_segundo_numero){
		                           
		                           break;
		                           
		                   }else{
		                                    
		                       for (Integer j = int_primer_numero; j <= int_segundo_numero ; j++) {
		                                                  
		                                           
		                           String str = Integer.toString(j);
		                                          
		                              if(str.length() < 2){
		                                   Concatenado += "'00" + j + "',";
		                              }
		                              else if(str.length() < 3){
		                                   Concatenado += "'0" + j + "',";
		                              }
		                              else{
		                                   Concatenado += "'" + j + "',";
		                              }
		                             
		                        }
                            }
	                	  
	                	 
	                	  
	                  }else {
	                	  
		               
		            	   
		               
	                	   String  primer_numero = arrayCadena[0];
		                   String  segundo_numero = arrayCadena[1];  
	                	  
		                   if (segundo_numero == null) {
		                       segundo_numero =  arrayCadena[0];
		                   }                   
		                       segundo_numero= arrayCadena[1];
		                   
		                   int int_primer_numero = Integer.parseInt(primer_numero);
		                   int int_segundo_numero = Integer.parseInt(segundo_numero);
		                   
		                   
		                   if(int_primer_numero > int_segundo_numero){
		                           break;
		                   }else{
		                                    
		                         for (Integer j = int_primer_numero; j <= int_segundo_numero ; j++) {
		                              
		                        	 String str = Integer.toString(j);
		                             
		                             if(str.length() < 2){
		                                  Concatenado += "'00" + j + "',";
		                             }
		                             else if(str.length() < 3){
		                                  Concatenado += "'0" + j + "',";
		                             }
		                             else{
		                                  Concatenado += "'" + j + "',";
		                             }
		                             
		                             
		                  }
		             }
		                   
		                   
		                   
	       }// end else
	                 
	  }
	      
	  Integer cantidad_caracteres = Concatenado.length();
	  String concatenacion_meta = Concatenado.substring(0, cantidad_caracteres - 1);
//	  System.out.println("concatenacion_meta: " + concatenacion_meta); 
	  
	  return concatenacion_meta;
	  
	  }catch (ArrayIndexOutOfBoundsException e) {
           	e.printStackTrace();
           	String concatenacion_meta = null;
			
			return concatenacion_meta;
		           		
	  }catch (StringIndexOutOfBoundsException e) {
		  	e.printStackTrace();
		  	String concatenacion_meta = null;
			
			return concatenacion_meta;
	  }catch (BusinessException e) {
		    e.printStackTrace();
		    String concatenacion_meta = null;
			
			return concatenacion_meta;
		    
	  }
		
		
		
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public ReporteBancoService getReporteBancoService() {
		return reporteBancoService;
	}

	public void setReporteBancoService(ReporteBancoService reporteBancoService) {
		this.reporteBancoService = reporteBancoService;
	}

	public ReporteBancoQuery getReporteBancoQuery() {
		return reporteBancoQuery;
	}

	public void setReporteBancoQuery(ReporteBancoQuery reporteBancoQuery) {
		this.reporteBancoQuery = reporteBancoQuery;
	}
	
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}
	
	public Map getParametros() {
		return parametros;
	}
	

	public void setParametros(Map parametros) {
		this.parametros = parametros;
	}

/*
<!-- Start Actions ReporteBanco -->
<action name="ReporteBancoView" class="sernanp.rrhh.web.action.planilla.ReporteBancoAction" method="view">
		<result type="json" />
</action>

<action name="ReporteBancoCreate" class="sernanp.rrhh.web.action.planilla.ReporteBancoAction" method="create">
		<result type="json" />
</action>

<action name="ReporteBancoSave" class="sernanp.rrhh.web.action.planilla.ReporteBancoAction" method="save">
		<result type="json" />
</action>

<action name="ReporteBancoRemove" class="sernanp.rrhh.web.action.planilla.ReporteBancoAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteBanco -->
*/

}
