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
* DATE CREATE : 23/05/2015 11:23:37
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.RptEmisionDetalleNominaxMesxRCService;
import sernanp.app.business.core.planilla.service.RptEmisionNominaxMesxRCService;
import sernanp.app.dao.query.domain.RptEmitirDetalleNominaxMesxRCQueryCriteria;
import sernanp.app.dao.query.domain.RptEmitirNominaxMesxRCQuery;
import sernanp.app.dao.query.domain.RptEmitirNominaxMesxRCQueryCriteria;
import sernanp.app.dao.query.mapper.RptEmitirDetalleNominaxMesxRCQueryMapper;
import sernanp.app.dao.query.mapper.RptEmitirNominaxMesxRCQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class RptEmisionNominaxMesxRCAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RptEmisionNominaxMesxRCService rptEmisionNominaxMesxRCService;
	
	@Autowired
	private RptEmisionDetalleNominaxMesxRCService rptEmisionDetalleNominaxMesxRCService;
	
	private RptEmitirNominaxMesxRCQuery rptEmitirNominaxMesxRCQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	
	String resultado;
	

	public String listarEmitirNominaxMesRegimen(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String srl_id_fuente_financiamiento = this.getParameter("srl_id_fuente_financiamiento").equals("") ? null : this.getParameter("srl_id_fuente_financiamiento");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer id_fuente = null;
		Integer int_regimen = null;
		
		if(srl_id_fuente_financiamiento == null){
			id_fuente = null;
		}else{
			id_fuente = Integer.parseInt(srl_id_fuente_financiamiento);
			id_fuente.intValue();
		}
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RptEmitirNominaxMesxRCQueryCriteria criteria = new RptEmitirNominaxMesxRCQueryCriteria();
		
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setSrl_id_fuente_financiamiento(id_fuente);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);
	

		
		listResult = rptEmisionNominaxMesxRCService.getListByQuery(RptEmitirNominaxMesxRCQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
	
    }
	
	public String listarEmitirDetalleNominaxMesRegimen(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		
		Integer int_regimen = null;
		
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RptEmitirDetalleNominaxMesxRCQueryCriteria criteria = new RptEmitirDetalleNominaxMesxRCQueryCriteria();
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setInt_anio(anio);
        criteria.setSrl_id_regimen_contractual(int_regimen);
        criteria.setFecha_mes(""+int_anio+"-"+int_id_periodo_mes+"-01");
		
		listResult = rptEmisionDetalleNominaxMesxRCService.getListByQuery(RptEmitirDetalleNominaxMesxRCQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
	
    }

	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RptEmitirNominaxMesxRCQueryCriteria rptEmitirNominaxMesxRCQueryCriteria = this.loadCriteria(this.getHttpRequest(), RptEmitirNominaxMesxRCQueryCriteria.class);
			List<RptEmitirNominaxMesxRCQuery> listRptEmitirNominaxMesxRCQuery = rptEmisionNominaxMesxRCService.getListByQuery(RptEmitirNominaxMesxRCQueryMapper.class, rptEmitirNominaxMesxRCQueryCriteria, start, limit);
			int total = rptEmisionNominaxMesxRCService.getCountRowsByQuery(RptEmitirNominaxMesxRCQueryMapper.class, rptEmitirNominaxMesxRCQueryCriteria);
			
			this.success(listRptEmitirNominaxMesxRCQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rptEmisionNominaxMesxRCService.create(rptEmitirNominaxMesxRCQuery);
			this.success(rptEmitirNominaxMesxRCQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rptEmisionNominaxMesxRCService.save(rptEmitirNominaxMesxRCQuery);
			this.success(rptEmitirNominaxMesxRCQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rptEmisionNominaxMesxRCService.remove(rptEmitirNominaxMesxRCQuery);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public RptEmisionNominaxMesxRCService getRptEmisionNominaxMesxRCService() {
		return rptEmisionNominaxMesxRCService;
	}

	public void setRptEmisionNominaxMesxRCService(RptEmisionNominaxMesxRCService rptEmisionNominaxMesxRCService) {
		this.rptEmisionNominaxMesxRCService = rptEmisionNominaxMesxRCService;
	}

	public RptEmitirNominaxMesxRCQuery getRptEmitirNominaxMesxRCQuery() {
		return rptEmitirNominaxMesxRCQuery;
	}

	public void setRptEmitirNominaxMesxRCQuery(RptEmitirNominaxMesxRCQuery rptEmitirNominaxMesxRCQuery) {
		this.rptEmitirNominaxMesxRCQuery = rptEmitirNominaxMesxRCQuery;
	}

	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}




    

}
