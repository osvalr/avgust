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
* DATE CREATE : 30/05/2015 17:26:51
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ResumenPlanillaPagosAfpService;
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpNetQueryCriteria;
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpQuery;
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpQueryCriteria;
import sernanp.app.dao.query.mapper.ResumenPlanillaPagosAfpNetQueryMapper;
import sernanp.app.dao.query.mapper.ResumenPlanillaPagosAfpQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ResumenPlanillaPagosAfpAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ResumenPlanillaPagosAfpService resumenPlanillaPagosAfpService;
	
	private ResumenPlanillaPagosAfpQuery resumenPlanillaPagosAfpQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Map reportParam;
	
	String resultado;
	
	public String listarResumenPlanillaPagoAfp(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
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
		
		ResumenPlanillaPagosAfpQueryCriteria criteria = new ResumenPlanillaPagosAfpQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setSrl_id_regimen_pensionario(int_pensionario);
		criteria.setInt_anio(anio);
		
//		System.out.println("Generando Reporte AFPs - int_regimen --> " + int_regimen);
		listResult = resumenPlanillaPagosAfpService.getListByQuery(ResumenPlanillaPagosAfpQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
		
	}
	
	
	public String listarResumenPlanillaPagoAfpNet(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String c_fte_fto = this.getParameter("c_fte_fto").equals("") ? null : this.getParameter("c_fte_fto");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
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
		
		ResumenPlanillaPagosAfpNetQueryCriteria criteria = new ResumenPlanillaPagosAfpNetQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setC_fte_fto(c_fte_fto);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setSrl_id_regimen_pensionario(int_pensionario);
		criteria.setInt_anio(anio);

//		System.out.println("Generando Reporte AFPNet - int_regimen --> " + int_regimen);
		listResult = resumenPlanillaPagosAfpService.getListByQuery(ResumenPlanillaPagosAfpNetQueryMapper.class, criteria);
		
		if (listResult.size() > 0){
			String ruta = PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");
			
			reportParam = new HashMap();

			reportParam.put("logo", ruta);		
	
		}
		
        return resultado = tipo_reporte;
		
		
	}
		
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			ResumenPlanillaPagosAfpQueryCriteria resumenPlanillaPagosAfpQueryCriteria = this.loadCriteria(this.getHttpRequest(), ResumenPlanillaPagosAfpQueryCriteria.class);
			List<ResumenPlanillaPagosAfpQuery> listResumenPlanillaPagosAfpQuery = resumenPlanillaPagosAfpService.getListByQuery(ResumenPlanillaPagosAfpQueryMapper.class, resumenPlanillaPagosAfpQueryCriteria, start, limit);
			int total = resumenPlanillaPagosAfpService.getCountRowsByQuery(ResumenPlanillaPagosAfpQueryMapper.class, resumenPlanillaPagosAfpQueryCriteria);
			
			this.success(listResumenPlanillaPagosAfpQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			resumenPlanillaPagosAfpService.create(resumenPlanillaPagosAfpQuery);
			this.success(resumenPlanillaPagosAfpQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			resumenPlanillaPagosAfpService.save(resumenPlanillaPagosAfpQuery);
			this.success(resumenPlanillaPagosAfpQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			resumenPlanillaPagosAfpService.remove(resumenPlanillaPagosAfpQuery);
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
	
	public ResumenPlanillaPagosAfpService getResumenPlanillaPagosAfpService() {
		return resumenPlanillaPagosAfpService;
	}

	public void setResumenPlanillaPagosAfpService(ResumenPlanillaPagosAfpService resumenPlanillaPagosAfpService) {
		this.resumenPlanillaPagosAfpService = resumenPlanillaPagosAfpService;
	}

	public ResumenPlanillaPagosAfpQuery getResumenPlanillaPagosAfpQuery() {
		return resumenPlanillaPagosAfpQuery;
	}

	public void setResumenPlanillaPagosAfpQuery(ResumenPlanillaPagosAfpQuery resumenPlanillaPagosAfpQuery) {
		this.resumenPlanillaPagosAfpQuery = resumenPlanillaPagosAfpQuery;
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


	public Map getReportParam() {
		return reportParam;
	}


	public void setReportParam(Map reportParam) {
		this.reportParam = reportParam;
	}

/*
<!-- Start Actions ResumenPlanillaPagosAfp -->
<action name="ResumenPlanillaPagosAfpView" class="sernanp.rrhh.web.action.planilla.ResumenPlanillaPagosAfpAction" method="view">
		<result type="json" />
</action>

<action name="ResumenPlanillaPagosAfpCreate" class="sernanp.rrhh.web.action.planilla.ResumenPlanillaPagosAfpAction" method="create">
		<result type="json" />
</action>

<action name="ResumenPlanillaPagosAfpSave" class="sernanp.rrhh.web.action.planilla.ResumenPlanillaPagosAfpAction" method="save">
		<result type="json" />
</action>

<action name="ResumenPlanillaPagosAfpRemove" class="sernanp.rrhh.web.action.planilla.ResumenPlanillaPagosAfpAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ResumenPlanillaPagosAfp -->
*/

}
