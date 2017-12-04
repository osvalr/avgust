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
* DATE CREATE : 11/06/2015 14:14:52
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteResumenAltasBajasService;
import sernanp.app.business.core.planilla.service.ReporteResumenGeneralPlanillaService;
import sernanp.app.dao.query.domain.ReporteResumenAltasBajasQuery;
import sernanp.app.dao.query.domain.ReporteResumenAltasBajasQueryCriteria;
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQuery;
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQueryCriteria;
import sernanp.app.dao.query.mapper.ReporteResumenAltasBajasQueryMapper;
import sernanp.app.dao.query.mapper.ReporteResumenGeneralPlanillaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteResumenAltasBajasAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenAltasBajasService reporteResumenAltasBajasService;
	
	@Autowired
	private ReporteResumenGeneralPlanillaService reporteResumenGeneralPlanillaService;
	
	private ReporteResumenAltasBajasQuery reporteResumenAltasBajasQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	String resultado;
	
	public String reporteResumenAltasBajas(){
		
		String int_estado = this.getParameter("int_estado").equals("") ? null : this.getParameter("int_estado");
		
		String tipo_reporte = "xls";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		Integer estado;
		
		if(int_estado == null){
			estado = null;
		}else{
			estado = Integer.parseInt(int_estado);
			estado.intValue();
		}
		
		ReporteResumenAltasBajasQueryCriteria criteria = new ReporteResumenAltasBajasQueryCriteria();
		criteria.setInt_anio(year);
		criteria.setInt_estado(estado);
		

		
		listResult= reporteResumenAltasBajasService.getListByQuery(ReporteResumenAltasBajasQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
	}
	
	public String view(){
		
//		try{
//			
//			int start = this.getIntegerParameter("start");
//			int limit = this.getIntegerParameter("limit");
//			
//			ReporteResumenAltasBajasQueryCriteria reporteResumenGeneralPlanillaQueryCriteria = this.loadCriteria(this.getHttpRequest(), ReporteResumenAltasBajasQueryCriteria.class);
//			List<ReporteResumenAltasBajasQuery> listReporteResumenGeneralPlanillaQuery = reporteResumenGeneralPlanillaService.getListByQuery(ReporteResumenAltasBajasQueryMapper.class, reporteResumenGeneralPlanillaQueryCriteria, start, limit);
//			int total = reporteResumenGeneralPlanillaService.getCountRowsByQuery(ReporteResumenAltasBajasQueryMapper.class, reporteResumenGeneralPlanillaQueryCriteria);
//			
//			this.success(listReporteResumenGeneralPlanillaQuery,total);
//			
//		}catch(BusinessException e){
//			this.exception(e.getMessage());
//		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenAltasBajasService.create(reporteResumenAltasBajasQuery);
			this.success(reporteResumenAltasBajasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenAltasBajasService.save(reporteResumenAltasBajasQuery);
			this.success(reporteResumenAltasBajasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenAltasBajasService.remove(reporteResumenAltasBajasQuery);
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
	
	public ReporteResumenAltasBajasService getReporteResumenAltasBajasService() {
		return reporteResumenAltasBajasService;
	}

	public void setReporteResumenAltasBajasService(ReporteResumenAltasBajasService reporteResumenAltasBajasService) {
		this.reporteResumenAltasBajasService = reporteResumenAltasBajasService;
	}

	public ReporteResumenAltasBajasQuery getReporteResumenAltasBajasQuery() {
		return reporteResumenAltasBajasQuery;
	}

	public void setReporteResumenAltasBajasQuery(ReporteResumenAltasBajasQuery reporteResumenAltasBajasQuery) {
		this.reporteResumenAltasBajasQuery = reporteResumenAltasBajasQuery;
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
<!-- Start Actions ReporteResumenAltasBajas -->
<action name="ReporteResumenAltasBajasView" class="sernanp.rrhh.web.action.planilla.ReporteResumenAltasBajasAction" method="view">
		<result type="json" />
</action>

<action name="ReporteResumenAltasBajasCreate" class="sernanp.rrhh.web.action.planilla.ReporteResumenAltasBajasAction" method="create">
		<result type="json" />
</action>

<action name="ReporteResumenAltasBajasSave" class="sernanp.rrhh.web.action.planilla.ReporteResumenAltasBajasAction" method="save">
		<result type="json" />
</action>

<action name="ReporteResumenAltasBajasRemove" class="sernanp.rrhh.web.action.planilla.ReporteResumenAltasBajasAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteResumenAltasBajas -->
*/

}
