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
* DATE CREATE : 26/05/2015 21:05:52
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.RptResumenPersonalAltasBajasService;
import sernanp.app.dao.query.domain.RptResumenPersonalAltasBajasQuery;
import sernanp.app.dao.query.domain.RptResumenPersonalAltasBajasQueryCriteria;
import sernanp.app.dao.query.mapper.RptResumenPersonalAltasBajasQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class RptResumenPersonalAltasBajasAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RptResumenPersonalAltasBajasService rptResumenPersonalAltasBajasService;
	
	private RptResumenPersonalAltasBajasQuery rptResumenPersonalAltasBajasQuery;
	
	String resultado;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	public String listarAltasBajasPersonal(){
		
		String ruc = this.getParameter("ruc").equals("") ? null : this.getParameter("ruc");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String numerodoc = this.getParameter("numerodoc").equals("") ? null : this.getParameter("numerodoc");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String int_estado = this.getParameter("int_estado").equals("") ? null : this.getParameter("int_estado");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer estado = null;
		Integer int_regimen = null;
		
		if (srl_id_regimen_contractual == null) {
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		if(int_estado == null){
			estado = null;
		}else{
			estado = Integer.parseInt(int_estado);
			estado.intValue();	
		}
			
		RptResumenPersonalAltasBajasQueryCriteria criteria = new RptResumenPersonalAltasBajasQueryCriteria();
		criteria.setInt_estado(estado);
		criteria.setNombre_completo(nombre_completo);
		criteria.setRuc(ruc);
		criteria.setNumerodoc(numerodoc);
		criteria.setSrl_id_regimen_contractual(int_regimen);

		
		listResult = rptResumenPersonalAltasBajasService.getListByQuery(RptResumenPersonalAltasBajasQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	
    }
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RptResumenPersonalAltasBajasQueryCriteria rptResumenPersonalAltasBajasQueryCriteria = this.loadCriteria(this.getHttpRequest(), RptResumenPersonalAltasBajasQueryCriteria.class);
			List<RptResumenPersonalAltasBajasQuery> listRptResumenPersonalAltasBajasQuery = rptResumenPersonalAltasBajasService.getListByQuery(RptResumenPersonalAltasBajasQueryMapper.class, rptResumenPersonalAltasBajasQueryCriteria, start, limit);
			int total = rptResumenPersonalAltasBajasService.getCountRowsByQuery(RptResumenPersonalAltasBajasQueryMapper.class, rptResumenPersonalAltasBajasQueryCriteria);
			
			this.success(listRptResumenPersonalAltasBajasQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rptResumenPersonalAltasBajasService.create(rptResumenPersonalAltasBajasQuery);
			this.success(rptResumenPersonalAltasBajasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rptResumenPersonalAltasBajasService.save(rptResumenPersonalAltasBajasQuery);
			this.success(rptResumenPersonalAltasBajasQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rptResumenPersonalAltasBajasService.remove(rptResumenPersonalAltasBajasQuery);
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
	
	public RptResumenPersonalAltasBajasService getRptResumenPersonalAltasBajasService() {
		return rptResumenPersonalAltasBajasService;
	}

	public void setRptResumenPersonalAltasBajasService(RptResumenPersonalAltasBajasService rptResumenPersonalAltasBajasService) {
		this.rptResumenPersonalAltasBajasService = rptResumenPersonalAltasBajasService;
	}

	public RptResumenPersonalAltasBajasQuery getRptResumenPersonalAltasBajasQuery() {
		return rptResumenPersonalAltasBajasQuery;
	}

	public void setRptResumenPersonalAltasBajasQuery(RptResumenPersonalAltasBajasQuery rptResumenPersonalAltasBajasQuery) {
		this.rptResumenPersonalAltasBajasQuery = rptResumenPersonalAltasBajasQuery;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}
	
	

/*
<!-- Start Actions RptResumenPersonalAltasBajas -->
<action name="RptResumenPersonalAltasBajasView" class="sernanp.rrhh.web.action.planilla.RptResumenPersonalAltasBajasAction" method="view">
		<result type="json" />
</action>

<action name="RptResumenPersonalAltasBajasCreate" class="sernanp.rrhh.web.action.planilla.RptResumenPersonalAltasBajasAction" method="create">
		<result type="json" />
</action>

<action name="RptResumenPersonalAltasBajasSave" class="sernanp.rrhh.web.action.planilla.RptResumenPersonalAltasBajasAction" method="save">
		<result type="json" />
</action>

<action name="RptResumenPersonalAltasBajasRemove" class="sernanp.rrhh.web.action.planilla.RptResumenPersonalAltasBajasAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RptResumenPersonalAltasBajas -->
*/

}
