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
* DATE CREATE : 23/05/2015 14:15:27
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.seleccion.service.RpDocumentoConsolidadoConvocatoriaEtapasService;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria;
import sernanp.app.dao.query.mapper.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryMapper;

public class RpDocumentoConsolidadoConvocatoriaEtapasAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RpDocumentoConsolidadoConvocatoriaEtapasService rpDocumentoConsolidadoConvocatoriaEtapasService;
	
	private RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria.class);
			List<RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery> listRpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery = rpDocumentoConsolidadoConvocatoriaEtapasService.getListByQuery(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryMapper.class, rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria, start, limit);
			int total = rpDocumentoConsolidadoConvocatoriaEtapasService.getCountRowsByQuery(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryMapper.class, rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria);
			
			this.success(listRpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rpDocumentoConsolidadoConvocatoriaEtapasService.create(rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery);
			this.success(rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rpDocumentoConsolidadoConvocatoriaEtapasService.save(rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery);
			this.success(rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rpDocumentoConsolidadoConvocatoriaEtapasService.remove(rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery);
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
	
	public RpDocumentoConsolidadoConvocatoriaEtapasService getRpDocumentoConsolidadoConvocatoriaEtapasService() {
		return rpDocumentoConsolidadoConvocatoriaEtapasService;
	}

	public void setRpDocumentoConsolidadoConvocatoriaEtapasService(RpDocumentoConsolidadoConvocatoriaEtapasService rpDocumentoConsolidadoConvocatoriaEtapasService) {
		this.rpDocumentoConsolidadoConvocatoriaEtapasService = rpDocumentoConsolidadoConvocatoriaEtapasService;
	}

	public RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery getRpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery() {
		return rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery;
	}

	public void setRpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery) {
		this.rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery = rpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery;
	}

/*
<!-- Start Actions RpDocumentoConsolidadoConvocatoriaEtapas -->
<action name="RpDocumentoConsolidadoConvocatoriaEtapasView" class="sernanp.rrhh.web.action.seleccion.RpDocumentoConsolidadoConvocatoriaEtapasAction" method="view">
		<result type="json" />
</action>

<action name="RpDocumentoConsolidadoConvocatoriaEtapasCreate" class="sernanp.rrhh.web.action.seleccion.RpDocumentoConsolidadoConvocatoriaEtapasAction" method="create">
		<result type="json" />
</action>

<action name="RpDocumentoConsolidadoConvocatoriaEtapasSave" class="sernanp.rrhh.web.action.seleccion.RpDocumentoConsolidadoConvocatoriaEtapasAction" method="save">
		<result type="json" />
</action>

<action name="RpDocumentoConsolidadoConvocatoriaEtapasRemove" class="sernanp.rrhh.web.action.seleccion.RpDocumentoConsolidadoConvocatoriaEtapasAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RpDocumentoConsolidadoConvocatoriaEtapas -->
*/

}
