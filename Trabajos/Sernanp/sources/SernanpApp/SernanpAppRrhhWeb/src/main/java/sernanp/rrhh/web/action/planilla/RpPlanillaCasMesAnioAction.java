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
* DATE CREATE : 07/05/2015 16:53:32
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.RpPlanillaCasMesAnioService;
import sernanp.app.dao.query.domain.RpPlanillaCasMesAnioQuery;
import sernanp.app.dao.query.domain.RpPlanillaCasMesAnioQueryCriteria;
import sernanp.app.dao.query.mapper.RpPlanillaCasMesAnioQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class RpPlanillaCasMesAnioAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RpPlanillaCasMesAnioService rpPlanillaCasMesAnioService;
	
	private RpPlanillaCasMesAnioQuery rpPlanillaCasMesAnioQuery;
	
	private RpPlanillaCasMesAnioQueryCriteria rpPlanillaCasMesAnioQueryCriteria;

	@SuppressWarnings("rawtypes")
	private List listResult;
	
	private String resultado;
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpPlanillaCasMesAnioQueryCriteria rpPlanillaCasMesAnioQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpPlanillaCasMesAnioQueryCriteria.class);
			List<RpPlanillaCasMesAnioQuery> listRpPlanillaCasMesAnioQuery = rpPlanillaCasMesAnioService.getListByQuery(RpPlanillaCasMesAnioQueryMapper.class, rpPlanillaCasMesAnioQueryCriteria, start, limit);
			int total = rpPlanillaCasMesAnioService.getCountRowsByQuery(RpPlanillaCasMesAnioQueryMapper.class, rpPlanillaCasMesAnioQueryCriteria);
			
			this.success(listRpPlanillaCasMesAnioQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String listarEmitirNominaxMesRegimen(){
		
	
			RpPlanillaCasMesAnioQueryCriteria criteria = new RpPlanillaCasMesAnioQueryCriteria();
			criteria.setInt_id_periodo_mes(1);
			
			listResult = rpPlanillaCasMesAnioService.getListByQuery(RpPlanillaCasMesAnioQueryMapper.class, criteria);
			
			resultado ="pdf";
			
			
		return resultado;
	}
	
	public String create(){
		
		try{
			
			rpPlanillaCasMesAnioService.create(rpPlanillaCasMesAnioQuery);
			this.success(rpPlanillaCasMesAnioQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rpPlanillaCasMesAnioService.save(rpPlanillaCasMesAnioQuery);
			this.success(rpPlanillaCasMesAnioQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rpPlanillaCasMesAnioService.remove(rpPlanillaCasMesAnioQuery);
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
	
	public RpPlanillaCasMesAnioService getRpPlanillaCasMesAnioService() {
		return rpPlanillaCasMesAnioService;
	}

	public void setRpPlanillaCasMesAnioService(RpPlanillaCasMesAnioService rpPlanillaCasMesAnioService) {
		this.rpPlanillaCasMesAnioService = rpPlanillaCasMesAnioService;
	}

	public RpPlanillaCasMesAnioQuery getRpPlanillaCasMesAnioQuery() {
		return rpPlanillaCasMesAnioQuery;
	}

	public void setRpPlanillaCasMesAnioQuery(RpPlanillaCasMesAnioQuery rpPlanillaCasMesAnioQuery) {
		this.rpPlanillaCasMesAnioQuery = rpPlanillaCasMesAnioQuery;
	}

	public RpPlanillaCasMesAnioQueryCriteria getRpPlanillaCasMesAnioQueryCriteria() {
		return rpPlanillaCasMesAnioQueryCriteria;
	}

	public void setRpPlanillaCasMesAnioQueryCriteria(
			RpPlanillaCasMesAnioQueryCriteria rpPlanillaCasMesAnioQueryCriteria) {
		this.rpPlanillaCasMesAnioQueryCriteria = rpPlanillaCasMesAnioQueryCriteria;
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
<!-- Start Actions RpPlanillaCasMesAnio -->
<action name="RpPlanillaCasMesAnioView" class="sernanp.rrhh.web.action.planilla.RpPlanillaCasMesAnioAction" method="view">
		<result type="json" />
</action>

<action name="RpPlanillaCasMesAnioCreate" class="sernanp.rrhh.web.action.planilla.RpPlanillaCasMesAnioAction" method="create">
		<result type="json" />
</action>

<action name="RpPlanillaCasMesAnioSave" class="sernanp.rrhh.web.action.planilla.RpPlanillaCasMesAnioAction" method="save">
		<result type="json" />
</action>

<action name="RpPlanillaCasMesAnioRemove" class="sernanp.rrhh.web.action.planilla.RpPlanillaCasMesAnioAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RpPlanillaCasMesAnio -->
*/

}
