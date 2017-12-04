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
* DATE CREATE : 23/05/2015 14:01:52
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.seleccion.service.ReporteDocumentoConsolidadoConvocatoriaService;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaQuery;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaQueryCriteria;
import sernanp.app.dao.query.mapper.RpDocumentoConsolidadoConvocatoriaQueryMapper;

public class ReporteDocumentoConsolidadoConvocatoriaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteDocumentoConsolidadoConvocatoriaService reporteDocumentoConsolidadoConvocatoriaService;
	
	private RpDocumentoConsolidadoConvocatoriaQuery rpDocumentoConsolidadoConvocatoriaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpDocumentoConsolidadoConvocatoriaQueryCriteria rpDocumentoConsolidadoConvocatoriaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpDocumentoConsolidadoConvocatoriaQueryCriteria.class);
			List<RpDocumentoConsolidadoConvocatoriaQuery> listRpDocumentoConsolidadoConvocatoriaQuery = reporteDocumentoConsolidadoConvocatoriaService.getListByQuery(RpDocumentoConsolidadoConvocatoriaQueryMapper.class, rpDocumentoConsolidadoConvocatoriaQueryCriteria, start, limit);
			int total = reporteDocumentoConsolidadoConvocatoriaService.getCountRowsByQuery(RpDocumentoConsolidadoConvocatoriaQueryMapper.class, rpDocumentoConsolidadoConvocatoriaQueryCriteria);
			
			this.success(listRpDocumentoConsolidadoConvocatoriaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteDocumentoConsolidadoConvocatoriaService.create(rpDocumentoConsolidadoConvocatoriaQuery);
			this.success(rpDocumentoConsolidadoConvocatoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteDocumentoConsolidadoConvocatoriaService.save(rpDocumentoConsolidadoConvocatoriaQuery);
			this.success(rpDocumentoConsolidadoConvocatoriaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteDocumentoConsolidadoConvocatoriaService.remove(rpDocumentoConsolidadoConvocatoriaQuery);
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
	
	public ReporteDocumentoConsolidadoConvocatoriaService getReporteDocumentoConsolidadoConvocatoriaService() {
		return reporteDocumentoConsolidadoConvocatoriaService;
	}

	public void setReporteDocumentoConsolidadoConvocatoriaService(ReporteDocumentoConsolidadoConvocatoriaService reporteDocumentoConsolidadoConvocatoriaService) {
		this.reporteDocumentoConsolidadoConvocatoriaService = reporteDocumentoConsolidadoConvocatoriaService;
	}

	public RpDocumentoConsolidadoConvocatoriaQuery getRpDocumentoConsolidadoConvocatoriaQuery() {
		return rpDocumentoConsolidadoConvocatoriaQuery;
	}

	public void setRpDocumentoConsolidadoConvocatoriaQuery(RpDocumentoConsolidadoConvocatoriaQuery rpDocumentoConsolidadoConvocatoriaQuery) {
		this.rpDocumentoConsolidadoConvocatoriaQuery = rpDocumentoConsolidadoConvocatoriaQuery;
	}

/*
<!-- Start Actions ReporteDocumentoConsolidadoConvocatoria -->
<action name="ReporteDocumentoConsolidadoConvocatoriaView" class="sernanp.rrhh.web.action.seleccion.ReporteDocumentoConsolidadoConvocatoriaAction" method="view">
		<result type="json" />
</action>

<action name="ReporteDocumentoConsolidadoConvocatoriaCreate" class="sernanp.rrhh.web.action.seleccion.ReporteDocumentoConsolidadoConvocatoriaAction" method="create">
		<result type="json" />
</action>

<action name="ReporteDocumentoConsolidadoConvocatoriaSave" class="sernanp.rrhh.web.action.seleccion.ReporteDocumentoConsolidadoConvocatoriaAction" method="save">
		<result type="json" />
</action>

<action name="ReporteDocumentoConsolidadoConvocatoriaRemove" class="sernanp.rrhh.web.action.seleccion.ReporteDocumentoConsolidadoConvocatoriaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteDocumentoConsolidadoConvocatoria -->
*/

}
