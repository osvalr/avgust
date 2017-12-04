/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpAppTemp.
*
* SernanpAppTemp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpAppTemp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpAppTemp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 02/06/2015 14:00:22
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReporteDetalleBoletaPersonalService;
import sernanp.app.dao.query.domain.RpDetalleBoletasPersonalQuery;
import sernanp.app.dao.query.domain.RpDetalleBoletasPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.RpDetalleBoletasPersonalQueryMapper;

public class ReporteDetalleBoletaPersonalAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteDetalleBoletaPersonalService reporteDetalleBoletaPersonalService;
	
	private RpDetalleBoletasPersonalQuery rpDetalleBoletasPersonalQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpDetalleBoletasPersonalQueryCriteria rpDetalleBoletasPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpDetalleBoletasPersonalQueryCriteria.class);
			List<RpDetalleBoletasPersonalQuery> listRpDetalleBoletasPersonalQuery = reporteDetalleBoletaPersonalService.getListByQuery(RpDetalleBoletasPersonalQueryMapper.class, rpDetalleBoletasPersonalQueryCriteria, start, limit);
			int total = reporteDetalleBoletaPersonalService.getCountRowsByQuery(RpDetalleBoletasPersonalQueryMapper.class, rpDetalleBoletasPersonalQueryCriteria);
			
			this.success(listRpDetalleBoletasPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteDetalleBoletaPersonalService.create(rpDetalleBoletasPersonalQuery);
			this.success(rpDetalleBoletasPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteDetalleBoletaPersonalService.save(rpDetalleBoletasPersonalQuery);
			this.success(rpDetalleBoletasPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteDetalleBoletaPersonalService.remove(rpDetalleBoletasPersonalQuery);
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
	
	public ReporteDetalleBoletaPersonalService getReporteDetalleBoletaPersonalService() {
		return reporteDetalleBoletaPersonalService;
	}

	public void setReporteDetalleBoletaPersonalService(ReporteDetalleBoletaPersonalService reporteDetalleBoletaPersonalService) {
		this.reporteDetalleBoletaPersonalService = reporteDetalleBoletaPersonalService;
	}

	public RpDetalleBoletasPersonalQuery getRpDetalleBoletasPersonalQuery() {
		return rpDetalleBoletasPersonalQuery;
	}

	public void setRpDetalleBoletasPersonalQuery(RpDetalleBoletasPersonalQuery rpDetalleBoletasPersonalQuery) {
		this.rpDetalleBoletasPersonalQuery = rpDetalleBoletasPersonalQuery;
	}

/*
<!-- Start Actions ReporteDetalleBoletaPersonal -->
<action name="ReporteDetalleBoletaPersonalView" class="sernanp.rrhh.web.action.planilla.ReporteDetalleBoletaPersonalAction" method="view">
		<result type="json" />
</action>

<action name="ReporteDetalleBoletaPersonalCreate" class="sernanp.rrhh.web.action.planilla.ReporteDetalleBoletaPersonalAction" method="create">
		<result type="json" />
</action>

<action name="ReporteDetalleBoletaPersonalSave" class="sernanp.rrhh.web.action.planilla.ReporteDetalleBoletaPersonalAction" method="save">
		<result type="json" />
</action>

<action name="ReporteDetalleBoletaPersonalRemove" class="sernanp.rrhh.web.action.planilla.ReporteDetalleBoletaPersonalAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions GestionarPostulante -->
*/

}
