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
* DATE CREATE : 12/05/2015 19:01:07
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReportePlanillaPagoONPService;
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQuery;
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQueryCriteria;
import sernanp.app.dao.query.mapper.RpPlanillaPagoONPQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReportePlanillaPagoONPAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportePlanillaPagoONPService reportePlanillaPagoONPService;
	
	private RpPlanillaPagoONPQuery rpPlanillaPagoONPQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	
	String resultado;
	
	public String listarPlanillaPagoONP(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String srl_id_regimen_pensionario = this.getParameter("srl_id_regimen_pensionario").equals("") ? null : this.getParameter("srl_id_regimen_pensionario");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		Integer int_pensionario = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		if(srl_id_regimen_pensionario == null){
			int_pensionario = null;
		}else{
			int_pensionario = Integer.parseInt(srl_id_regimen_pensionario);
			int_pensionario.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpPlanillaPagoONPQueryCriteria criteria = new RpPlanillaPagoONPQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setSrl_id_regimen_pensionario(int_pensionario);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setInt_anio(anio);
		
		
		listResult = reportePlanillaPagoONPService.getListByQuery(RpPlanillaPagoONPQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
				
	
    }
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpPlanillaPagoONPQueryCriteria rpPlanillaPagoONPQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpPlanillaPagoONPQueryCriteria.class);
			List<RpPlanillaPagoONPQuery> listRpPlanillaPagoONPQuery = reportePlanillaPagoONPService.getListByQuery(RpPlanillaPagoONPQueryMapper.class, rpPlanillaPagoONPQueryCriteria, start, limit);
			int total = reportePlanillaPagoONPService.getCountRowsByQuery(RpPlanillaPagoONPQueryMapper.class, rpPlanillaPagoONPQueryCriteria);
			
			this.success(listRpPlanillaPagoONPQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reportePlanillaPagoONPService.create(rpPlanillaPagoONPQuery);
			this.success(rpPlanillaPagoONPQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reportePlanillaPagoONPService.save(rpPlanillaPagoONPQuery);
			this.success(rpPlanillaPagoONPQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reportePlanillaPagoONPService.remove(rpPlanillaPagoONPQuery);
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
	
	public ReportePlanillaPagoONPService getReportePlanillaPagoONPService() {
		return reportePlanillaPagoONPService;
	}

	public void setReportePlanillaPagoONPService(ReportePlanillaPagoONPService reportePlanillaPagoONPService) {
		this.reportePlanillaPagoONPService = reportePlanillaPagoONPService;
	}

	public RpPlanillaPagoONPQuery getRpPlanillaPagoONPQuery() {
		return rpPlanillaPagoONPQuery;
	}

	public void setRpPlanillaPagoONPQuery(RpPlanillaPagoONPQuery rpPlanillaPagoONPQuery) {
		this.rpPlanillaPagoONPQuery = rpPlanillaPagoONPQuery;
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

/*
<!-- Start Actions ReportePlanillaPagoONP -->
<action name="ReportePlanillaPagoONPView" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoONPAction" method="view">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoONPCreate" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoONPAction" method="create">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoONPSave" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoONPAction" method="save">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoONPRemove" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoONPAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReportePlanillaPagoONP -->
*/

}
