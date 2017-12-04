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
* DATE CREATE : 03/06/2015 07:19:09
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.planilla.service.ReportePadronTrabajadoresService;
import sernanp.app.dao.query.domain.RpPadronTrabajadoresQuery;
import sernanp.app.dao.query.domain.RpPadronTrabajadoresQueryCriteria;
import sernanp.app.dao.query.domain.RptEmitirNominaxMesxRCQueryCriteria;
import sernanp.app.dao.query.mapper.RpPadronTrabajadoresQueryMapper;
import sernanp.app.dao.query.mapper.RptEmitirNominaxMesxRCQueryMapper;

public class ReportePadronTrabajadoresAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportePadronTrabajadoresService reportePadronTrabajadoresService;
	
	private RpPadronTrabajadoresQuery rpPadronTrabajadoresQuery;
	
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	
	String resultado;
	

	public String padronTrabajadoresAction(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
//		String srl_id_fuente_financiamiento = this.getParameter("srl_id_fuente_financiamiento").equals("") ? null : this.getParameter("srl_id_fuente_financiamiento");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
//		Integer id_fuente = null;
		Integer int_regimen = null;
		
//		if(srl_id_fuente_financiamiento == null){
//			id_fuente = null;
//		}else{
//			id_fuente = Integer.parseInt(srl_id_fuente_financiamiento);
//			id_fuente.intValue();
//		}
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpPadronTrabajadoresQueryCriteria criteria = new RpPadronTrabajadoresQueryCriteria();
		
		criteria.setInt_id_periodo_mes(id_periodo);
//		criteria.setSrl_id_fuente_financiamiento(id_fuente);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);

		
		listResult= reportePadronTrabajadoresService.getListByQuery(RpPadronTrabajadoresQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
	
    }
	
	
	
	
	
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpPadronTrabajadoresQueryCriteria rpPadronTrabajadoresQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpPadronTrabajadoresQueryCriteria.class);
			List<RpPadronTrabajadoresQuery> listRpPadronTrabajadoresQuery = reportePadronTrabajadoresService.getListByQuery(RpPadronTrabajadoresQueryMapper.class, rpPadronTrabajadoresQueryCriteria, start, limit);
			int total = reportePadronTrabajadoresService.getCountRowsByQuery(RpPadronTrabajadoresQueryMapper.class, rpPadronTrabajadoresQueryCriteria);
			
			this.success(listRpPadronTrabajadoresQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reportePadronTrabajadoresService.create(rpPadronTrabajadoresQuery);
			this.success(rpPadronTrabajadoresQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reportePadronTrabajadoresService.save(rpPadronTrabajadoresQuery);
			this.success(rpPadronTrabajadoresQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reportePadronTrabajadoresService.remove(rpPadronTrabajadoresQuery);
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
	
	public ReportePadronTrabajadoresService getReportePadronTrabajadoresService() {
		return reportePadronTrabajadoresService;
	}

	public void setReportePadronTrabajadoresService(ReportePadronTrabajadoresService reportePadronTrabajadoresService) {
		this.reportePadronTrabajadoresService = reportePadronTrabajadoresService;
	}

	public RpPadronTrabajadoresQuery getRpPadronTrabajadoresQuery() {
		return rpPadronTrabajadoresQuery;
	}

	public void setRpPadronTrabajadoresQuery(RpPadronTrabajadoresQuery rpPadronTrabajadoresQuery) {
		this.rpPadronTrabajadoresQuery = rpPadronTrabajadoresQuery;
	}








	public List getListResult() {
		return listResult;
	}








	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReportePadronTrabajadores -->
<action name="ReportePadronTrabajadoresView" class="sernanp.rrhh.web.action.planilla.ReportePadronTrabajadoresAction" method="view">
		<result type="json" />
</action>

<action name="ReportePadronTrabajadoresCreate" class="sernanp.rrhh.web.action.planilla.ReportePadronTrabajadoresAction" method="create">
		<result type="json" />
</action>

<action name="ReportePadronTrabajadoresSave" class="sernanp.rrhh.web.action.planilla.ReportePadronTrabajadoresAction" method="save">
		<result type="json" />
</action>

<action name="ReportePadronTrabajadoresRemove" class="sernanp.rrhh.web.action.planilla.ReportePadronTrabajadoresAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReportePadronTrabajadores -->
*/

}
